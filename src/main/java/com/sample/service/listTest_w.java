package com.sample.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.util.StringUtils;

import com.sample.model.Employ;
import com.sample.model.Worker;
import com.madai.utils.DateUtils;
import com.madai.model.SimpleCreditInfo;
import com.madai.model.approval.CreditBusiness.CreditBusinessIn;
import com.madai.model.approval.CreditBusiness.CreditParticular;
import com.madai.service.SimpleRefWarnsService;
import com.madai.service.approval.CreditScoreAutoAuditService;

/**
 * This is a sample class to launch a rule.
 */
public class listTest_w {
	@Autowired
	private static DroolsTestService droolsTestService;
	@Autowired
	private static SimpleRefWarnsService simpleRefWarnsService;
	
	@Autowired
	private static CreditScoreAutoAuditService creditScoreAutoAuditService;
	private static final Logger logger = LoggerFactory
            .getLogger(listTest_w.class);
    public static final void main(String[] args) {
        try {
        	FileSystemXmlApplicationContext ctx =  new FileSystemXmlApplicationContext("E:\\Project\\KoRisk\\target\\classes\\spring\\spring-ruleResources.xml");
    		
        	droolsTestService=(DroolsTestService) ctx.getBean("droolsTestService");
        	Employ emp=new Employ();
        	
        	Date startdate=new Date();
        	logger.info("startdate:"+startdate);
        	emp.setEducationInfo("master");
  	        emp.setResume("tech");
  	        emp.setBonus("good");
  	        emp.setAwardPunish("award");
  	        List<Worker> workerList=new ArrayList<Worker>();
  	        Worker woker1=new Worker();
  	        woker1.setJob("gongren");
  	        woker1.setSex("nan");
  	        
  	        Worker woker2=new Worker();
  	        woker2.setJob("xuesheng");
	        woker2.setSex("nv");
	        
	        Worker woker3=new Worker();
  	        woker3.setJob("gongren");
	        woker3.setSex("nv");
	        
	        workerList.add(woker1);
	        workerList.add(woker2);
	        workerList.add(woker3);
	        
  	        emp.setWorkerList(workerList);
  	        
  	        Employ emp2=droolsTestService.applyCheckByRule(emp); 	  	       
  	        
  	       
  	        
  	        
  	    simpleRefWarnsService=(SimpleRefWarnsService) ctx.getBean("simpleRefWarnsService");
  	    SimpleCreditInfo  simpleCreditInfo=new SimpleCreditInfo();
	    simpleCreditInfo.setIdCardNo("4200212430214141414");
  	      
  	    CreditBusinessIn CreditBusinessIn=new CreditBusinessIn();
  	    //Date DateClosed=new Date();
  	   // Date ReportQueryDate=new Date();
  	    
  	    CreditBusinessIn.setAppId("A131"); 
  	    CreditBusinessIn.setProductCode("Eshetong");
  	    CreditBusinessIn.setCardApply24MonthFrequency(8);
  	    CreditBusinessIn.setLoanGuaranteeQuery03MonthFrequency(4);
  	    CreditBusinessIn.setSelfQuery03MonthFrequencySameday(2);
  	    List<CreditParticular> creditParticularList = new ArrayList<>();
  	    CreditParticular creditParticular1=new CreditParticular();
  	    CreditParticular creditParticular2=new CreditParticular();
  	    CreditParticular creditParticular3=new CreditParticular();
  	   // CreditParticular creditParticular4=new CreditParticular();
  	    //CreditParticular creditParticular5=new CreditParticular();
  	    //CreditParticular creditParticular6=new CreditParticular();

   	    creditParticular1.setAcctStatus("3");
  	    creditParticular1.setBusiType("CREDIT_CARD");
  	    creditParticular1.setAfterCardNewRecordFlag("0");
  	    creditParticular1.setAfterLoanCardNoNewRecordFlag("0");
  	    creditParticular1.setAfterLoanNewRecordFlag("0");
  	    creditParticular1.setCreditBalance(0);
  	    creditParticular1.setCreditLineAmt(600);
  	    creditParticular1.setCreditLineAmtCny(0);
  	    creditParticular1.setCurrencyType("人民币");
  	    creditParticular1.setDateClosed(DateUtils.parse("2016-3-3", DateUtils.YEAR_MONTH_DAY_PATTERN));
  	    creditParticular1.setDateOpened(DateUtils.parse("2013-1-3", DateUtils.YEAR_MONTH_DAY_PATTERN));
  	    creditParticular1.setId((long) 55);
  	    creditParticular1.setLastUpdateDate(DateUtils.parse("2013-09-3", DateUtils.YEAR_MONTH_DAY_PATTERN));
  	    creditParticular1.setLoanBalance(20000);
  	    creditParticular1.setLoanPeriod(0);
  	    creditParticular1.setLoanProperty("05");
  	    creditParticular1.setMonthlyPayment(null);
  	    creditParticular1.setOrgName(null);
  	    creditParticular1.setOverdraftBalance(0);
  	    creditParticular1.setPastdueAmt(250);
  	    creditParticular1.setPastdueBy60Cnt(10);
  	    creditParticular1.setPastdueM3By60Cnt(1);
  	    creditParticular1.setReportNumber("A131");
  	    creditParticular1.setReportQueryDate(DateUtils.parse("2016-5-15", DateUtils.YEAR_MONTH_DAY_PATTERN));
  	    creditParticular1.setSubBusiType("贷记卡");
  	    creditParticular1.setUsedcreditLineAmt(0);
  	    creditParticular1.setUsedcreditLineAmtCny(0);
  	   
  	    creditParticular2.setAcctStatus("14");
	    creditParticular2.setBusiType("CREDIT_CARD");
	    creditParticular2.setAfterCardNewRecordFlag("1");
	    creditParticular2.setAfterLoanCardNoNewRecordFlag("1");
	    creditParticular2.setAfterLoanNewRecordFlag("1");
	    creditParticular2.setCreditBalance(0);
	    creditParticular2.setCreditLineAmt(0);
	    creditParticular2.setCreditLineAmtCny(0);
	    creditParticular2.setCurrencyType("人民币");
	    creditParticular2.setDateClosed(DateUtils.parse("2015-01-3", DateUtils.YEAR_MONTH_DAY_PATTERN));
	    creditParticular2.setDateOpened(DateUtils.parse("2013-01-3", DateUtils.YEAR_MONTH_DAY_PATTERN));
	    creditParticular2.setId((long)56);
	    creditParticular2.setLastUpdateDate(DateUtils.parse("2014-09-3", DateUtils.YEAR_MONTH_DAY_PATTERN));
	    creditParticular2.setLoanBalance(30000);
	    creditParticular2.setLoanPeriod(0);
	    creditParticular2.setLoanProperty("05");
	    creditParticular2.setMonthlyPayment(null);
	    creditParticular2.setOrgName(null);
	    creditParticular2.setOverdraftBalance(0);
	    creditParticular2.setPastdueAmt(250);
	    creditParticular2.setPastdueBy60Cnt(10);
	    creditParticular2.setPastdueM3By60Cnt(2);
	    creditParticular2.setReportNumber("A131");
	    creditParticular2.setReportQueryDate(DateUtils.parse("2016-05-15", DateUtils.YEAR_MONTH_DAY_PATTERN));
	    creditParticular2.setSubBusiType("贷记卡");
	    creditParticular2.setUsedcreditLineAmt(0);
	    creditParticular2.setUsedcreditLineAmtCny(0);
	    
	    creditParticular3.setAcctStatus("14");
	    creditParticular3.setBusiType("CREDIT_CARD");
	    creditParticular3.setAfterCardNewRecordFlag("0");
	    creditParticular3.setAfterLoanCardNoNewRecordFlag("0");
	    creditParticular3.setAfterLoanNewRecordFlag("0");
	    creditParticular3.setCreditBalance(0);
	    creditParticular3.setCreditLineAmt(0);
	    creditParticular3.setCreditLineAmtCny(0);
	    creditParticular3.setCurrencyType("人民币");
	    creditParticular3.setDateClosed(DateUtils.parse("2016-01-3", DateUtils.YEAR_MONTH_DAY_PATTERN));
	    creditParticular3.setDateOpened(DateUtils.parse("2013-03-3", DateUtils.YEAR_MONTH_DAY_PATTERN));
	    creditParticular3.setId((long)57);
	    creditParticular3.setLastUpdateDate(DateUtils.parse("2015-09-3", DateUtils.YEAR_MONTH_DAY_PATTERN));
	    creditParticular3.setLoanBalance(30000);
	    creditParticular3.setLoanPeriod(0);
	    creditParticular3.setLoanProperty("05");
	    creditParticular3.setMonthlyPayment(null);
	    creditParticular3.setOrgName(null);
	    creditParticular3.setOverdraftBalance(260);
	    creditParticular3.setPastdueAmt(250);
	    creditParticular3.setPastdueBy60Cnt(10);
	    creditParticular3.setPastdueM3By60Cnt(3);
	    creditParticular3.setReportNumber("A131");
	    creditParticular3.setReportQueryDate(DateUtils.parse("2016-05-15", DateUtils.YEAR_MONTH_DAY_PATTERN));
	    creditParticular3.setSubBusiType("贷记卡");
	    creditParticular3.setUsedcreditLineAmt(0);
	    creditParticular3.setUsedcreditLineAmtCny(0);
  
  	    
  	   creditParticularList.add(creditParticular1);
  	   creditParticularList.add(creditParticular2);
  	   creditParticularList.add(creditParticular3);

  	   CreditBusinessIn.setCreditParticularList(creditParticularList);
  	 // CreditBusinessIn CreditBusinessIn =droolsTestService.applyCheckByRule(null); 	
  	   
  	   
  	  
  	      
  	      simpleRefWarnsService.refuseOrWarns(simpleCreditInfo, CreditBusinessIn);
  	      
  	     	      
  	      
  	      
  	      
        } catch (Throwable t) {
            t.printStackTrace();
        }        
        
    }
}
   