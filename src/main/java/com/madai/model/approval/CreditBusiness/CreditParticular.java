package com.madai.model.approval.CreditBusiness;

import java.util.Date;

import com.madai.utils.DataUtils;
import com.madai.utils.DateUtils;

public class CreditParticular {
    private Long id;
    
    /**
     * 批次号
     */
	private String appId;
    /**
     * 报告编号
     */
    private String reportNumber;

    /**
     * 开始日期
     */
    private Date dateOpened;

    /**
     * 到期日期
     */
    private Date dateClosed;

    /**
     * 机构名称
     */
    private String orgName;

    /**
     * 业务类型
     */
    private String busiType;
    
    /**
     * 细分业务类型
     */
    private String subBusiType;

    /**
     * 币种
     */
    private String currencyType;


    /**
     * 最后更新日期、截止日期、结清日期
     */
    private Date lastUpdateDate;

    /**
     * 账户状态
     */
    private String acctStatus;

    /**
     * 授信额度
     */
    private int creditLineAmt;

    /**
     * 折合人民币授信额度
     */
    private int creditLineAmtCny;

    /**
     * 折合人民币已使用额度
     */
    private int usedcreditLineAmtCny;

    /**
     * 已使用额度
     */
    private int usedcreditLineAmt;

    /**
     * 已逾期金额
     */
    private int pastdueAmt;
    
    /**
     * 最近5年处于逾期月数
     */
    private int pastdueBy60Cnt;

    /**
     * 最近5年处于90天以上逾期月数
     */
    private int pastdueM3By60Cnt;

    /**
     * 贷款余额
     */
    private int loanBalance;

    /**
     * 贷款年限
     */
    private int loanPeriod;
    
    /**
     * 每月还款
     */
    private Double monthlyPayment;

    /**
     * 呆账余额
     */
    private int creditBalance;

    /**
     * 透支余额
     */
    private int overdraftBalance;

	/**
	 * 报告查询日期
	 */
	private Date reportQueryDate;
	
	/**
	 * 贷款性质类型
	 * 无抵押贷款的标准:'01'
	 * 其他性质贷款的标准:'02'
	 * 房产抵押贷款标准:'03'
	 * 车辆抵押贷款标准:'04'
	 * 农户性质贷款的标准:'05'
	 * 其它或非贷款记录：'00'
	 */
	private String loanProperty;
	
	/**
	 * 销户日期当月及以后或截至时间当月及以后有无发放新的贷记卡或贷款
	 * （农户性质贷款、低于5000元的消费分期除外）标志
	 * 若有新的贷记卡或贷款，此变量值就标注为1
	 * 若无新的贷记卡或贷款，此变量值就标注为0
	 * 贷款记录标注为 -1
	 */
	private String afterCardNewRecordFlag;
	
	/**
	 * 结清日期当月及以后或截至时间当月及以后有无发放新的贷记卡或贷款
	 * （农户性质贷款、低于5000元的消费分期除外）标志
	 * 若有新的贷记卡或贷款，此变量值就标注为1. 
	 * 若无新的贷记卡或贷款，此变量值就标注为0.
	 * 信用卡记录标注为 -1
	 */
	private String afterLoanNewRecordFlag;
	
	/**
	 * 无从未逾期过的贷记卡或贷款（排除已使用额度为0、农户贷款、未激活、
	 * 低于5000元的消费分期，使用记录不足半年）标志
	 * 若有逾期贷记卡或贷款，此变量值就标注为1. 
	 * 无逾期的贷记卡或贷款，此变量值就标注为0.
	 */
	private String afterLoanCardNoNewRecordFlag;
	
	/**
	 * 贷款发放时间
	 * @return
	 */
    public int loanOpenMonths(){
    	Date date = null;
    	if(lastUpdateDate == null && dateClosed == null){
    		return -1;
    	}
    	if(lastUpdateDate == null && dateClosed != null){
    		date = dateClosed;
    	}
    	if(lastUpdateDate != null && dateClosed == null){
    		date = lastUpdateDate;
    	}
    	if(lastUpdateDate != null && dateClosed != null){
    		if(lastUpdateDate.before(dateClosed)){
    			date = lastUpdateDate;
    		}else{
    			date = dateClosed;
    		}
    	}
    	int m = DateUtils.calculateMonth(dateOpened, date);
    	return m;
    }
    
