package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.FileSystemXmlApplicationContext;





import com.madai.model.approval.CreditBusiness.CreditBusinessIn;
import com.madai.model.approval.CreditBusiness.CreditParticular;
import com.madai.service.SimpleRefWarnsService;

public class simpleCreditInfoRulesTest_w {
	@Autowired
	private static SimpleRefWarnsService SimpleRefWarnsService;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
          
		FileSystemXmlApplicationContext ctx =  new FileSystemXmlApplicationContext("E:\\Project\\KoRisk\\target\\classes\\spring\\spring-ruleResources.xml");
		
		SimpleRefWarnsService=(SimpleRefWarnsService) ctx.getBean("SimpleRefWarnsService");
		
		CreditParticular CreditParticular=new CreditParticular();
		CreditBusinessIn CreditBusinessIn=new CreditBusinessIn();
		CreditParticular.setId(null);
		CreditParticular.setDateOpened(null);
		CreditParticular.setDateClosed(null);
		CreditParticular.setOrgName(null);
		CreditParticular.setBusiType(null);
		CreditParticular.setSubBusiType(null);
		CreditParticular.setCurrencyType(null);
		CreditParticular.setLastUpdateDate(null);
		CreditParticular.setAcctStatus(null);
		CreditParticular.setCreditLineAmt(0);
		CreditParticular.setCreditLineAmtCny(0);
		CreditParticular.setUsedcreditLineAmtCny(0);
		CreditParticular.setUsedcreditLineAmt(0);
		CreditParticular.setPastdueAmt(0);
		CreditParticular.setPastdueBy60Cnt(0);
		CreditParticular.setPastdueM3By60Cnt(0);
		CreditParticular.setLoanBalance(0);
		CreditParticular.setLoanPeriod(0);
		CreditParticular.setMonthlyPayment(null);
		CreditParticular.setCreditBalance(0);
		CreditParticular.setOverdraftBalance(0);
		CreditParticular.setReportQueryDate(null);
		CreditParticular.setLoanProperty(null);
		CreditParticular.setAfterCardNewRecordFlag(null);
		CreditParticular.setAfterLoanCardNoNewRecordFlag(null);
		CreditParticular.setAfterLoanNewRecordFlag(null);
		CreditBusinessIn.setAppId(null);
		CreditBusinessIn.setProductCode(null);
		CreditBusinessIn.setReportQueryDate(null);
		CreditBusinessIn.setLoanGuaranteeQuery03MonthFrequency(0);
		CreditBusinessIn.setSelfQuery03MonthFrequencySameday(0);
		CreditBusinessIn.setCardApply24MonthFrequency(0);
		
		try {
			//CreditBusinessResult p=SimpleRefWarnsService.toString();
			
			
			//System.out.println("whiteNoRecord:"+p.getWhiteNoRecord()+";whiteHasRecAllJqXhMore02YearCount:"+p.getWhiteHasRecAllJqXhMore02YearCount()+
			//		";whiteAllCardWjhReportQueryLess03MonthCount:"+p.getWhiteAllCardWjhReportQueryLess03MonthCount()+";whiteAllCardLess03banlce0JqOver02Count:"+p.getWhiteAllCardLess03banlce0JqOver02Count()
			//		+";otherEndBefApplyDateNhLoanMore1WCount:"+p.getOtherEndBefApplyDateNhLoanMore1WCount()+";other3MonthQueryEXProductMore6Count:"+p.getOther3MonthQueryEXProductMore6Count()+
			//		";other3MonthQueryUProductMore8Count:"+p.getOther3MonthQueryUProductMore8Count()+";other24MonthQueryMore24Count:"+p.getOther24MonthQueryMore24Count());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	//	 File file = new File("E:/koRisk_test_file/testcase_5_12.xls");
	  //      String[][] result = DroolsTest.getData(file,6);
	    //    int rowLength = result.length;
	      //  int k=0;
	     //   int pl=0;
	     //   String qq="";
	     //   String pp="";
	     //   for(int i=0;i<rowLength;i++) {
	     //   	CreditLineIn creditLineIn2=new CreditLineIn();
	      /*  	CreditLineOut CreditLineOut_expect=new CreditLineOut();
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
		        	   case 11:   creditLineIn2.setBase(Double.parseDouble(result[i][j]));  break;
		        	   case 12 :  CreditLineOut_expect.setReturnCode(result[i][j]); System.out.println("model-expect-returncode"+i+";"+result[i][j]);  break;	
		        	   case 13 :  CreditLineOut_expect.setTimes(Double.parseDouble(result[i][j])); System.out.println("model-expect-times"+i+";"+result[i][j]);  break;
		        	   case 14 :  CreditLineOut_expect.setAmount(Double.parseDouble(result[i][j])); System.out.println("model-expect-amount"+i+";"+result[i][j]);  break;   
		        	   }
		        }
	        	
	        	CreditLineOut_fact=creditScoreAutoAuditService.creditLine(creditLineIn2);
	        	System.out.println("model-fact-"+i+";"+CreditLineOut_fact.getTimes());
	        	
	        	System.out.println("plus:"+(CreditLineOut_expect.getTimes()-CreditLineOut_fact.getTimes()));
	        	if(Math.abs(CreditLineOut_expect.getTimes()-CreditLineOut_fact.getTimes())>=0.00001){
	        		System.out.println("model-unexpected:"+i+"...............................................................");
	        		k=k+1;
	        		qq+=i+";";
	        	}
	        	System.out.println("code;"+CreditLineOut_fact.getReturnCode());
	        	if(!CreditLineOut_expect.getReturnCode().equals(CreditLineOut_fact.getReturnCode())){
	        		System.out.println("model-unexpected:"+i+"...............................................................");
	        		pl=pl+1;
	        		pp+=i+";";
	        		
	        	}
	        	
	        	
	        }
	        System.out.println("K;"+k);
	        System.out.println("pl;"+pl);
	        System.out.println("qq;"+qq);
	        System.out.println("pp;"+pp);
	        ProductRateIn productRateIn5=new ProductRateIn();
	        productRateIn5.setProductCode("Elite");
	        productRateIn5.setAge(30);
	        productRateIn5.setAppId("app132");
	        productRateIn5.setDsr(1.1);
	        productRateIn5.setIsDivorce("0");
	        productRateIn5.setIsLocal("1");
	*/
			
		
	        
	}

}
