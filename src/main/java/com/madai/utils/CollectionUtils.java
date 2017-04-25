package com.madai.utils;

import java.util.ArrayList;
import java.util.List;

import com.madai.model.approval.CreditBusiness.CreditParticular;

public class CollectionUtils {
	
	public static List<CreditParticular> getLastElementList(List<CreditParticular> list){
		if(list.size() == 0){
			return list;
		}else{
			List<CreditParticular> listNew = new ArrayList<>();
			listNew.add(list.get(list.size()-1));
			return listNew;
		}
	}
	
	public static  List<CreditParticular> getFirstElementList(List<CreditParticular> list){
		if(list.size() == 0){
			return list;
		}else{
			List<CreditParticular> listNew = new ArrayList<>();
			listNew.add(list.get(0));
			return listNew;
		}
	}
}
