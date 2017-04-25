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
import com.madai.model.SimpleCreditInfo;
import com.madai.model.approval.CreditBusiness.CreditBusinessIn;
import com.madai.model.approval.CreditBusiness.CreditParticular;
import com.madai.service.SimpleRefWarnsService;
import com.madai.service.approval.CreditScoreAutoAuditService;
import com.madai.utils.DateUtils;

/**
 * This is a sample class to launch a rule.
 */
public class listTest {
	@Autowired
	private static DroolsTestService droolsTestService;
	@Autowired
	private static SimpleRefWarnsService simpleRefWarnsService;
	
	@Autowired
	private static CreditScoreAutoAuditService creditScoreAutoAuditService;
	private static final Logger logger = LoggerFactory
            .getLogger(listTest.class);
    public static final void main(String[] args) {
        try {
        	FileSystemXmlApplicationContext ctx =  new FileSystemXmlApplicationContext("D:\\work\\workspace\\appworkspace-2015-08-28\\KoRisk\\src\\main\\resources\\spring\\spring-ruleResources.xml");
    		
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
  	    
  	   /* CreditBusinessIn.setAppId(""); 
  	    CreditBusinessIn.setProductCode("E贷通");
  	    CreditBusinessIn.setCardApply24MonthFrequency(25);
  	    CreditBusinessIn.setLoanGuaranteeQuery03MonthFrequency(1);
  	    CreditBusinessIn.setSelfQuery03MonthFrequencySameday(5);
  	    List<CreditParticular> creditParticularList = new ArrayList<>();
  	    CreditParticular creditParticular1=new CreditParticular();
  	    CreditParticular creditParticular2=new CreditParticular();
  	    CreditParticular creditParticular3=new CreditParticular();
  
   	    creditParticular1.setAcctStatus("未激活");
  	    creditParticular1.setBusiType("信用卡");
  	    creditParticular1.setAfterCardNewRecordFlag(null);
  	    creditParticular1.setAfterLoanCardNoNewRecordFlag(null);
  	    creditParticular1.setAfterLoanNewRecordFlag(null);
  	    creditParticular1.setCreditBalance(0);
  	    creditParticular1.setCreditLineAmt(0);
  	    creditParticular1.setCreditLineAmtCny(0);
  	    creditParticular1.setCurrencyType(null);
  	    creditParticular1.setDateClosed(DateUtils.parse("2014-07-21", DateUtils.YEAR_MONTH_DAY_PATTERN));
  	    creditParticular1.setDateOpened(DateUtils.parse("2013-04-21", DateUtils.YEAR_MONTH_DAY_PATTERN));
  	    creditParticular1.setId(null);
  	    creditParticular1.setLastUpdateDate(DateUtils.parse("2014-06-21", DateUtils.YEAR_MONTH_DAY_PATTERN));
  	    creditParticular1.setLoanBalance(20000);
  	    creditParticular1.setLoanPeriod(0);
  	    creditParticular1.setLoanProperty("");
  	    creditParticular1.setMonthlyPayment(null);
  	    creditParticular1.setOrgName(null);
  	    creditParticular1.setOverdraftBalance(0);
  	    creditParticular1.setPastdueAmt(0);
  	    creditParticular1.setPastdueBy60Cnt(0);
  	    creditParticular1.setPastdueM3By60Cnt(0);
  	    creditParticular1.setReportNumber(null);
  	    creditParticular1.setReportQueryDate(DateUtils.parse("2016-08-21", DateUtils.YEAR_MONTH_DAY_PATTERN));
  	    creditParticular1.setSubBusiType("贷记卡");
  	    creditParticular1.setUsedcreditLineAmt(0);
  	    creditParticular1.setUsedcreditLineAmtCny(0);
  	    
  	    creditParticular2.setAcctStatus("销户");
	    creditParticular2.setBusiType("贷款");
	    creditParticular2.setAfterCardNewRecordFlag(null);
	    creditParticular2.setAfterLoanCardNoNewRecordFlag(null);
	    creditParticular2.setAfterLoanNewRecordFlag(null);
	    creditParticular2.setCreditBalance(0);
	    creditParticular2.setCreditLineAmt(0);
	    creditParticular2.setCreditLineAmtCny(0);
	    creditParticular2.setCurrencyType(null);
	    creditParticular2.setDateClosed(DateUtils.parse("2016-07-21", DateUtils.YEAR_MONTH_DAY_PATTERN));
	    creditParticular2.setDateOpened(DateUtils.parse("2013-06-21", DateUtils.YEAR_MONTH_DAY_PATTERN));
	    creditParticular2.setId(null);
	    creditParticular2.setLastUpdateDate(DateUtils.parse("2013-07-21", DateUtils.YEAR_MONTH_DAY_PATTERN));
	    creditParticular2.setLoanBalance(30000);
	    creditParticular2.setLoanPeriod(0);
	    creditParticular2.setLoanProperty("05");
	    creditParticular2.setMonthlyPayment(null);
	    creditParticular2.setOrgName(null);
	    creditParticular2.setOverdraftBalance(0);
	    creditParticular2.setPastdueAmt(0);
	    creditParticular2.setPastdueBy60Cnt(0);
	    creditParticular2.setPastdueM3By60Cnt(0);
	    creditParticular2.setReportNumber(null);
	    creditParticular2.setReportQueryDate(DateUtils.parse("2016-08-22", DateUtils.YEAR_MONTH_DAY_PATTERN));
	    creditParticular2.setSubBusiType(null);
	    creditParticular2.setUsedcreditLineAmt(0);
	    creditParticular2.setUsedcreditLineAmtCny(0);
	    
	    creditParticular3.setAcctStatus("销户");
	    creditParticular3.setBusiType("贷款");
	    creditParticular3.setAfterCardNewRecordFlag(null);
	    creditParticular3.setAfterLoanCardNoNewRecordFlag(null);
	    creditParticular3.setAfterLoanNewRecordFlag(null);
	    creditParticular3.setCreditBalance(0);
	    creditParticular3.setCreditLineAmt(0);
	    creditParticular3.setCreditLineAmtCny(0);
	    creditParticular3.setCurrencyType(null);
	    creditParticular3.setDateClosed(DateUtils.parse("2016-09-21", DateUtils.YEAR_MONTH_DAY_PATTERN));//
	    creditParticular3.setDateOpened(DateUtils.parse("2013-07-21", DateUtils.YEAR_MONTH_DAY_PATTERN));
	    creditParticular3.setId(null);
	    creditParticular3.setLastUpdateDate(null);//
	    creditParticular3.setLoanBalance(30000);
	    creditParticular3.setLoanPeriod(0);
	    creditParticular3.setLoanProperty("05");
	    creditParticular3.setMonthlyPayment(null);
	    creditParticular3.setOrgName(null);
	    creditParticular3.setOverdraftBalance(0);
	    creditParticular3.setPastdueAmt(0);
	    creditParticular3.setPastdueBy60Cnt(0);
	    creditParticular3.setPastdueM3By60Cnt(0);
	    creditParticular3.setReportNumber(null);
	    creditParticular3.setReportQueryDate(DateUtils.parse("2016-09-21", DateUtils.YEAR_MONTH_DAY_PATTERN));
	    creditParticular3.setSubBusiType(null);
	    creditParticular3.setUsedcreditLineAmt(0);
	    creditParticular3.setUsedcreditLineAmtCny(0);
  
  	   
	      CreditParticular credit1=new CreditParticular();
          CreditParticular credit2=new CreditParticular();
          CreditParticular credit3=new CreditParticular();
                           credit1.setBusiType("LOAN");
                           credit1.setPastdueAmt(500);
                           credit1.setPastdueBy60Cnt(2);
                           credit1.setCurrencyType("人民币");
                           credit1.setAfterLoanNewRecordFlag("0");
                           credit1.setPastdueM3By60Cnt(8);
                           credit1.setLoanProperty("04");
                           credit1.setDateOpened(DateUtils.parse("2016-01-21",DateUtils.YEAR_MONTH_DAY_PATTERN));
                           credit1.setLastUpdateDate(DateUtils.parse("2019-04-21",DateUtils.YEAR_MONTH_DAY_PATTERN));
                           credit1.setReportQueryDate(DateUtils.parse("2019-05-11",DateUtils.YEAR_MONTH_DAY_PATTERN));
                           credit1.setDateClosed(DateUtils.parse("2019-04-11",DateUtils.YEAR_MONTH_DAY_PATTERN));
   
                          credit2.setBusiType("LOAN");
                          credit2.setPastdueAmt(400);
                          credit2.setPastdueBy60Cnt(0);
                          credit2.setCurrencyType("人民币");
                          credit2.setAfterLoanNewRecordFlag("0");
                          credit2.setPastdueM3By60Cnt(11);
                          credit2.setLoanProperty("05");
                          credit2.setDateOpened(DateUtils.parse("2016-02-21",DateUtils.YEAR_MONTH_DAY_PATTERN));
                          credit2.setLastUpdateDate(DateUtils.parse("2019-05-21",DateUtils.YEAR_MONTH_DAY_PATTERN));
                          credit2.setReportQueryDate(DateUtils.parse("2019-05-21",DateUtils.YEAR_MONTH_DAY_PATTERN));
                          credit2.setDateClosed(DateUtils.parse("2019-05-21",DateUtils.YEAR_MONTH_DAY_PATTERN));

                         credit3.setBusiType("LOAN");
                         credit3.setPastdueAmt(300);
                         credit3.setPastdueBy60Cnt(3);
                         credit3.setCurrencyType("人民币");
                         credit3.setAfterLoanNewRecordFlag("0");
                         credit3.setPastdueM3By60Cnt(5);
                         credit3.setLoanProperty("05");
                         credit3.setDateOpened(DateUtils.parse("2016-02-21",DateUtils.YEAR_MONTH_DAY_PATTERN));
                         credit3.setLastUpdateDate(DateUtils.parse("2019-05-21",DateUtils.YEAR_MONTH_DAY_PATTERN));
                         credit3.setReportQueryDate(DateUtils.parse("2019-05-21",DateUtils.YEAR_MONTH_DAY_PATTERN));
                         credit3.setDateClosed(DateUtils.parse("2019-05-21",DateUtils.YEAR_MONTH_DAY_PATTERN));
                         
                         creditParticularList.add(0,creditParticular1);
                         creditParticularList.add(1,creditParticular2);
                         creditParticularList.add(2,creditParticular3);
                         creditParticularList.add(3,credit1);
                         creditParticularList.add(4,credit2);
                         creditParticularList.add(5,credit3);*/
  	  CreditBusinessIn  creditBusinessIn=new CreditBusinessIn();
	      creditBusinessIn.setAppId("a123");
	      creditBusinessIn.setProductCode("a222");
	      creditBusinessIn.setLoanGuaranteeQuery03MonthFrequency(10);
	      creditBusinessIn.setSelfQuery03MonthFrequencySameday(5);
	      
	        List<CreditParticular> creditParticularList=new ArrayList<CreditParticular>();
	             CreditParticular credit1=new CreditParticular();
	             CreditParticular credit2=new CreditParticular();
	             CreditParticular credit3=new CreditParticular();
	                              credit1.setBusiType("LOAN");
	                              credit1.setPastdueAmt(500);
	                              credit1.setPastdueBy60Cnt(2);
	                              credit1.setCurrencyType("人民币");
	                              credit1.setAfterLoanNewRecordFlag("0");
	                              credit1.setPastdueM3By60Cnt(8);
	                              credit1.setLoanProperty("04");
	                              credit1.setDateOpened(DateUtils.parse("2016-01-21",DateUtils.YEAR_MONTH_DAY_PATTERN));
	                              credit1.setLastUpdateDate(DateUtils.parse("2015-05-21",DateUtils.YEAR_MONTH_DAY_PATTERN));
	                              credit1.setReportQueryDate(DateUtils.parse("2018-05-11",DateUtils.YEAR_MONTH_DAY_PATTERN));
	                              credit1.setDateClosed(DateUtils.parse("2017-09-11",DateUtils.YEAR_MONTH_DAY_PATTERN));
        
                              credit2.setBusiType("LOAN");
	                              credit2.setPastdueAmt(400);
	                              credit2.setPastdueBy60Cnt(0);
	                              credit2.setCurrencyType("人民币");
	                              credit2.setAfterLoanNewRecordFlag("0");
	                              credit2.setPastdueM3By60Cnt(11);
	                              credit2.setLoanProperty("05");
	                              credit2.setDateOpened(DateUtils.parse("2016-02-21",DateUtils.YEAR_MONTH_DAY_PATTERN));
	                              credit2.setLastUpdateDate(DateUtils.parse("2015-05-21",DateUtils.YEAR_MONTH_DAY_PATTERN));
	                              credit2.setReportQueryDate(DateUtils.parse("2016-05-11",DateUtils.YEAR_MONTH_DAY_PATTERN));
	                              credit2.setDateClosed(DateUtils.parse("2013-05-11",DateUtils.YEAR_MONTH_DAY_PATTERN));
 
                              credit3.setBusiType("LOAN");
                              credit3.setPastdueAmt(300);
                              credit3.setPastdueBy60Cnt(3);
                              credit3.setCurrencyType("人民币");
                              credit3.setAfterLoanNewRecordFlag("0");
                              credit3.setPastdueM3By60Cnt(5);
                              credit3.setLoanProperty("05");
                              credit3.setDateOpened(DateUtils.parse("2016-06-21",DateUtils.YEAR_MONTH_DAY_PATTERN));
	                              credit3.setLastUpdateDate(DateUtils.parse("2016-05-21",DateUtils.YEAR_MONTH_DAY_PATTERN));
	                              credit3.setReportQueryDate(DateUtils.parse("2016-05-11",DateUtils.YEAR_MONTH_DAY_PATTERN));
	                              credit3.setDateClosed(DateUtils.parse("2015-07-11",DateUtils.YEAR_MONTH_DAY_PATTERN));
                              
	                              CreditParticular creditParticular1=new CreditParticular();
	                        	    CreditParticular creditParticular2=new CreditParticular();
	                        	    CreditParticular creditParticular3=new CreditParticular();
	                        
	                         	    creditParticular1.setAcctStatus("未激活");
	                        	    creditParticular1.setBusiType("信用卡");
	                        	    creditParticular1.setAfterCardNewRecordFlag(null);
	                        	    creditParticular1.setAfterLoanCardNoNewRecordFlag(null);
	                        	    creditParticular1.setAfterLoanNewRecordFlag(null);
	                        	    creditParticular1.setCreditBalance(0);
	                        	    creditParticular1.setCreditLineAmt(0);
	                        	    creditParticular1.setCreditLineAmtCny(0);
	                        	    creditParticular1.setCurrencyType(null);
	                        	    creditParticular1.setDateClosed(DateUtils.parse("2016-07-21", DateUtils.YEAR_MONTH_DAY_PATTERN));
	                        	    creditParticular1.setDateOpened(DateUtils.parse("2014-04-21", DateUtils.YEAR_MONTH_DAY_PATTERN));
	                        	    creditParticular1.setId(null);
	                        	    creditParticular1.setLastUpdateDate(DateUtils.parse("2014-06-21", DateUtils.YEAR_MONTH_DAY_PATTERN));
	                        	    creditParticular1.setLoanBalance(20000);
	                        	    creditParticular1.setLoanPeriod(0);
	                        	    creditParticular1.setLoanProperty("");
	                        	    creditParticular1.setMonthlyPayment(null);
	                        	    creditParticular1.setOrgName(null);
	                        	    creditParticular1.setOverdraftBalance(0);
	                        	    creditParticular1.setPastdueAmt(0);
	                        	    creditParticular1.setPastdueBy60Cnt(0);
	                        	    creditParticular1.setPastdueM3By60Cnt(0);
	                        	    creditParticular1.setReportNumber(null);
	                        	    creditParticular1.setReportQueryDate(DateUtils.parse("2016-08-21", DateUtils.YEAR_MONTH_DAY_PATTERN));
	                        	    creditParticular1.setSubBusiType("贷记卡");
	                        	    creditParticular1.setUsedcreditLineAmt(0);
	                        	    creditParticular1.setUsedcreditLineAmtCny(0);
	                        	    
	                        	    creditParticular2.setAcctStatus("销户");
	                      	    creditParticular2.setBusiType("贷款");
	                      	    creditParticular2.setAfterCardNewRecordFlag(null);
	                      	    creditParticular2.setAfterLoanCardNoNewRecordFlag(null);
	                      	    creditParticular2.setAfterLoanNewRecordFlag(null);
	                      	    creditParticular2.setCreditBalance(0);
	                      	    creditParticular2.setCreditLineAmt(0);
	                      	    creditParticular2.setCreditLineAmtCny(0);
	                      	    creditParticular2.setCurrencyType(null);
	                      	    creditParticular2.setDateClosed(DateUtils.parse("2017-07-21", DateUtils.YEAR_MONTH_DAY_PATTERN));
	                      	    creditParticular2.setDateOpened(DateUtils.parse("2013-06-21", DateUtils.YEAR_MONTH_DAY_PATTERN));
	                      	    creditParticular2.setId(null);
	                      	    creditParticular2.setLastUpdateDate(DateUtils.parse("2013-07-21", DateUtils.YEAR_MONTH_DAY_PATTERN));
	                      	    creditParticular2.setLoanBalance(30000);
	                      	    creditParticular2.setLoanPeriod(0);
	                      	    creditParticular2.setLoanProperty("05");
	                      	    creditParticular2.setMonthlyPayment(null);
	                      	    creditParticular2.setOrgName(null);
	                      	    creditParticular2.setOverdraftBalance(0);
	                      	    creditParticular2.setPastdueAmt(0);
	                      	    creditParticular2.setPastdueBy60Cnt(0);
	                      	    creditParticular2.setPastdueM3By60Cnt(0);
	                      	    creditParticular2.setReportNumber(null);
	                      	    creditParticular2.setReportQueryDate(DateUtils.parse("2016-08-22", DateUtils.YEAR_MONTH_DAY_PATTERN));
	                      	    creditParticular2.setSubBusiType(null);
	                      	    creditParticular2.setUsedcreditLineAmt(0);
	                      	    creditParticular2.setUsedcreditLineAmtCny(0);
	                      	    
	                      	    creditParticular3.setAcctStatus("销户");
	                      	    creditParticular3.setBusiType("贷款");
	                      	    creditParticular3.setAfterCardNewRecordFlag(null);
	                      	    creditParticular3.setAfterLoanCardNoNewRecordFlag(null);
	                      	    creditParticular3.setAfterLoanNewRecordFlag(null);
	                      	    creditParticular3.setCreditBalance(0);
	                      	    creditParticular3.setCreditLineAmt(0);
	                      	    creditParticular3.setCreditLineAmtCny(0);
	                      	    creditParticular3.setCurrencyType(null);
	                      	    creditParticular3.setDateClosed(DateUtils.parse("2015-06-21", DateUtils.YEAR_MONTH_DAY_PATTERN));//
	                      	    creditParticular3.setDateOpened(DateUtils.parse("2015-05-21", DateUtils.YEAR_MONTH_DAY_PATTERN));
	                      	    creditParticular3.setId(null);
	                      	    creditParticular3.setLastUpdateDate(null);//
	                      	    creditParticular3.setLoanBalance(30000);
	                      	    creditParticular3.setLoanPeriod(0);
	                      	    creditParticular3.setLoanProperty("05");
	                      	    creditParticular3.setMonthlyPayment(null);
	                      	    creditParticular3.setOrgName(null);
	                      	    creditParticular3.setOverdraftBalance(0);
	                      	    creditParticular3.setPastdueAmt(0);
	                      	    creditParticular3.setPastdueBy60Cnt(0);
	                      	    creditParticular3.setPastdueM3By60Cnt(0);
	                      	    creditParticular3.setReportNumber(null);
	                      	    creditParticular3.setReportQueryDate(DateUtils.parse("2017-08-21", DateUtils.YEAR_MONTH_DAY_PATTERN));
	                      	    creditParticular3.setSubBusiType(null);
	                      	    creditParticular3.setUsedcreditLineAmt(0);
	                      	    creditParticular3.setUsedcreditLineAmtCny(0);                     
	                              
	                              
	                      	  creditParticularList.add(0,creditParticular1);
	                      	  creditParticularList.add(1,creditParticular2);
	                      	  creditParticularList.add(2,creditParticular3);
                              creditParticularList.add(3,credit1);
                              creditParticularList.add(4,credit2);
                              creditParticularList.add(5,credit3);               
  	      CreditBusinessIn.setCreditParticularList(creditParticularList);
  	     
  	      simpleRefWarnsService.refuseOrWarns(simpleCreditInfo, CreditBusinessIn);
  	      
  	      
  	      
  	      
  	      
        } catch (Throwable t) {
            t.printStackTrace();
        }        
        
    }
}
   