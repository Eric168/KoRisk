package com.sample.service;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.util.StringUtils;

import com.madai.model.ResponseResult;
import com.madai.model.SimpleCreditInfo;
import com.madai.model.approval.CreditBusiness.CreditBusinessIn;
import com.madai.model.approval.CreditBusiness.CreditParticular;
import com.madai.service.SimpleRefWarnsService;
import com.madai.utils.ExcelUtils;

/**
 * This is a sample class to launch a rule.
 */
public class FileDataTest {
	@Autowired
	private static DroolsTestService droolsTestService;
	@Autowired
	private static SimpleRefWarnsService simpleRefWarnsService;
	
	private static final Logger logger = LoggerFactory
            .getLogger(FileDataTest.class);
    public static final void main(String[] args) {
        try {
        	FileSystemXmlApplicationContext ctx =  new FileSystemXmlApplicationContext("D:\\work\\project\\KoRisk-Local\\src\\main\\resources\\spring\\spring-ruleResources.xml");
    		
          droolsTestService=(DroolsTestService) ctx.getBean("droolsTestService");       

  	      simpleRefWarnsService=(SimpleRefWarnsService) ctx.getBean("simpleRefWarnsService");
  	      
  	      File mainFile = new File("d:\\data\\credit\\白户规则\\迭代测试主明细模板.xls");
  	      File detailFile = new File("d:\\data\\credit\\白户规则\\迭代测试明细模板.xls");
  	      String[][] main = ExcelUtils.getData(mainFile, 2);
  	      String[][] detail = ExcelUtils.getData(detailFile, 2);
  	      List<CreditBusinessIn> creditBusinessInList = initCreditBusinessInList(main,detail) ;
  	      int kk=0;
  	      int good = 0;
  	      for (CreditBusinessIn creditBusinessIn : creditBusinessInList) {
  	    	  logger.info("{}计算规则结果开始@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@",creditBusinessIn.getAppId());
  	    	  SimpleCreditInfo  simpleCreditInfo=new SimpleCreditInfo();
  	    	  simpleCreditInfo.setIdCardNo("4200212430214141414");
  	    	  
  	    	  List<ResponseResult> responseResultList = simpleRefWarnsService.refuseOrWarns(simpleCreditInfo, creditBusinessIn);
  	    	  String[] codeList = codeList(responseResultList);
  	    	  String[] fileCodes = getReturnCodeList(creditBusinessIn.getAppId(),main);
  	    	  if(fileCodes.length ==1 && fileCodes[0].trim().equals("")){
  	    		fileCodes = new String[0];
  	    	  }
  	    	  if(isSame(responseResultList,fileCodes)){
  	    		  logger.info("{}----------与期望值一致",creditBusinessIn.getAppId());
  	    		  good = good +1;
  	    	  }else{
  	    		  
  	    		  logger.info("{}:",responseResultList.toString());
  	    		  logger.info("appid={}--------与期望值不一致,期望值{},策略返回值{}",creditBusinessIn.getAppId(),arrayToStr(fileCodes),arrayToStr(codeList));
  	    		  
  	    		  kk+=1;
  	    	  }
  	    	  logger.info("{}计算规则结果结束----------------------------------------------------------------------\n\n",creditBusinessIn.getAppId());
		}
  	    logger.info("与期望值一致条数{}，与期望值不一致条数{}",good,kk);
  	    
        } catch (Throwable t) {
            t.printStackTrace();
        }        
        
    }
    
    private static String arrayToStr(String[] strs){
    	String ss ="";
    	for (int i = 0; i < strs.length; i++) {
			ss = ss + strs[i] +",";
		}
    	return ss;
    }
    private static boolean isSame(List<ResponseResult> responseResultList,String[] fileCodes){
    	if(responseResultList.size() != fileCodes.length){
    		return false;
    	}
    	for (ResponseResult rr  : responseResultList) {
    		if(!contain(rr.getReturnCode(),fileCodes)){
    			return false;
    		}
		}
    	return true;
    }
    private static String[] codeList(List<ResponseResult> responseResultList) {
    	String[] codes = new String[responseResultList.size()];
    	for (int i = 0; i < responseResultList.size(); i++) {
			String code = responseResultList.get(i).getReturnCode();
			codes[i] = code;
		}
		return codes;
	}
    private static boolean contain(String str,String[] codes){
    	for (int i =0;i<codes.length ; i++) {
			if(codes[i].equals(str)){
				return true;
			}
		}
    	return false;
    }
    
