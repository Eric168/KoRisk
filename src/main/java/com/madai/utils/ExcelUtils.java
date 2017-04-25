package com.madai.utils;

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

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.util.StringUtils;

public class ExcelUtils {

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