	/**
	 * 贷记卡发放时间、发卡月份数
	 * @return
	 */
    public int cardOpenMonths(){
    	Date date = null;
    	if(lastUpdateDate == null && dateClosed == null){
    		return -1;
    	}
    	if(lastUpdateDate == null && dateClosed != null){
    		date = dateClosed;
    	}
    	if(lastUpdateDate != null && dateClosed == null){
    		date = lastUpdateDate;
    	}
    	if(lastUpdateDate != null && dateClosed != null){
    		if(lastUpdateDate.before(dateClosed)){
    			date = lastUpdateDate;
    		}else{
    			date = dateClosed;
    		}
    	}
    	int m = DateUtils.calculateMonth(dateOpened, date);
    	return m;
    }
    
	/**
	 * 已还款月份数
	 * @return
	 */
    public int alreadyRepaymentMonths(){
    	Date date = null;
    	if(lastUpdateDate == null && dateClosed == null){
    		return -1;
    	}
    	if(lastUpdateDate == null && dateClosed != null){
    		date = dateClosed;
    	}
    	if(lastUpdateDate != null && dateClosed == null){
    		date = lastUpdateDate;
    	}
    	if(lastUpdateDate != null && dateClosed != null){
    		if(lastUpdateDate.before(dateClosed)){
    			date = lastUpdateDate;
    		}else{
    			date = dateClosed;
    		}
    	}
    	int m = DateUtils.calculateMonth(dateOpened, date);
    	return m;
    }
    
    /**
     * 贷记卡销户时间
     * @return
     */
    public int cardAccountClosedMonths(){
    	int m = DateUtils.calculateMonth(reportQueryDate, lastUpdateDate);
    	return m;
    }
    
    /**
     * 贷款结清时间
     * @return
     */
    public int loanSettlemonths(){
    	int m = DateUtils.calculateMonth(reportQueryDate, dateClosed);
    	return m;
    }
    

    public int months1(){
    	int m = DateUtils.calculateMonth(dateOpened, lastUpdateDate);
    	return m;
    }
    

    public int months2(){
    	int m = DateUtils.calculateMonth(reportQueryDate, lastUpdateDate);
    	return m;
    }
	
	public String getAfterCardNewRecordFlag() {
		return afterCardNewRecordFlag;
	}

	public void setAfterCardNewRecordFlag(String afterCardNewRecordFlag) {
		this.afterCardNewRecordFlag = afterCardNewRecordFlag;
	}

	public String getAfterLoanNewRecordFlag() {
		return afterLoanNewRecordFlag;
	}

	public void setAfterLoanNewRecordFlag(String afterLoanNewRecordFlag) {
		this.afterLoanNewRecordFlag = afterLoanNewRecordFlag;
	}

	public String getAfterLoanCardNoNewRecordFlag() {
		return afterLoanCardNoNewRecordFlag;
	}

	public void setAfterLoanCardNoNewRecordFlag(String afterLoanCardNoNewRecordFlag) {
		this.afterLoanCardNoNewRecordFlag = afterLoanCardNoNewRecordFlag;
	}

	public String getLoanProperty() {
		return loanProperty;
	}

	public void setLoanProperty(String loanProperty) {
		this.loanProperty = loanProperty;
	}



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(String reportNumber) {
        this.reportNumber = reportNumber == null ? null : reportNumber.trim();
    }

    public Date getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(Date dateOpened) {
        this.dateOpened = dateOpened;
    }

    public Date getDateClosed() {
        return dateClosed;
    }

