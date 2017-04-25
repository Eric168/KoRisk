package com.sample.service;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.FileSystemXmlApplicationContext;



















import com.madai.model.approval.CreditLine.CreditLineIn;
import com.madai.model.approval.CreditLine.CreditLineOut;
import com.madai.model.approval.ProductRate.ProductRateIn;
import com.madai.model.approval.ProductRate.ProductRateOut;
import com.madai.service.approval.CreditScoreAutoAuditService;

public class creditLineTest_w_new {
    

	@Autowired
	private static CreditScoreAutoAuditService creditScoreAutoAuditService;
	private static final Logger logger = LoggerFactory
            .getLogger(creditLineTest_w_new.class);
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
          
		FileSystemXmlApplicationContext ctx =  new FileSystemXmlApplicationContext("E:\\Project\\KoRisk\\target\\classes\\spring\\spring-ruleResources.xml");
		
		creditScoreAutoAuditService=(CreditScoreAutoAuditService) ctx.getBean("creditScoreAutoAuditService");
		
		ProductRateIn productRateIn=new ProductRateIn();
		productRateIn.setProductCode("Eshetong");
		productRateIn.setAge(38);
		productRateIn.setAppId("Test123");
		productRateIn.setDsr(1.3);
		productRateIn.setIsDivorce("1");
		productRateIn.setIsLocal("0");
		try {
			ProductRateOut p=creditScoreAutoAuditService.productRate(productRateIn);
			
			logger.info("productRate:"+p.getRate()+";returnCode:"+p.getReturnCode());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CreditLineIn creditLineIn=new CreditLineIn();
		creditLineIn.setProductCode("TYElite");
		creditLineIn.setAge(26);
		creditLineIn.setAppId("app132");
		creditLineIn.setDsr(1.2);
		creditLineIn.setIncome(2456);
		creditLineIn.setIsFemale("0");
		creditLineIn.setIsHasHouse("1");
		creditLineIn.setIsLocal("0");
		creditLineIn.setLastMonthCreditQueryTimes(3);
		creditLineIn.setSalary(2900);
		creditLineIn.setMiddleCode("123");
		
		try {
			CreditLineOut q=creditScoreAutoAuditService.creditLine(creditLineIn);
			
			logger.info("base:"+q.getTimes()+"creditLine_amount:"+q.getAmount()+";returnCode:"+q.getReturnCode());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 File file = new File("E:/koRisk_test_file/2016-5-16.xls");
	        String[][] result = DroolsTest.getData(file,4);
	        int rowLength = result.length;
	        int ktime=0;
	        int pcode=0;
	        int ammount=0;
	        String qtime="";
	        String plcode="";
	        String aamount="";
	        for(int i=0;i<rowLength;i++) {
	        	CreditLineIn creditLineIn2=new CreditLineIn();
	        	CreditLineOut CreditLineOut_expect=new CreditLineOut();
	        	CreditLineOut CreditLineOut_fact=new CreditLineOut();
	        	for(int j=0;j<result[i].length-1;j++) {	
		        	 //  logger.info("i:"+i+" ;j:"+j);  
		        	   switch(j){
		        	   case 1 :   creditLineIn2.setAppId(result[i][j]);  break;
		        	   case 2 :   creditLineIn2.setProductCode(result[i][j]);  break;
		        	   case 3 :   creditLineIn2.setIsLocal(result[i][j]); break;
		        	   case 4 :   creditLineIn2.setIsFemale(result[i][j]);  break;
		        	   case 5 :   creditLineIn2.setIsHasHouse(result[i][j]); break;
		        	   case 6 :   creditLineIn2.setAge(Integer.parseInt(result[i][j])); break;
		        	   case 7 :   creditLineIn2.setLastMonthCreditQueryTimes(Integer.parseInt(result[i][j])); break;
		        	   case 8 :   creditLineIn2.setDsr(Double.parseDouble(result[i][j])); break;
		        	   case 9 :   creditLineIn2.setSalary(Double.parseDouble(result[i][j])); break;
		        	   case 10 :  creditLineIn2.setIncome(Double.parseDouble(result[i][j])); break;
		        	   case 11 :  creditLineIn2.setBase(Double.parseDouble(result[i][j])); break;
		        	   case 12 :  CreditLineOut_expect.setReturnCode(result[i][j]); logger.info("model-expect-returncode"+i+";"+result[i][j]); break;	
		        	   case 13 :  CreditLineOut_expect.setTimes(Double.parseDouble(result[i][j])); logger.info("model-expect-times"+i+";"+result[i][j]); break;
		        	   case 14 :  CreditLineOut_expect.setAmount(Double.parseDouble(result[i][j])); logger.info("model-expect-amount"+i+";"+result[i][j]); break;   
		        	   }
		        }
	        	
	        	CreditLineOut_fact=creditScoreAutoAuditService.creditLine(creditLineIn2);
	        	logger.info("model-fact-"+i+";"+CreditLineOut_fact.getTimes());
	        	
	        	logger.info("plus:"+(CreditLineOut_expect.getTimes()-CreditLineOut_fact.getTimes()));
	        	if(Math.abs(CreditLineOut_expect.getTimes()-CreditLineOut_fact.getTimes())>=0.00001){
	        		logger.info("model-unexpected:"+i+"...............................................................");
	        		ktime=ktime+1;
	        		qtime+=i+";";
	        	}
	        	logger.info("code;"+CreditLineOut_fact.getReturnCode());
	        	if(!CreditLineOut_expect.getReturnCode().equals(CreditLineOut_fact.getReturnCode())){
	        		logger.info("model-unexpected:"+i+"...............................................................");
	        		pcode=pcode+1;
	        		plcode+=i+";";
	        		
	        	}
	        	logger.info("amount;"+CreditLineOut_fact.getAmount());
	        	if(Math.abs(CreditLineOut_expect.getAmount()-CreditLineOut_fact.getAmount())>=0.00001){
	        		logger.info("model-unexpected:"+i+"...............................................................");
	        		ammount=ammount+1;
	        		aamount+=i+";";
	        		
	        	}
	        	
	        	
	        }
	        logger.info("ktime;"+ktime);
	        logger.info("qtime;"+qtime);
	        logger.info("ammount;"+ammount);
	        logger.info("aamount;"+aamount);
	        logger.info("pcode;"+pcode);
	        logger.info("plcode;"+plcode);
	        ProductRateIn productRateIn5=new ProductRateIn();
	        productRateIn5.setProductCode("Efangtong");
	        productRateIn5.setAge(30);
	        productRateIn5.setAppId("app132");
	        productRateIn5.setDsr(0.9);
	        productRateIn5.setIsDivorce("0");
	        productRateIn5.setIsLocal("0");

			
			try {
				ProductRateOut q2=creditScoreAutoAuditService.productRate(productRateIn5);
	
				logger.info("product_Rate:"+q2.getRate()+"SubProductCode:"+q2.getSubProductCode()+";returnCode:"+q2.getReturnCode());
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
	        
	}

}
