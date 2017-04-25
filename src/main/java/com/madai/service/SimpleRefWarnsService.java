package com.madai.service;

import java.util.List;

import com.madai.model.ResponseResult;
import com.madai.model.SimpleCreditInfo;
import com.madai.model.approval.CreditBusiness.CreditBusinessIn;


public interface SimpleRefWarnsService {
    	  
	  public List<ResponseResult> refuseOrWarns(SimpleCreditInfo simpleCreditInfo,CreditBusinessIn creditBusinessIn);
	  
	  public List<ResponseResult> registerInform(SimpleCreditInfo simpleCreditInfo); 
	  
}

