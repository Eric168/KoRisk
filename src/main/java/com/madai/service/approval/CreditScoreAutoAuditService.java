package com.madai.service.approval;


import com.madai.model.approval.CreditScoreAutoAuditBaseIn;
import com.madai.model.approval.CreditScoreAutoAuditOneOut;
import com.madai.model.approval.CreditLine.CreditLineIn;
import com.madai.model.approval.CreditLine.CreditLineOut;
import com.madai.model.approval.ProductRate.ProductRateIn;
import com.madai.model.approval.ProductRate.ProductRateOut;


public interface CreditScoreAutoAuditService {
    	  
	public CreditScoreAutoAuditOneOut creditScore(CreditScoreAutoAuditBaseIn creditScoreAutoAuditBaseIn);
	public CreditLineOut creditLine(CreditLineIn creditLineIn) throws Exception;
	public ProductRateOut productRate(ProductRateIn productRateIn) throws Exception;
}

