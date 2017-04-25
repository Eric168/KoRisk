package com.madai.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.event.KnowledgeRuntimeEventManager;
import org.kie.internal.logger.KnowledgeRuntimeLogger;
import org.kie.internal.logger.KnowledgeRuntimeLoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.madai.model.ResponseResult;
import com.madai.model.SimpleCreditInfo;
import com.madai.model.approval.CreditBusiness.CreditBusinessIn;
import com.madai.model.approval.CreditBusiness.CreditBusinessResult;
import com.madai.service.SimpleRefWarnsService;


@Service(value="simpleRefWarnsService")
public class SimpleRefWarnsServiceImpl implements SimpleRefWarnsService{
	private static final Logger logger = LoggerFactory
            .getLogger(SimpleRefWarnsService.class);
	
	@Value("#{configProperties['kSessionLogPath']}")
	private String kSessionLogPath;
	
	@Override
	public List<ResponseResult> refuseOrWarns(SimpleCreditInfo simpleCreditInfo,CreditBusinessIn creditBusinessIn) {
		SimpleCreditInfo sCI=new SimpleCreditInfo();
		CreditBusinessResult crt=new CreditBusinessResult();
		
		List<ResponseResult> list=new ArrayList<ResponseResult>();
		logger.info("策略简单征信自动拒绝入参：refuseOrWarns{},creditBusinessIn{}",simpleCreditInfo.toString(),creditBusinessIn.toString());
		
		 try{
 		   KieServices ks = KieServices.Factory.get();
    	   KieContainer kContainer = ks.getKieClasspathContainer();
    	   KieSession kSession = kContainer.newKieSession("ksession-rules-SimpleCreditInfoRules");
           //KnowledgeRuntimeLogger loger = KnowledgeRuntimeLoggerFactory.newFileLogger( (KnowledgeRuntimeEventManager) kSession, kSessionLogPath+(new java.text.SimpleDateFormat("yyyy-MM-dd")).format(new Date()));
 		       

           BeanUtils.copyProperties(sCI, simpleCreditInfo);
           BeanUtils.copyProperties(crt,creditBusinessIn);
       
 	       kSession.insert(sCI);
 	       kSession.insert(crt);
 	       kSession.startProcess("com.ts8.refuseOrWarnsFlow");
 	       kSession.setGlobal("responseResultList",list);
 	       kSession.fireAllRules();
 	       list=(List<ResponseResult>) kSession.getGlobal("responseResultList");
 	       kSession.dispose();  
 	       logger.info("策略新简版征信建议拒绝规则中间变量：{}",crt.toString());
 	       logger.info("策略简单征信自动拒绝出参：ResponseResultList{} ；idCardNo={}",list.toString(),crt.getIdCardNo());
 	       //loger.close();
 	   }catch(Exception t){
 		   t.printStackTrace();
 		   return null;
 	   }
		return list; 
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
           //KnowledgeRuntimeLogger loger = KnowledgeRuntimeLoggerFactory.newFileLogger( (KnowledgeRuntimeEventManager) kSession, kSessionLogPath+(new java.text.SimpleDateFormat("yyyy-MM-dd")).format(new Date()));
 		       

           BeanUtils.copyProperties(sCI, simpleCreditInfo);
       
 	       kSession.insert(sCI);
 	       kSession.startProcess("com.ts8.registerFlow");
 	       kSession.setGlobal("responseResultList",list);
 	       kSession.fireAllRules();
 	       list=(List<ResponseResult>) kSession.getGlobal("responseResultList");
 	       kSession.dispose();  
 	       
 	       //loger.close();
 	   }catch(Exception t){
 		   t.printStackTrace();
 		   return null;
 	   }
		return list; 
		
	}
}
