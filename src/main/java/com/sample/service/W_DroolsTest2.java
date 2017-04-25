package com.sample.service;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.madai.model.approval.CreditScoreAutoAuditBaseIn;
import com.madai.model.approval.CreditScoreAutoAuditOneOut;
import com.madai.service.approval.CreditScoreAutoAuditService;

/**
 * This is a sample class to launch a rule.
 */
public class W_DroolsTest2 {
	@Autowired
	private static DroolsTestService droolsTestService;
	
	@Autowired
	private static CreditScoreAutoAuditService creditScoreAutoAuditService;
	private static final Logger logger = LoggerFactory
            .getLogger(W_DroolsTest2.class);
    public static final void main(String[] args) {
        try {
        	FileSystemXmlApplicationContext ctx =  new FileSystemXmlApplicationContext("D:\\work\\workspace\\appworkspace-2015-08-28\\KoRisk\\src\\main\\resources\\spring\\spring-ruleResources.xml");
    		
        	droolsTestService=(DroolsTestService) ctx.getBean("droolsTestService");
        	/*Employ emp=new Employ();
        	
        	Date startdate=new Date();
        	logger.info("startdate:"+startdate);
        	emp.setEducationInfo("master");
  	        emp.setResume("tech");
  	        emp.setBonus("good");
  	        emp.setAwardPunish("award");
        	
  	        Employ emp2=droolsTestService.applyCheckByRule(emp); 	  	       
  	        
  	        Date endate=new Date();
  	        
  	        logger.info("endate:"+endate);
  	        logger.info("endate-startdate:"+(endate.getTime()-startdate.getTime())/1000);
  	        logger.info("result:"+emp2.getTotalSalary());
  	        
  	        SimpleCreditInfo sci=new SimpleCreditInfo();
  	        sci.setLoan60PastdueM3E02Cnt(0);
  	        sci.setCard60PastdueM3E02Cnt(0);
  	        sci.setLoan60PastdueM301Cnt(2);
  	        sci.setCard60PastdueM301Cnt(0);
  	        sci.setSelfQuery03MonthFrequency(5);
  	       List<ResponseResult> rr=droolsTestService.refuseOrWarns(sci);
  	       logger.info("returnCode:"+rr.size());
  	       */
  	    /*  CreditScoreAutoAuditOneExtendIn creditScoreAutoAuditOneExtendIn=new CreditScoreAutoAuditOneExtendIn();
  	      creditScoreAutoAuditOneExtendIn.setGender("男");
  	      CreditScoreAutoAuditOneOut creditScoreAutoAuditOneOut=new CreditScoreAutoAuditOneOut();
  	      creditScoreAutoAuditOneOut=droolsTestService.creditScore(creditScoreAutoAuditOneExtendIn);
  	      System.out.println("score:"+creditScoreAutoAuditOneOut.getScore());*/
  	      
         /*CreditScoreAutoAuditBaseIn creditScoreAutoAuditBaseIn=new CreditScoreAutoAuditBaseIn();
         creditScoreAutoAuditBaseIn.setAge(20);
         CreditScoreAutoAuditOneExtendIn creditScoreAutoAuditOneExtendIn=new CreditScoreAutoAuditOneExtendIn();
         BeanUtils.copyProperties(creditScoreAutoAuditOneExtendIn,creditScoreAutoAuditBaseIn);
         System.out.println("creditScoreAutoAuditOneExtendIn:"+creditScoreAutoAuditOneExtendIn.getAge());	*/
        	
  	      creditScoreAutoAuditService=(CreditScoreAutoAuditService) ctx.getBean("creditScoreAutoAuditService");
  	      CreditScoreAutoAuditBaseIn creditScoreAutoAuditBaseIn2=new CreditScoreAutoAuditBaseIn();
  	      creditScoreAutoAuditBaseIn2.setGender("215");
  	      creditScoreAutoAuditBaseIn2.setDegree("231");
  	      creditScoreAutoAuditBaseIn2.setHouseType("219");
  	      creditScoreAutoAuditBaseIn2.setCityCategory("CL005");
  	      creditScoreAutoAuditBaseIn2.setRegion("ECR");
  	      creditScoreAutoAuditBaseIn2.setBranchCode("17");	      
  	      
  	      creditScoreAutoAuditBaseIn2.setCardOrgCNT(1);
  	      creditScoreAutoAuditBaseIn2.setCardCreditUsedPercent(new BigDecimal(0));
  	      creditScoreAutoAuditBaseIn2.setLoanAccountCNT(3);
  	      creditScoreAutoAuditBaseIn2.setCardAvgCreditLineAmt(new BigDecimal(0));
  	      creditScoreAutoAuditBaseIn2.setCardMaxCreditLineAmt(new BigDecimal(0));
  	      
  	      
  	      
	      CreditScoreAutoAuditOneOut creditScoreAutoAuditOneOut2=new CreditScoreAutoAuditOneOut();
	      creditScoreAutoAuditOneOut2=droolsTestService.creditScore(creditScoreAutoAuditBaseIn2);
	      System.out.println("score2:"+creditScoreAutoAuditOneOut2.getScore());
	      System.out.println("grouplevel2:"+creditScoreAutoAuditOneOut2.getGroupLevel());
	      System.out.println("risk:"+creditScoreAutoAuditOneOut2.getRiskLevel());
        	
/*            SimpleCreditInfo sci=new SimpleCreditInfo();*/
  	       /* sci.setLoan60PastdueM3E02Cnt(0);
  	        sci.setCard60PastdueM3E02Cnt(0);
  	        sci.setLoan60PastdueM301Cnt(2);
  	        sci.setCard60PastdueM301Cnt(0);
  	        sci.setSelfQuery03MonthFrequency(5);*/
            
/*            sci.setIdCardNo("3509021293193281983");
  	        List<ResponseResult> rr=droolsTestService.refuseOrWarns(sci);
  	        System.out.println("code:"+rr.get(0).getRefuseCode());*/
	        
	        Map<String, String> json =getGeocoderLatitude("福建泉州安溪湖头","7d9fbeb43e975cd1e9477a7e5d5e192a");  
	        System.out.println("lng : "+json.get("lng"));  
	        System.out.println("lat : "+json.get("lat")); 
	        
	        System.out.println("评分模型案例自动化测试开始：----------------------------");
	        
	        File file = new File("C:\\Users\\Eric\\Desktop\\testcase-2.xls");
	        String[][] result = getData(file,1);
	        int rowLength = result.length;
	        int k=0;
	        int pp=0;
	        int qq=0;
	        for(int i=0;i<rowLength;i++) {
	        	CreditScoreAutoAuditBaseIn creditScoreAutoAuditBaseIn=new CreditScoreAutoAuditBaseIn();
	        	CreditScoreAutoAuditOneOut creditScoreAutoAuditOneOut_expect=new CreditScoreAutoAuditOneOut();
	        	CreditScoreAutoAuditOneOut creditScoreAutoAuditOneOut_fact=new CreditScoreAutoAuditOneOut();
	        	for(int j=0;j<result[i].length-1;j++) {	
		        	 //  System.out.println("i:"+i+" ;j:"+j);  
		        	   switch(j){
		        	   case 0 :   creditScoreAutoAuditBaseIn.setBranchCode(result[i][j]); break;
		        	   case 1 :   creditScoreAutoAuditBaseIn.setGender(result[i][j]);  break;
		        	   case 2 :   creditScoreAutoAuditBaseIn.setDegree(result[i][j]);  break;
		        	   case 3 :   creditScoreAutoAuditBaseIn.setHouseType(result[i][j]);  break;
		        	   case 4 :   creditScoreAutoAuditBaseIn.setRegion(result[i][j]);  break;
		        	   case 5 :   creditScoreAutoAuditBaseIn.setCityCategory(result[i][j]);  break;
		        	   case 6 :   creditScoreAutoAuditBaseIn.setCardOrgCNT(Integer.parseInt(result[i][j]));  break;
		        	   case 7 :   creditScoreAutoAuditBaseIn.setLoanAccountCNT(Integer.parseInt(result[i][j]));  break;
		        	   case 8 :   creditScoreAutoAuditBaseIn.setSelfQuery24MonthFrequency(Integer.parseInt(result[i][j]));  break;
		        	   case 9 :   creditScoreAutoAuditBaseIn.setOrgQuery24MonthFrequency(Integer.parseInt(result[i][j]));  break;
		        	   case 10 :  creditScoreAutoAuditBaseIn.setSelfQuery03MonthFrequencyRaw(Integer.parseInt(result[i][j]));  break;
		        	   case 11 :  creditScoreAutoAuditBaseIn.setOrgQuery03MonthFrequency(Integer.parseInt(result[i][j]));  break;
		        	   case 12 :  creditScoreAutoAuditBaseIn.setCardReject24MonthFrequency(Integer.parseInt(result[i][j]));  break;
		        	   case 13 :  if("".equals(result[i][j])) break;  creditScoreAutoAuditBaseIn.setCurrentWorkMonth(Integer.parseInt(result[i][j]));  break;
		        	   case 14 :  creditScoreAutoAuditBaseIn.setCardFirstOpenMonth(Integer.parseInt(result[i][j]));  break;
		        	   case 15:   creditScoreAutoAuditBaseIn.setCardCreditUsedPercent(new BigDecimal(result[i][j]));  break;
		        	   case 16:   creditScoreAutoAuditBaseIn.setLoanFirstOpenMonth(Integer.parseInt(result[i][j]));  break;
		        	   case 17 :  creditScoreAutoAuditBaseIn.setCardAvgCreditLineAmt(new BigDecimal(result[i][j]));  break;
		        	   case 18 :  creditScoreAutoAuditBaseIn.setCardForeignOrgCNT(Integer.parseInt(result[i][j]));  break;
		        	   case 19 :  creditScoreAutoAuditBaseIn.setCardOpen06MONTHOrgCNT(Integer.parseInt(result[i][j]));  break;
		        	   case 20 :  creditScoreAutoAuditBaseIn.setCardReject06MonthFrequency(Integer.parseInt(result[i][j]));  break;
		        	   case 21 :  creditScoreAutoAuditBaseIn.setCardMaxCreditLineAmt(new BigDecimal(result[i][j]));  break;
		        	   case 22 :  creditScoreAutoAuditBaseIn.setCompanyType(result[i][j]);  break;
		        	   case 23 :  creditScoreAutoAuditOneOut_expect.setScore(new Double(result[i][j])); System.out.println("model-expect-score-"+i+";"+result[i][j]);  break;	  
		        	   case 24 :  creditScoreAutoAuditOneOut_expect.setGroupLevel(result[i][j]); System.out.println("model-expect-grouplevel-"+i+";"+result[i][j]);  break;	
		        	   case 25 :  creditScoreAutoAuditOneOut_expect.setRiskLevel(result[i][j]); System.out.println("model-expect-risklevel-"+i+";"+result[i][j]);  break;	
		        		   
		        	   }
		        }
	        	
	        	creditScoreAutoAuditOneOut_fact=droolsTestService.creditScore(creditScoreAutoAuditBaseIn);
	        	System.out.println("model-fact-"+i+";"+creditScoreAutoAuditOneOut_fact.getScore());
	        	
	        	System.out.println("plus:"+(creditScoreAutoAuditOneOut_expect.getScore()-creditScoreAutoAuditOneOut_fact.getScore()));
	        	if(Math.abs(creditScoreAutoAuditOneOut_expect.getScore()-creditScoreAutoAuditOneOut_fact.getScore())>=0.00001){
	        		System.out.println("model-unexpected:"+i+"...............................................................");
	        		k=k+1;
	        	}
	        	if(!creditScoreAutoAuditOneOut_expect.getGroupLevel().equals(creditScoreAutoAuditOneOut_fact.getGroupLevel())){
	        		System.out.println("model-unexpected:"+i+"...............................................................");
	        		pp=pp+1;
	        	}
	        	if(!creditScoreAutoAuditOneOut_expect.getRiskLevel().equals(creditScoreAutoAuditOneOut_fact.getRiskLevel()+"风险")){
	        		System.out.println("model-unexpected:"+i+"...............................................................");
	        		qq=qq+1;
	        	}
	        	
	        }
	        System.out.println("K;"+k);
	        System.out.println("pp;"+pp);
	        System.out.println("qq;"+qq);
        } catch (Throwable t) {
            t.printStackTrace();
        }        
        
        
    }
    /**
     * 读取Excel的内容，第一维数组存储的是一行中格列的值，二维数组存储的是多少个行
     * @param file 读取数据的源Excel
     * @param ignoreRows 读取数据忽略的行数，比喻行头不需要读入 忽略的行数为1
     * @return 读出的Excel中数据的内容
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static String[][] getData(File file, int ignoreRows)
           throws FileNotFoundException, IOException {
       List<String[]> result = new ArrayList<String[]>();
       int rowSize = 0;
       BufferedInputStream in = new BufferedInputStream(new FileInputStream(
              file));
       // 打开HSSFWorkbook
       POIFSFileSystem fs = new POIFSFileSystem(in);
       HSSFWorkbook wb = new HSSFWorkbook(fs);
       HSSFCell cell = null;

       for (int sheetIndex = 0; sheetIndex < wb.getNumberOfSheets(); sheetIndex++) {
           HSSFSheet st = wb.getSheetAt(sheetIndex);
           // 第一行为标题，不取
           for (int rowIndex = ignoreRows; rowIndex <= st.getLastRowNum(); rowIndex++) {
              HSSFRow row = st.getRow(rowIndex);
              if (row == null) {
                  continue;
              }
              int tempRowSize = row.getLastCellNum() + 1;
              if (tempRowSize > rowSize) {
                 rowSize = tempRowSize;
              }
              String[] values = new String[rowSize];
              Arrays.fill(values, "");
              boolean hasValue = false;
              for (short columnIndex = 0; columnIndex <= row.getLastCellNum(); columnIndex++) {
                  String value = "";
                  cell = row.getCell(columnIndex);
                  if (cell != null) {
                     // 注意：一定要设成这个，否则可能会出现乱码
                     cell.setCellType(HSSFCell.ENCODING_UTF_16);
                     switch (cell.getCellType()) {
                     case HSSFCell.CELL_TYPE_STRING:
                         value = cell.getStringCellValue();
                         break;
                     case HSSFCell.CELL_TYPE_NUMERIC:
                         if (HSSFDateUtil.isCellDateFormatted(cell)) {
    //                        Date date = cell.getDateCellValue();
                        	 value = cell.getStringCellValue();
                        	 Date date =HSSFDateUtil.getJavaDate(Double.valueOf(value));
                            if (date != null) {
                                value = new SimpleDateFormat("yyyy-MM-dd")
                                       .format(date);
                            } else {
                                value = "";
                            }
                         } else {
                            value = new DecimalFormat("0").format(cell
                                   .getNumericCellValue());
                         }
                         break;
                     case HSSFCell.CELL_TYPE_FORMULA:
                         // 导入时如果为公式生成的数据则无值
                         if (!cell.getStringCellValue().equals("")) {
                            value = cell.getStringCellValue();
                         } else {
                            value = cell.getNumericCellValue() + "";
                         }
                         break;
                     case HSSFCell.CELL_TYPE_BLANK:
                         break;
                     case HSSFCell.CELL_TYPE_ERROR:
                         value = "";
                         break;
                     case HSSFCell.CELL_TYPE_BOOLEAN:
                         value = (cell.getBooleanCellValue() == true ? "Y": "N");
                         break;
                     default:
                         value = "";
                     }
                  }
                  if (columnIndex == 0 && value.trim().equals("")) {
                     break;
                  }
                  values[columnIndex] = rightTrim(value);
                  hasValue = true;
              }
              if (hasValue) {
                  result.add(values);
              }
           }
       }
       in.close();
       String[][] returnArray = new String[result.size()][rowSize];
       for (int i = 0; i < returnArray.length; i++) {
           returnArray[i] = (String[]) result.get(i);
       }
       return returnArray;
    }
  /**
    * 去掉字符串右边的空格
    * @param str 要处理的字符串
    * @return 处理后的字符串
  */
  public static String rightTrim(String str) {
    if (str == null) {
          return "";
    }
    int length = str.length();
      for (int i = length - 1; i >= 0; i--) {
          if (str.charAt(i) != 0x20) {
              break;
           }
          length--;
       }
       return str.substring(0, length);
    }

