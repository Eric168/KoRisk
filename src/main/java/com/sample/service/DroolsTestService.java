package com.sample.service;

import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.sample.model.Employ;
import com.madai.model.ResponseResult;
import com.madai.model.SimpleCreditInfo;
import com.madai.model.approval.CreditScoreAutoAuditBaseIn;
import com.madai.model.approval.CreditScoreAutoAuditOneOut;

/**
 * This is a sample class to launch a rule.
 */
public interface DroolsTestService {
    
	  public Employ applyCheckByRule(Employ employ);
	  
	  public List<ResponseResult> refuseOrWarns(SimpleCreditInfo simpleCreditInfo);
	  
	  public CreditScoreAutoAuditOneOut creditScore(CreditScoreAutoAuditBaseIn creditScoreAutoAuditBaseIn);
	  
	  public List<ResponseResult> registerInform(SimpleCreditInfo simpleCreditInfo); 
	  
}