    public void setDateClosed(Date dateClosed) {
        this.dateClosed = dateClosed;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getBusiType() {
        return busiType;
    }

    public void setBusiType(String busiType) {
        this.busiType = busiType == null ? null : busiType.trim();
    }

    public String getSubBusiType() {
        return subBusiType;
    }

    public void setSubBusiType(String subBusiType) {
        this.subBusiType = subBusiType == null ? null : subBusiType.trim();
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType == null ? null : currencyType.trim();
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(String acctStatus) {
        this.acctStatus = acctStatus == null ? null : acctStatus.trim();
    }

    public int getCreditLineAmt() {
        return creditLineAmt;
    }

    public void setCreditLineAmt(int creditLineAmt) {
        this.creditLineAmt = creditLineAmt;
    }

    public int getCreditLineAmtCny() {
        return creditLineAmtCny;
    }

    public void setCreditLineAmtCny(int creditLineAmtCny) {
        this.creditLineAmtCny = creditLineAmtCny;
    }

    public int getUsedcreditLineAmtCny() {
        return usedcreditLineAmtCny;
    }

    public void setUsedcreditLineAmtCny(int usedcreditLineAmtCny) {
        this.usedcreditLineAmtCny = usedcreditLineAmtCny;
    }

    public int getUsedcreditLineAmt() {
        return usedcreditLineAmt;
    }

    public void setUsedcreditLineAmt(int usedcreditLineAmt) {
        this.usedcreditLineAmt = usedcreditLineAmt;
    }

    public int getPastdueAmt() {
        return pastdueAmt;
    }

    public void setPastdueAmt(int pastdueAmt) {
        this.pastdueAmt = pastdueAmt;
    }

    public int getPastdueBy60Cnt() {
        return pastdueBy60Cnt;
    }

    public void setPastdueBy60Cnt(int pastdueBy60Cnt) {
        this.pastdueBy60Cnt = pastdueBy60Cnt;
    }

    public int getPastdueM3By60Cnt() {
        return pastdueM3By60Cnt;
    }

    public void setPastdueM3By60Cnt(int pastdueM3By60Cnt) {
        this.pastdueM3By60Cnt = pastdueM3By60Cnt;
    }

    public int getLoanBalance() {
        return loanBalance;
    }

    public void setLoanBalance(int loanBalance) {
        this.loanBalance = loanBalance;
    }

    public int getLoanPeriod() {
        return loanPeriod;
    }

    public void setLoanPeriod(int loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public Double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(Double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public int getCreditBalance() {
        return creditBalance;
    }

    public void setCreditBalance(int creditBalance) {
        this.creditBalance = creditBalance;
    }

    public int getOverdraftBalance() {
        return overdraftBalance;
    }

    public void setOverdraftBalance(int overdraftBalance) {
        this.overdraftBalance = overdraftBalance;
    }
    
	public Date getReportQueryDate() {
		return reportQueryDate;
	}

	public void setReportQueryDate(Date reportQueryDate) {
		this.reportQueryDate = reportQueryDate;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	@Override
	public String toString() {
		return "CreditParticular [id=" + id + ", appId=" + appId
				+ ", reportNumber=" + reportNumber + ", dateOpened="
				+ DateUtils.dateToStr(dateOpened) + ", dateClosed=" + DateUtils.dateToStr(dateClosed) + ", orgName="
				+ orgName + ", busiType=" + busiType + ", subBusiType="
				+ subBusiType + ", currencyType=" + currencyType
				+ ", lastUpdateDate=" + DateUtils.dateToStr(lastUpdateDate) + ", acctStatus="
				+ acctStatus + ", creditLineAmt=" + creditLineAmt
				+ ", creditLineAmtCny=" + creditLineAmtCny
				+ ", usedcreditLineAmtCny=" + usedcreditLineAmtCny
				+ ", usedcreditLineAmt=" + usedcreditLineAmt + ", pastdueAmt="
				+ pastdueAmt + ", pastdueBy60Cnt=" + pastdueBy60Cnt
				+ ", pastdueM3By60Cnt=" + pastdueM3By60Cnt + ", loanBalance="
				+ loanBalance + ", loanPeriod=" + loanPeriod
				+ ", monthlyPayment=" + DataUtils.fromDouble(monthlyPayment) + ", creditBalance="
				+ creditBalance + ", overdraftBalance=" + overdraftBalance
				+ ", reportQueryDate=" + DateUtils.dateToStr(reportQueryDate) + ", loanProperty="
				+ loanProperty + ", afterCardNewRecordFlag="
				+ afterCardNewRecordFlag + ", afterLoanNewRecordFlag="
				+ afterLoanNewRecordFlag + ", afterLoanCardNoNewRecordFlag="
				+ afterLoanCardNoNewRecordFlag + "]";
	}

}
