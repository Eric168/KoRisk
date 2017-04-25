package com.madai.model;

import java.math.BigDecimal;

public class SimpleCreditInfo {
    
	private String idCardNo;//客户身份证号
	private String mateIdCardNo;//配偶身份证号
	private String branchCode;//门店code
	private String groupLevel;//分群
	private String riskLevel;//风险等级	
	
	private int loan60PastdueM3E02Non2MCNT;//最近5年内逾期超出90天月数大于等于2次的贷款账户数（排除结清大于2年的贷款账户）
	private int card60PastdueM3E02Non2MCNT;//最近5年内逾期超出90天月数大于等于2次的贷记卡账户数（排除结清大于2年的贷记卡账户）
	private int loan60PastdueM3E01Non2MCNT;//最近5年内逾期超出90天月数等于1次的贷款账户数        （排除结清大于2年的贷款账户）
	private int card60PastdueM3E01Non2MCNT;//最近5年内逾期超出90天月数等于1次的贷记卡账户数    （排除结清大于2年的贷记卡账户）
	private int cardCancelMonthCNT;//贷记卡销户月份数
	private int loanClearedMonthCNT;//贷款结清月份数
	private int loan60PastdueM3E02Cnt;//最近5年内逾期超出90天月数大于等于2次的贷款账户数
	private int card60PastdueM3E02Cnt;//最近5年内逾期超出90天月数大于等于2次的贷记卡账户数
	private int loan60PastdueM301Cnt;//最近5年内逾期超出90天月数等于1次的贷款账户数
	private int card60PastdueM301Cnt;//最近5年内逾期超出90天月数等于1次的贷记卡账户数
	private int loan60PastdueFrequency;//最近贷款账户5年内逾期的总次数
	private int card60PastdueFrequency;//最近贷记卡账户5年内逾期的总次数
	private int loanPastdueCnt;//当前有逾期的贷款账户数
	private int cardPastdueCnt;//当前有逾期的贷记卡账户数
	private int semiCardPastdueCnt;//当前有逾期的准贷记卡账户数
    private int loan60PastdueCnt;//最近5年内逾期次数大于等于2次的贷款账户数
    private int card60PastdueCnt;//最近5年内逾期次数大于等于2次的贷记卡账户数
    private int loanBadDebtCnt;//当前出现呆账的贷款账户数
    private int loanCancelCnt;//当前出现G(核销)的贷款账户数
    private int cardBadDebtCnt;//当前出现呆账的贷记卡账户数
    private int cardCancelCnt;//当前出现G(核销)的贷记卡账户数
    private int semiCardBadDebtCnt;//当前出现呆账的准贷记卡账户数
    private int semiWriteOffDebtCnt;//当前出现G(核销)的准贷记卡账户数
    private int semiStopDebtCnt;//当前出现止付的准贷记卡账户数
    private int semiCardFreezeCnt;//当前出现冻结的准贷记卡账户数
    private int loanFocusCnt;//当前出现关注的贷款账户数
    private int loanSecondaryCnt;//当前出现次级的贷款账户数
    private int loanSuspenseCnt;//当前出现可疑的贷款账户数
    private int loanLossCnt;//当前出现损失的贷款账户数
    private int loanZCnt;//当前出现Z（以资抵债）贷款账户数
    private int cardStopCnt;//当前出现止付的贷记卡账户数
    private int cardFreezeCnt;//当前出现冻结的贷记卡账户数
    private int loanExam01MonthFrequency;//最近一个月内查询次数-贷款审批
    private int selfQuery03MonthFrequency;//最近三个月内查询次数-本人查询
    private int selfQueryWeekFrequency;//最近一周内查询次数-本人查询
    private BigDecimal cardUsedcreditLineAmtSum;//贷记卡使用总额度
    private BigDecimal cardCreditLineAmtSum;//贷记卡授信总额度
    private BigDecimal cardOver100Pct;//贷记卡的透支率
    private int loanPeriod;//贷款借款年限
    private BigDecimal loanMonthReturn;//贷款月还总和
    private BigDecimal liabilityMonth;//隐形负债\月
    private BigDecimal cardTotalUsedamt;//信用卡总使用额度
    private BigDecimal avgLiabilityMonth;//月均负债
    private BigDecimal avgIncomeMonth;//月均收入
    private BigDecimal socialSecurityMonth;//当前一个月的社保金额
    private BigDecimal fundMonth;//当前一个月的公积金金额
    private BigDecimal bankFlowMonth;//银行流水\月
    private BigDecimal otherIncomeMonth;//表外收入
    private BigDecimal debtRatio;//负债率
    private String customerClassification;//客户分类
	public String getIdCardNo() {
		return idCardNo;
	}
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
	public String getMateIdCardNo() {
		return mateIdCardNo;
	}
	public void setMateIdCardNo(String mateIdCardNo) {
		this.mateIdCardNo = mateIdCardNo;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getGroupLevel() {
		return groupLevel;
	}
	public void setGroupLevel(String groupLevel) {
		this.groupLevel = groupLevel;
	}
	public String getRiskLevel() {
		return riskLevel;
	}
	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}
	public int getLoan60PastdueM3E02Non2MCNT() {
		return loan60PastdueM3E02Non2MCNT;
	}
	public void setLoan60PastdueM3E02Non2MCNT(int loan60PastdueM3E02Non2MCNT) {
		this.loan60PastdueM3E02Non2MCNT = loan60PastdueM3E02Non2MCNT;
	}
	public int getCard60PastdueM3E02Non2MCNT() {
		return card60PastdueM3E02Non2MCNT;
	}
	public void setCard60PastdueM3E02Non2MCNT(int card60PastdueM3E02Non2MCNT) {
		this.card60PastdueM3E02Non2MCNT = card60PastdueM3E02Non2MCNT;
	}
	public int getLoan60PastdueM3E01Non2MCNT() {
		return loan60PastdueM3E01Non2MCNT;
	}
	public void setLoan60PastdueM3E01Non2MCNT(int loan60PastdueM3E01Non2MCNT) {
		this.loan60PastdueM3E01Non2MCNT = loan60PastdueM3E01Non2MCNT;
	}
	public int getCard60PastdueM3E01Non2MCNT() {
		return card60PastdueM3E01Non2MCNT;
	}
	public void setCard60PastdueM3E01Non2MCNT(int card60PastdueM3E01Non2MCNT) {
		this.card60PastdueM3E01Non2MCNT = card60PastdueM3E01Non2MCNT;
	}
	public int getCardCancelMonthCNT() {
		return cardCancelMonthCNT;
	}
	public void setCardCancelMonthCNT(int cardCancelMonthCNT) {
		this.cardCancelMonthCNT = cardCancelMonthCNT;
	}
	public int getLoanClearedMonthCNT() {
		return loanClearedMonthCNT;
	}
	public void setLoanClearedMonthCNT(int loanClearedMonthCNT) {
		this.loanClearedMonthCNT = loanClearedMonthCNT;
	}
	public int getLoan60PastdueM3E02Cnt() {
		return loan60PastdueM3E02Cnt;
	}
	public void setLoan60PastdueM3E02Cnt(int loan60PastdueM3E02Cnt) {
		this.loan60PastdueM3E02Cnt = loan60PastdueM3E02Cnt;
	}
	public int getCard60PastdueM3E02Cnt() {
		return card60PastdueM3E02Cnt;
	}
	public void setCard60PastdueM3E02Cnt(int card60PastdueM3E02Cnt) {
		this.card60PastdueM3E02Cnt = card60PastdueM3E02Cnt;
	}
	