    private static String[] getReturnCodeList(String appId,String[][] main){
    	for (int i = 0; i < main.length; i++) {
			if(appId.equals(main[i][0])){
				String[] code = main[i][6].split(",");
				return code;
			}
		}
    	return null;
    }

    
    private static List<CreditBusinessIn> initCreditBusinessInList(String[][] main,String[][] detail) {
		List<CreditBusinessIn> list = new ArrayList<>();
		for (int r = 0; r < main.length; r++) {
			CreditBusinessIn in = new CreditBusinessIn();
			in.setAppId( trimToEmpty(main[r][0]));
			in.setCardApply24MonthFrequency(Integer.parseInt(main[r][5]));
			in.setLoanGuaranteeQuery03MonthFrequency(Integer.parseInt(main[r][3]));
			in.setSelfQuery03MonthFrequencySameday(Integer.parseInt(main[r][4]));
			in.setProductCode(main[r][1]);
			in.setIdCardNo("");
			in.setReportQueryDate(strToDate(main[r][2]));
			List<CreditParticular> creditParticularList = new ArrayList<>();
			for (int i = 0; i < detail.length; i++) {
				if(! trimToEmpty(main[r][0]).equals( trimToEmpty(detail[i][0]))){
					continue;
				}
				CreditParticular cp = new CreditParticular();
				cp.setAcctStatus( trimToEmpty(detail[i][10]));
				cp.setBusiType( trimToEmpty(detail[i][6]));
				cp.setCreditBalance(intHandle(detail[i][21]));
				cp.setCreditLineAmt(intHandle(detail[i][11]));
				cp.setCreditLineAmtCny(intHandle(detail[i][12]));
				cp.setCurrencyType(trimToEmpty(detail[i][8]));
				cp.setDateClosed(strToDate(detail[i][4]));
				cp.setDateOpened(strToDate(detail[i][3]));
				cp.setId(Long.parseLong( trimToEmpty(detail[i][1])));
				cp.setLastUpdateDate(strToDate(detail[i][9]));
				cp.setLoanBalance(intHandle(detail[i][18]));
				cp.setLoanPeriod(intHandle(detail[i][19]));
				cp.setMonthlyPayment(doubleHandle(detail[i][20]));
				cp.setOrgName( trimToEmpty(detail[i][5]));
				cp.setOverdraftBalance(intHandle(detail[i][22]));
				cp.setPastdueAmt(intHandle(detail[i][15]));
				cp.setPastdueBy60Cnt(intHandle(detail[i][16]));
				cp.setPastdueM3By60Cnt(intHandle(detail[i][17]));
				cp.setReportNumber( trimToEmpty(detail[i][2]));
				cp.setSubBusiType( trimToEmpty(detail[i][7]));
				cp.setUsedcreditLineAmt(intHandle(detail[i][14]));
				cp.setUsedcreditLineAmtCny(intHandle(detail[i][13]));
				cp.setAppId( trimToEmpty(detail[i][0]));
				cp.setReportQueryDate(strToDate(detail[i][23]));
				cp.setLoanProperty( trimToEmpty(detail[i][24]));
				cp.setAfterCardNewRecordFlag( trimToEmpty(detail[i][25]));
				cp.setAfterLoanCardNoNewRecordFlag( trimToEmpty(detail[i][27]));
				cp.setAfterLoanNewRecordFlag( trimToEmpty(detail[i][26]));
				creditParticularList.add(cp);
			}
			in.setCreditParticularList(creditParticularList);
			list.add(in);
		}
		return list;
	}
	
	private static  String trimToEmpty(String str){
		if(str == null || str.trim().equals("")){
			return "";
		}
		return str.trim();
	}
	
	private static  Date strToDate(String dateStr){
		if (StringUtils.isEmpty(dateStr)) {
			return null;
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return df.parse(dateStr.trim());
		} catch (ParseException e) {
			logger.error("类型转换错误",e);
			return null;
		}
	}
	private static  int intHandle(String str){
		if(str == null || str.trim().equals("")){
			return 0;
		}else{
			return Integer.parseInt(str.trim());
		}
	}
	
	private static  Double doubleHandle(String str){
		if(str == null || str.trim().equals("")){
			return new Double(0);
		}else{
			return Double.parseDouble(str.trim());
		}
	}

}
   