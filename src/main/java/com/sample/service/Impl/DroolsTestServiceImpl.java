package com.sample.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.kie.api.KieServices;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderError;
import org.kie.internal.builder.KnowledgeBuilderErrors;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.event.KnowledgeRuntimeEventManager;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.logger.KnowledgeRuntimeLogger;
import org.kie.internal.logger.KnowledgeRuntimeLoggerFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sample.model.Employ;
import com.sample.service.DroolsTest;
import com.sample.service.DroolsTestService;
import com.madai.model.ResponseResult;
import com.madai.model.SimpleCreditInfo;
import com.madai.model.approval.CreditScoreAutoAuditBaseIn;
import com.madai.model.approval.CreditScoreAutoAuditOneExtendIn;
import com.madai.model.approval.CreditScoreAutoAuditOneOut;

/**
 * This is a sample class to launch a rule.
 */
@Service(value="droolsTestService")
public class DroolsTestServiceImpl implements DroolsTestService{
	private static final Logger logger = LoggerFactory
            .getLogger(DroolsTest.class);
	
	@Value("#{configProperties['kSessionLogPath']}")
	private String kSessionLogPath;
	@Override
	public Employ applyCheckByRule(Employ employ) {
		 Employ emp=new Employ();
		 
		 try{
 		   KieServices ks = KieServices.Factory.get();
    	       KieContainer kContainer = ks.getKieClasspathContainer();
        	   KieSession kSession = kContainer.newKieSession("ksession-rules-simple");
        	   KnowledgeRuntimeLogger loger = KnowledgeRuntimeLoggerFactory.newFileLogger( (KnowledgeRuntimeEventManager) kSession, kSessionLogPath+(new java.text.SimpleDateFormat("yyyy-MM-dd")).format(new Date()));
 		       
        	   /*KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger( (KnowledgeRuntimeEventManager) kSession, kSessionLogPath+(new java.text.SimpleDateFormat("yyyy-MM-dd")).format(new Date()));*/

        	BeanUtils.copyProperties(emp, employ);
 	    /* emp.setEducationInfo("master");
 	       emp.setResume("tech");
 	       emp.setBonus("good");
 	       emp.setAwardPunish("award");*/
 	       kSession.insert(emp);
 	       kSession.startProcess("21");
 	       kSession.fireAllRules();
 	       logger.info("fireallrules total:"+emp.getTotalSalary());
 	       kSession.dispose();  
 	       logger.info("fireallrules total2:"+emp.getTotalSalary());	       
 	       loger.close();
 	   }catch(Exception t){
 		   t.printStackTrace();
 		   return null;
 	   }
		return emp;
	}
	@Override
	public List<ResponseResult> refuseOrWarns(SimpleCreditInfo simpleCreditInfo) {
		SimpleCreditInfo sCI=new SimpleCreditInfo();
		List<ResponseResult> list=new ArrayList<ResponseResult>();
		 try{
 		   KieServices ks = KieServices.Factory.get();
    	   KieContainer kContainer = ks.getKieClasspathContainer();
    	   KieSession kSession = kContainer.newKieSession("ksession-rules-SimpleCreditInfoRules");
           KnowledgeRuntimeLogger loger = KnowledgeRuntimeLoggerFactory.newFileLogger( (KnowledgeRuntimeEventManager) kSession, kSessionLogPath+(new java.text.SimpleDateFormat("yyyy-MM-dd")).format(new Date()));
 		       

           BeanUtils.copyProperties(sCI, simpleCreditInfo);
       
 	       kSession.insert(sCI);
 	       kSession.startProcess("com.ts8.refuseOrWarnsFlow");
 	       kSession.setGlobal("responseResultList",list);
 	       kSession.fireAllRules();
 	       list=(List<ResponseResult>) kSession.getGlobal("responseResultList");
 	       kSession.dispose();  
 	       
 	       loger.close();
 	   }catch(Exception t){
 		   t.printStackTrace();
 		   return null;
 	   }
		return list; 
	}
	
	@Override
	public CreditScoreAutoAuditOneOut creditScore(CreditScoreAutoAuditBaseIn creditScoreAutoAuditBaseIn) {
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
 	       
 	   }catch(Exception t){
 		   t.printStackTrace();
 		   return null;
 	   }
		return csOut; 
	}
	@Override
	public List<ResponseResult> registerInform(SimpleCreditInfo simpleCreditInfo){
		SimpleCreditInfo sCI=new SimpleCreditInfo();
		List<ResponseResult> list=new ArrayList<ResponseResult>();
		logger.info("策略简单征信进件标准：registerInform{}",simpleCreditInfo.toString());
		 try{
 		   KieServices ks = KieServices.Factory.get();
    	   KieContainer kContainer = ks.getKieClasspathContainer();
    	   KieSession kSession = kContainer.newKieSession("ksession-rules-RegisterInformRule");
           KnowledgeRuntimeLogger loger = KnowledgeRuntimeLoggerFactory.newFileLogger( (KnowledgeRuntimeEventManager) kSession, kSessionLogPath+(new java.text.SimpleDateFormat("yyyy-MM-dd")).format(new Date()));
 		       

           BeanUtils.copyProperties(sCI, simpleCreditInfo);
       
 	       kSession.insert(sCI);
 	       kSession.startProcess("com.ts8.registerFlow");
 	       kSession.setGlobal("responseResultList",list);
 	       kSession.fireAllRules();
 	       list=(List<ResponseResult>) kSession.getGlobal("responseResultList");
 	       kSession.dispose();  
 	       
 	       loger.close();
 	   }catch(Exception t){
 		   t.printStackTrace();
 		   return null;
 	   }
		return list; 
		
	}
}
