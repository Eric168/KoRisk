package com.madai.service.approval.Impl;

import org.apache.commons.beanutils.BeanUtils;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.madai.model.approval.CreditScoreAutoAuditBaseIn;
import com.madai.model.approval.CreditScoreAutoAuditOneExtendIn;
import com.madai.model.approval.CreditScoreAutoAuditOneOut;
import com.madai.model.approval.CreditLine.CreditLineIn;
import com.madai.model.approval.CreditLine.CreditLineOut;
import com.madai.model.approval.ProductRate.ProductRateIn;
import com.madai.model.approval.ProductRate.ProductRateOut;
import com.madai.service.approval.CreditScoreAutoAuditService;


@Service(value="creditScoreAutoAuditService")
public class CreditScoreAutoAuditServiceImpl implements CreditScoreAutoAuditService{
	private static final Logger logger = LoggerFactory
            .getLogger(CreditScoreAutoAuditService.class);
	
	@Value("#{configProperties['kSessionLogPath']}")
	private String kSessionLogPath;
	
	@Override
	public CreditScoreAutoAuditOneOut creditScore(CreditScoreAutoAuditBaseIn creditScoreAutoAuditBaseIn) {
		logger.info("策略评分模型入参：creditScore{}",creditScoreAutoAuditBaseIn.toString());
		CreditScoreAutoAuditOneExtendIn csIn=new CreditScoreAutoAuditOneExtendIn();
		CreditScoreAutoAuditOneOut csOut=new CreditScoreAutoAuditOneOut();
		 try{
 		   KieServices ks = KieServices.Factory.get();
    	   KieContainer kContainer = ks.getKieClasspathContainer();
    	   KieSession kSession = kContainer.newKieSession("ksession-rules-AutoAuditOne");
 		       
           BeanUtils.copyProperties(csIn, creditScoreAutoAuditBaseIn);
       
 	       kSession.insert(csIn);
 	       kSession.insert(csOut);
 	       kSession.startProcess("CreditScoreAutoAudit.auditOneCreditScoreFlow");
 	       kSession.fireAllRules();
 	       kSession.dispose();  
 	       
 	      logger.info("策略评分模型出参：creditScore{}",csOut.toString());
 	       
 	   }catch(Exception t){
 		   t.printStackTrace();
 		   return null;
 	   }
		return csOut; 
	}
	
	@Override
	public CreditLineOut creditLine(CreditLineIn creditLineIn) throws Exception{
		logger.info("策略额度建议规则入参：creditLine{}",creditLineIn.toString());
		CreditLineIn clIn=new CreditLineIn();
		CreditLineOut clOut=new CreditLineOut();
		 
 		   KieServices ks = KieServices.Factory.get();
    	   KieContainer kContainer = ks.getKieClasspathContainer();
    	   KieSession kSession = kContainer.newKieSession("ksession-rules-CreditLine");
 		       
           BeanUtils.copyProperties(clIn, creditLineIn);
       
 	       kSession.insert(clIn);
 	       kSession.insert(clOut);
 	       kSession.startProcess("CreditScoreAutoAudit.CreditLineFlow");
 	       kSession.fireAllRules();
 	       kSession.dispose();  
 	       
 	      if(clOut.getAmount()>0 &&clOut.getAmount()<10000 
 	    		    &&
 	    		  (("Eshetong").equals(clOut.getProductCode())
 	    		   ||
 	    		   ("Ewangtong").equals(clOut.getProductCode())
                   )
            ){
 	    	  
 	    	 clOut.setAmount(clOut.getAmount()*(-1));
 	      }
 	      
 	      if(clOut.getAmount()>0&&clOut.getAmount()<10000
 	    		  &&
 	    		 ("Elite").equals(clOut.getProductCode())
 	    	){
 	    	 clOut.setAmount(clOut.getAmount()*(-1));
 	      }
 	     logger.info("策略额度建议规则出参：creditLine{}",clOut.toString());  
 	       
		return clOut; 
	}
	
	@Override
	public ProductRateOut productRate(ProductRateIn productRateIn) throws Exception{
		logger.info("策略产品费率规则入参：creditLine{}",productRateIn.toString());
		ProductRateIn prIn=new ProductRateIn();
		ProductRateOut prOut=new ProductRateOut();
		 
 		   KieServices ks = KieServices.Factory.get();
    	   KieContainer kContainer = ks.getKieClasspathContainer();
    	   KieSession kSession = kContainer.newKieSession("ksession-rules-ProductRate");
 		       
           BeanUtils.copyProperties(prIn, productRateIn);
       
 	       kSession.insert(prIn);
 	       kSession.insert(prOut);
 	       kSession.startProcess("CreditScoreAutoAudit.ProductRateFlow");
 	       kSession.fireAllRules();
 	       kSession.dispose();  
 	       
 	      logger.info("策略产品费率规则出参：creditLine{}",prOut.toString());
 	       
		return prOut; 
	}
}