  public static BigDecimal strToBig(String str){
	  
	  BigDecimal bg=new BigDecimal(str);
	  return bg;
  }
  public static Map<String,String> getGeocoderLatitude(String address,String KEY_1){  
      BufferedReader in = null;  
      try {  
          //将地址转换成utf-8的16进制  
          address = URLEncoder.encode(address, "UTF-8");  
//     如果有代理，要设置代理，没代理可注释  
//    System.setProperty("http.proxyHost","192.168.1.188");  
//    System.setProperty("http.proxyPort","3128");  
          URL tirc = new URL("http://api.map.baidu.com/geocoder?address="+ address +"&output=json&key="+ KEY_1);  
            
          in = new BufferedReader(new InputStreamReader(tirc.openStream(),"UTF-8"));  
          String res;  
          StringBuilder sb = new StringBuilder("");  
          while((res = in.readLine())!=null){  
              sb.append(res.trim());  
          }  
          String str = sb.toString();  
          Map<String,String> map = null;  
          if(!StringUtils.isEmpty(str)){  
              int lngStart = str.indexOf("lng\":");  
              int lngEnd = str.indexOf(",\"lat");  
              int latEnd = str.indexOf("},\"precise");  
              if(lngStart > 0 && lngEnd > 0 && latEnd > 0){  
                  String lng = str.substring(lngStart+5, lngEnd);  
                  String lat = str.substring(lngEnd+7, latEnd);  
                  map = new HashMap<String,String>();  
                  map.put("lng", lng);  
                  map.put("lat", lat);  
                  return map;  
              }  
          }  
      }catch (Exception e) {  
          e.printStackTrace();  
      }finally{  
          try {  
              in.close();  
          } catch (IOException e) {  
              e.printStackTrace();  
          }  
      }  
      return null;  
  }  
}
