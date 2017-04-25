package com.madai.model.approval.CreditBusiness;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.madai.utils.DateUtils;

public class CreditBusinessIn {
	
	/**
	 * 批次号
	 */
	private String appId;
	
	/**
	 * 身份证号
	 */
	private String idCardNo;
	/**
	 * 产品大类code
	 */
	private String productCode;
	/**
	 * 报告查询日期
	 */
	private Date reportQueryDate;
	
	/**
	 * 近3个月贷款\担保查询次数
	 */
	private int loanGuaranteeQuery03MonthFrequency;
	/**
	 * 近3个月内查询次数-本人查询
	 */
    private int selfQuery03MonthFrequencySameday;
    /**
     * 近24个月内查询次数-信用卡审批
     */
    private int cardApply24MonthFrequency;
	
    /**
     * 全量明细数据
     */
	private List<CreditParticular> creditParticularList = new ArrayList<>();
	

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public List<CreditParticular> getCreditParticularList() {
		return creditParticularList;
	}

	public void setCreditParticularList(List<CreditParticular> creditParticularList) {
		this.creditParticularList = creditParticularList;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}


	public Date getReportQueryDate() {
		return reportQueryDate;
	}

	public void setReportQueryDate(Date reportQueryDate) {
		this.reportQueryDate = reportQueryDate;
	}

	public int getLoanGuaranteeQuery03MonthFrequency() {
		return loanGuaranteeQuery03MonthFrequency;
	}

	public void setLoanGuaranteeQuery03MonthFrequency(int loanGuaranteeQuery03MonthFrequency) {
		this.loanGuaranteeQuery03MonthFrequency = loanGuaranteeQuery03MonthFrequency;
	}

	public int getSelfQuery03MonthFrequencySameday() {
		return selfQuery03MonthFrequencySameday;
	}

	public void setSelfQuery03MonthFrequencySameday(int selfQuery03MonthFrequencySameday) {
		this.selfQuery03MonthFrequencySameday = selfQuery03MonthFrequencySameday;
	}

	public int getCardApply24MonthFrequency() {
		return cardApply24MonthFrequency;
	}

	public void setCardApply24MonthFrequency(int cardApply24MonthFrequency) {
		this.cardApply24MonthFrequency = cardApply24MonthFrequency;
	}

	@Override
	public String toString() {
		return "CreditBusinessIn [appId=" + appId + ", idCardNo=" + idCardNo
				+ ", productCode=" + productCode + ", reportQueryDate="
				+ DateUtils.dateToStr(reportQueryDate) + ", loanGuaranteeQuery03MonthFrequency="
				+ loanGuaranteeQuery03MonthFrequency
				+ ", selfQuery03MonthFrequencySameday="
				+ selfQuery03MonthFrequencySameday
				+ ", cardApply24MonthFrequency=" + cardApply24MonthFrequency
				+ ", creditParticularList=" + creditParticularList + "]";
	}
	
	
	
}
