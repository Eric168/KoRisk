package com.sample.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.madai.model.SimpleCreditInfo;
import com.madai.model.approval.CreditBusiness.CreditBusinessIn;
import com.madai.model.approval.CreditBusiness.CreditParticular;
import com.madai.service.SimpleRefWarnsService;
import com.madai.utils.DateUtils;

/**
 * This is a sample class to launch a rule.
 */
public class ListZyTest {
	@Autowired
	private static DroolsTestService droolsTestService;
	@Autowired
	private static SimpleRefWarnsService simpleRefWarnsService;
	
	private static final Logger logger = LoggerFactory
            .getLogger(ListZyTest.class);
    public static final void main(String[] args) {
        try {
        	FileSystemXmlApplicationContext ctx =  new FileSystemXmlApplicationContext("D:\\work\\KoRisk\\src\\main\\resources\\spring\\spring-ruleResources.xml");
    		
        	droolsTestService=(DroolsTestService) ctx.getBean("droolsTestService");
//        	Employ emp=new Employ();
//        	
//        	Date startdate=new Date();
//        	logger.info("startdate:"+startdate);
//        	emp.setEducationInfo("master");
//  	        emp.setResume("tech");
//  	        emp.setBonus("good");
//  	        emp.setAwardPunish("award");
//  	        List<Worker> workerList=new ArrayList<Worker>();
//  	        Worker woker1=new Worker();
//  	        woker1.setJob("gongren");
//  	        woker1.setSex("nan");
//  	        
//  	        Worker woker2=new Worker();
//  	        woker2.setJob("xuesheng");
//	        woker2.setSex("nv");
//	        
//	        Worker woker3=new Worker();
//  	        woker3.setJob("gongren");
//	        woker3.setSex("nv");
//	        
//	        workerList.add(woker1);
//	        workerList.add(woker2);
//	        workerList.add(woker3);
//	        
//  	        emp.setWorkerList(workerList);
//  	        
//  	        Employ emp2=droolsTestService.applyCheckByRule(emp); 	  	       
  	        
  	       
  	        
  	        
  	      simpleRefWarnsService=(SimpleRefWarnsService) ctx.getBean("simpleRefWarnsService");
  	      
  	      SimpleCreditInfo  simpleCreditInfo=new SimpleCreditInfo();
  	      simpleCreditInfo.setIdCardNo("4200212430214141414");
  	      
  	      CreditBusinessIn  creditBusinessIn=new CreditBusinessIn();
  	      creditBusinessIn.setReportQueryDate(DateUtils.parse("2016-05-17", DateUtils.YEAR_MONTH_DAY_PATTERN));
  		  List<CreditParticular> creditParticularList = new ArrayList<>();
  		  //busiType=="CREDIT_CARD" && subBusiType=="贷记卡" && pastdueAmt>250 && months1() > 6 && afterLoanCardNoNewRecordFlag == "0"
  		  CreditParticular  cp1 = new CreditParticular();
  		  cp1.setId(1L);
  		  cp1.setBusiType("CREDIT_CARD");
  		  cp1.setSubBusiType("贷记卡");
  		  cp1.setPastdueAmt(500);
  		  cp1.setDateOpened(DateUtils.parse("2015-09-17", DateUtils.YEAR_MONTH_DAY_PATTERN));
  		  cp1.setDateClosed(DateUtils.parse("2018-05-17", DateUtils.YEAR_MONTH_DAY_PATTERN));
  		  cp1.setLastUpdateDate(DateUtils.parse("2016-01-17", DateUtils.YEAR_MONTH_DAY_PATTERN));
  		  cp1.setAfterLoanCardNoNewRecordFlag("0");
  		  cp1.setAcctStatus("24");
  		  cp1.setPastdueBy60Cnt(51);
  		  cp1.setCreditLineAmt(600);
  		  creditParticularList.add(cp1);
  		  creditBusinessIn.setCreditParticularList(creditParticularList);
  	      simpleRefWarnsService.refuseOrWarns(simpleCreditInfo, creditBusinessIn);
  	      System.out.println();
  	      
  	      
  	      
  	      
  	      
        } catch (Throwable t) {
            t.printStackTrace();
        }        
        
    }
}
   