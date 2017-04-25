package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.madai.model.approval.CreditLine.CreditLineIn;
import com.madai.model.approval.CreditLine.CreditLineOut;
import com.madai.model.approval.ProductRate.ProductRateIn;
import com.madai.model.approval.ProductRate.ProductRateOut;
import com.madai.service.approval.CreditScoreAutoAuditService;

public class creditLineTest {
    

	@Autowired
	private static CreditScoreAutoAuditService creditScoreAutoAuditService;
	
	public static void main(String[] args) {
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
		creditLineIn.setProductCode("Elite");
		creditLineIn.setAge(32);
		creditLineIn.setAppId("app132");
		creditLineIn.setDsr(0.6);
		creditLineIn.setIncome(100);
		creditLineIn.setBase(200);
		creditLineIn.setIsFemale("1");
		creditLineIn.setIsHasHouse("1");
		creditLineIn.setIsLocal("0");
		creditLineIn.setLastMonthCreditQueryTimes(4);
		creditLineIn.setSalary(2900);
		creditLineIn.setMiddleCode("123");
		
		try {
			CreditLineOut q=creditScoreAutoAuditService.creditLine(creditLineIn);
			
			System.out.println("base:"+q.getTimes()+"creditLine_amount:"+q.getAmount()+";returnCode:"+q.getReturnCode());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
