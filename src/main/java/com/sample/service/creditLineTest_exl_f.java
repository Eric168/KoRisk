package com.sample.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.FileSystemXmlApplicationContext;




import com.madai.model.approval.CreditLine.CreditLineIn;
import com.madai.model.approval.CreditLine.CreditLineOut;
import com.madai.model.approval.ProductRate.ProductRateIn;
import com.madai.model.approval.ProductRate.ProductRateOut;
import com.madai.service.approval.CreditScoreAutoAuditService;

public class creditLineTest_exl_f {
    

	@Autowired
	private static CreditScoreAutoAuditService creditScoreAutoAuditService;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
          
		FileSystemXmlApplicationContext ctx =  new FileSystemXmlApplicationContext("D:\\work\\workspace\\appworkspace-2015-08-28\\KoRisk\\src\\main\\resources\\spring\\spring-ruleResources.xml");
		
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
			
			System.out.println("productRate:"+p.getRate()+";returnCode:"+p.getReturnCode());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CreditLineIn creditLineIn=new CreditLineIn();
		creditLineIn.setProductCode("Ewangtong");
		creditLineIn.setAge(26);
		creditLineIn.setAppId("app132");
		creditLineIn.setDsr(1.2);
		creditLineIn.setIncome(3000);
		creditLineIn.setIsFemale("1");
		creditLineIn.setIsHasHouse("1");
		creditLineIn.setIsLocal("0");
		creditLineIn.setLastMonthCreditQueryTimes(3);
		creditLineIn.setSalary(2900);
		creditLineIn.setMiddleCode("123");
		
		try {
			CreditLineOut q=creditScoreAutoAuditService.creditLine(creditLineIn);
			
			System.out.println("base:"+q.getTimes()+"creditLine_amount:"+q.getAmount()+";returnCode:"+q.getReturnCode());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 File file = new File("C:/Users/Eric/Desktop/批额数据汇总1.xls");
	        String[][] result = DroolsTest.getData(file,5);
	        int rowLength = result.length;
	        int k=0;
	        int pq=0;
	        for(int i=0;i<rowLength;i++) {
	        	CreditLineIn creditLineIn2=new CreditLineIn();
	        	CreditLineOut CreditLineOut_expect=new CreditLineOut();
	        	CreditLineOut CreditLineOut_fact=new CreditLineOut();
	        	for(int j=0;j<result[i].length-1;j++) {	
		        	 //  System.out.println("i:"+i+" ;j:"+j);  
		        	   switch(j){
		        	   case 1 :   creditLineIn2.setAppId(result[i][j]);  break;
		        	   case 2 :   creditLineIn2.setProductCode(result[i][j]);  break;
		        	   case 3 :   creditLineIn2.setIsLocal(result[i][j]);  break;
		        	   case 4 :   creditLineIn2.setIsFemale(result[i][j]);  break;
		        	   case 5 :   creditLineIn2.setIsHasHouse(result[i][j]);  break;
		        	   case 6 :   creditLineIn2.setAge(Integer.parseInt(result[i][j]));  break;
		        	   case 7 :   creditLineIn2.setLastMonthCreditQueryTimes(Integer.parseInt(result[i][j]));  break;
		        	   case 8 :   creditLineIn2.setDsr(Double.parseDouble(result[i][j]));  break;
		        	   case 9 :   creditLineIn2.setSalary(Double.parseDouble(result[i][j]));  break;
		        	   case 10 :  creditLineIn2.setIncome(Double.parseDouble(result[i][j]));  break;
		        	   case 11 :  CreditLineOut_expect.setReturnCode(result[i][j]); System.out.println("model-expect-returncode"+i+";"+result[i][j]);  break;	
		        	   case 12 :  CreditLineOut_expect.setTimes(Double.parseDouble(result[i][j])); System.out.println("model-expect-times"+i+";"+result[i][j]);  break;
		        	   case 13 :  CreditLineOut_expect.setAmount(Double.parseDouble(result[i][j])); System.out.println("model-expect-amount"+i+";"+result[i][j]);  break;   
		        	   }
		        }
	        	
	        	CreditLineOut_fact=creditScoreAutoAuditService.creditLine(creditLineIn2);
	        	System.out.println("model-fact-"+i+";"+CreditLineOut_fact.getTimes());
	        	
	        	System.out.println("fact_returnCode:"+CreditLineOut_fact.getReturnCode());
	        	
	        	System.out.println("plus:"+(CreditLineOut_expect.getTimes()-CreditLineOut_fact.getTimes()));
	        	if(Math.abs(CreditLineOut_expect.getTimes()-CreditLineOut_fact.getTimes())>=0.00001){
	        		System.out.println("model-unexpected-k:"+i+"...............................................................");
	        		k=k+1;
	        	}
	        	
	        	if(!CreditLineOut_expect.getReturnCode().equals(CreditLineOut_fact.getReturnCode())){
	        		System.out.println("model-unexpected-pq:"+i+"...............................................................");
	        		pq=pq+1;
	        	}
	        }
	        System.out.println("K;"+k);
	        System.out.println("pq;"+pq);
	}

}