	public int getLoan60PastdueM301Cnt() {
		return loan60PastdueM301Cnt;
	}
	public void setLoan60PastdueM301Cnt(int loan60PastdueM301Cnt) {
		this.loan60PastdueM301Cnt = loan60PastdueM301Cnt;
	}
	public int getCard60PastdueM301Cnt() {
		return card60PastdueM301Cnt;
	}
	public void setCard60PastdueM301Cnt(int card60PastdueM301Cnt) {
		this.card60PastdueM301Cnt = card60PastdueM301Cnt;
	}
	public int getLoan60PastdueFrequency() {
		return loan60PastdueFrequency;
	}
	public void setLoan60PastdueFrequency(int loan60PastdueFrequency) {
		this.loan60PastdueFrequency = loan60PastdueFrequency;
	}
	public int getCard60PastdueFrequency() {
		return card60PastdueFrequency;
	}
	public void setCard60PastdueFrequency(int card60PastdueFrequency) {
		this.card60PastdueFrequency = card60PastdueFrequency;
	}
	public int getLoanPastdueCnt() {
		return loanPastdueCnt;
	}
	public void setLoanPastdueCnt(int loanPastdueCnt) {
		this.loanPastdueCnt = loanPastdueCnt;
	}
	public int getCardPastdueCnt() {
		return cardPastdueCnt;
	}
	public void setCardPastdueCnt(int cardPastdueCnt) {
		this.cardPastdueCnt = cardPastdueCnt;
	}
	public int getSemiCardPastdueCnt() {
		return semiCardPastdueCnt;
	}
	public void setSemiCardPastdueCnt(int semiCardPastdueCnt) {
		this.semiCardPastdueCnt = semiCardPastdueCnt;
	}
	public int getLoan60PastdueCnt() {
		return loan60PastdueCnt;
	}
	public void setLoan60PastdueCnt(int loan60PastdueCnt) {
		this.loan60PastdueCnt = loan60PastdueCnt;
	}
	public int getCard60PastdueCnt() {
		return card60PastdueCnt;
	}
	public void setCard60PastdueCnt(int card60PastdueCnt) {
		this.card60PastdueCnt = card60PastdueCnt;
	}
	public int getLoanBadDebtCnt() {
		return loanBadDebtCnt;
	}
	public void setLoanBadDebtCnt(int loanBadDebtCnt) {
		this.loanBadDebtCnt = loanBadDebtCnt;
	}
	public int getLoanCancelCnt() {
		return loanCancelCnt;
	}
	public void setLoanCancelCnt(int loanCancelCnt) {
		this.loanCancelCnt = loanCancelCnt;
	}
	public int getCardBadDebtCnt() {
		return cardBadDebtCnt;
	}
	public void setCardBadDebtCnt(int cardBadDebtCnt) {
		this.cardBadDebtCnt = cardBadDebtCnt;
	}
	public int getCardCancelCnt() {
		return cardCancelCnt;
	}
	public void setCardCancelCnt(int cardCancelCnt) {
		this.cardCancelCnt = cardCancelCnt;
	}
	public int getSemiCardBadDebtCnt() {
		return semiCardBadDebtCnt;
	}
	public void setSemiCardBadDebtCnt(int semiCardBadDebtCnt) {
		this.semiCardBadDebtCnt = semiCardBadDebtCnt;
	}
	public int getSemiWriteOffDebtCnt() {
		return semiWriteOffDebtCnt;
	}
	public void setSemiWriteOffDebtCnt(int semiWriteOffDebtCnt) {
		this.semiWriteOffDebtCnt = semiWriteOffDebtCnt;
	}
	public int getSemiStopDebtCnt() {
		return semiStopDebtCnt;
	}
	public void setSemiStopDebtCnt(int semiStopDebtCnt) {
		this.semiStopDebtCnt = semiStopDebtCnt;
	}
	public int getSemiCardFreezeCnt() {
		return semiCardFreezeCnt;
	}
	public void setSemiCardFreezeCnt(int semiCardFreezeCnt) {
		this.semiCardFreezeCnt = semiCardFreezeCnt;
	}
	public int getLoanFocusCnt() {
		return loanFocusCnt;
	}
	public void setLoanFocusCnt(int loanFocusCnt) {
		this.loanFocusCnt = loanFocusCnt;
	}
	public int getLoanSecondaryCnt() {
		return loanSecondaryCnt;
	}
	public void setLoanSecondaryCnt(int loanSecondaryCnt) {
		this.loanSecondaryCnt = loanSecondaryCnt;
	}
	public int getLoanSuspenseCnt() {
		return loanSuspenseCnt;
	}
	public void setLoanSuspenseCnt(int loanSuspenseCnt) {
		this.loanSuspenseCnt = loanSuspenseCnt;
	}
	public int getLoanLossCnt() {
		return loanLossCnt;
	}
	public void setLoanLossCnt(int loanLossCnt) {
		this.loanLossCnt = loanLossCnt;
	}
	public int getLoanZCnt() {
		return loanZCnt;
	}
	public void setLoanZCnt(int loanZCnt) {
		this.loanZCnt = loanZCnt;
	}
	public int getCardStopCnt() {
		return cardStopCnt;
	}
	public void setCardStopCnt(int cardStopCnt) {
		this.cardStopCnt = cardStopCnt;
	}
	public int getCardFreezeCnt() {
		return cardFreezeCnt;
	}
	public void setCardFreezeCnt(int cardFreezeCnt) {
		this.cardFreezeCnt = cardFreezeCnt;
	}
	public int getLoanExam01MonthFrequency() {
		return loanExam01MonthFrequency;
	}
	public void setLoanExam01MonthFrequency(int loanExam01MonthFrequency) {
		this.loanExam01MonthFrequency = loanExam01MonthFrequency;
	}
	public int getSelfQuery03MonthFrequency() {
		return selfQuery03MonthFrequency;
	}
	public void setSelfQuery03MonthFrequency(int selfQuery03MonthFrequency) {
		this.selfQuery03MonthFrequency = selfQuery03MonthFrequency;
	}
	public int getSelfQueryWeekFrequency() {
		return selfQueryWeekFrequency;
	}
	public void setSelfQueryWeekFrequency(int selfQueryWeekFrequency) {
		this.selfQueryWeekFrequency = selfQueryWeekFrequency;
	}
	public BigDecimal getCardUsedcreditLineAmtSum() {
		return cardUsedcreditLineAmtSum;
	}
	public void setCardUsedcreditLineAmtSum(BigDecimal cardUsedcreditLineAmtSum) {
		this.cardUsedcreditLineAmtSum = cardUsedcreditLineAmtSum;
	}
	public BigDecimal getCardCreditLineAmtSum() {
		return cardCreditLineAmtSum;
	}
	public void setCardCreditLineAmtSum(BigDecimal cardCreditLineAmtSum) {
		this.cardCreditLineAmtSum = cardCreditLineAmtSum;
	}
	public BigDecimal getCardOver100Pct() {
		return cardOver100Pct;
	}
	public void setCardOver100Pct(BigDecimal cardOver100Pct) {
		this.cardOver100Pct = cardOver100Pct;
	}
	public int getLoanPeriod() {
		return loanPeriod;
	}
	public void setLoanPeriod(int loanPeriod) {
		this.loanPeriod = loanPeriod;
	}
	public BigDecimal getLoanMonthReturn() {
		return loanMonthReturn;
	}
	public void setLoanMonthReturn(BigDecimal loanMonthReturn) {
		this.loanMonthReturn = loanMonthReturn;
	}
	public BigDecimal getLiabilityMonth() {
		return liabilityMonth;
	}
	public void setLiabilityMonth(BigDecimal liabilityMonth) {
		this.liabilityMonth = liabilityMonth;
	}
	public BigDecimal getCardTotalUsedamt() {
		return cardTotalUsedamt;
	}
	public void setCardTotalUsedamt(BigDecimal cardTotalUsedamt) {
		this.cardTotalUsedamt = cardTotalUsedamt;
	}
	public BigDecimal getAvgLiabilityMonth() {
		return avgLiabilityMonth;
	}
	public void setAvgLiabilityMonth(BigDecimal avgLiabilityMonth) {
		this.avgLiabilityMonth = avgLiabilityMonth;
	}
	public BigDecimal getAvgIncomeMonth() {
		return avgIncomeMonth;
	}
	public void setAvgIncomeMonth(BigDecimal avgIncomeMonth) {
		this.avgIncomeMonth = avgIncomeMonth;
	}
	public BigDecimal getSocialSecurityMonth() {
		return socialSecurityMonth;
	}
	public void setSocialSecurityMonth(BigDecimal socialSecurityMonth) {
		this.socialSecurityMonth = socialSecurityMonth;
	}
	public BigDecimal getFundMonth() {
		return fundMonth;
	}
	public void setFundMonth(BigDecimal fundMonth) {
		this.fundMonth = fundMonth;
	}
	public BigDecimal getBankFlowMonth() {
		return bankFlowMonth;
	}
	public void setBankFlowMonth(BigDecimal bankFlowMonth) {
		this.bankFlowMonth = bankFlowMonth;
	}
	public BigDecimal getOtherIncomeMonth() {
		return otherIncomeMonth;
	}
	public void setOtherIncomeMonth(BigDecimal otherIncomeMonth) {
		this.otherIncomeMonth = otherIncomeMonth;
	}
	public BigDecimal getDebtRatio() {
		return debtRatio;
	}
	public void setDebtRatio(BigDecimal debtRatio) {
		this.debtRatio = debtRatio;
	}
	public String getCustomerClassification() {
		return customerClassification;
	}
	public void setCustomerClassification(String customerClassification) {
		this.customerClassification = customerClassification;
	}
	@Override
	public String toString() {
		return "SimpleCreditInfo [idCardNo=" + idCardNo + ", mateIdCardNo="
				+ mateIdCardNo + ", branchCode=" + branchCode + ", groupLevel="
				+ groupLevel + ", riskLevel=" + riskLevel
				+ ", loan60PastdueM3E02Non2MCNT=" + loan60PastdueM3E02Non2MCNT
				+ ", card60PastdueM3E02Non2MCNT=" + card60PastdueM3E02Non2MCNT
				+ ", loan60PastdueM3E01Non2MCNT=" + loan60PastdueM3E01Non2MCNT
				+ ", card60PastdueM3E01Non2MCNT=" + card60PastdueM3E01Non2MCNT
				+ ", cardCancelMonthCNT=" + cardCancelMonthCNT
				+ ", loanClearedMonthCNT=" + loanClearedMonthCNT
				+ ", loan60PastdueM3E02Cnt=" + loan60PastdueM3E02Cnt
				+ ", card60PastdueM3E02Cnt=" + card60PastdueM3E02Cnt
				+ ", loan60PastdueM301Cnt=" + loan60PastdueM301Cnt
				+ ", card60PastdueM301Cnt=" + card60PastdueM301Cnt
				+ ", loan60PastdueFrequency=" + loan60PastdueFrequency
				+ ", card60PastdueFrequency=" + card60PastdueFrequency
				+ ", loanPastdueCnt=" + loanPastdueCnt + ", cardPastdueCnt="
				+ cardPastdueCnt + ", semiCardPastdueCnt=" + semiCardPastdueCnt
				+ ", loan60PastdueCnt=" + loan60PastdueCnt
				+ ", card60PastdueCnt=" + card60PastdueCnt
				+ ", loanBadDebtCnt=" + loanBadDebtCnt + ", loanCancelCnt="
				+ loanCancelCnt + ", cardBadDebtCnt=" + cardBadDebtCnt
				+ ", cardCancelCnt=" + cardCancelCnt + ", semiCardBadDebtCnt="
				+ semiCardBadDebtCnt + ", semiWriteOffDebtCnt="
				+ semiWriteOffDebtCnt + ", semiStopDebtCnt=" + semiStopDebtCnt
				+ ", semiCardFreezeCnt=" + semiCardFreezeCnt
				+ ", loanFocusCnt=" + loanFocusCnt + ", loanSecondaryCnt="
				+ loanSecondaryCnt + ", loanSuspenseCnt=" + loanSuspenseCnt
				+ ", loanLossCnt=" + loanLossCnt + ", loanZCnt=" + loanZCnt
				+ ", cardStopCnt=" + cardStopCnt + ", cardFreezeCnt="
				+ cardFreezeCnt + ", loanExam01MonthFrequency="
				+ loanExam01MonthFrequency + ", selfQuery03MonthFrequency="
				+ selfQuery03MonthFrequency + ", selfQueryWeekFrequency="
				+ selfQueryWeekFrequency + ", cardUsedcreditLineAmtSum="
				+ cardUsedcreditLineAmtSum + ", cardCreditLineAmtSum="
				+ cardCreditLineAmtSum + ", cardOver100Pct=" + cardOver100Pct
				+ ", loanPeriod=" + loanPeriod + ", loanMonthReturn="
				+ loanMonthReturn + ", liabilityMonth=" + liabilityMonth
				+ ", cardTotalUsedamt=" + cardTotalUsedamt
				+ ", avgLiabilityMonth=" + avgLiabilityMonth
				+ ", avgIncomeMonth=" + avgIncomeMonth
				+ ", socialSecurityMonth=" + socialSecurityMonth
				+ ", fundMonth=" + fundMonth + ", bankFlowMonth="
				+ bankFlowMonth + ", otherIncomeMonth=" + otherIncomeMonth
				+ ", debtRatio=" + debtRatio + ", customerClassification="
				+ customerClassification + "]";
	}
   
}
