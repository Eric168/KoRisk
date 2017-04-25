package com.madai.utils;

public class DataUtils {
	
	public static double fromDouble(Double d){
		if(d == null ){
			return 0;
		}else{
			return d.doubleValue();
		}
	}
}
