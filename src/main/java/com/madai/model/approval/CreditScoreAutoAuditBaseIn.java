package com.madai.model.approval;

import java.math.BigDecimal;

public class CreditScoreAutoAuditBaseIn {
           
	private String appId;//申请编号
	private int age;//年龄
	private String gender;//性别
	private String degree;//最高学历
	private String maritalStatus;//婚姻状况
	private String censusFlag;//是否本地户籍    根据户籍地址与进件城市进行判断。本地请给“1”，外地请给“0”
	private String nativeFlag;//是否本地籍贯   根据身份证号前4位或前6位与进件城市进行判断。本地请给“1”，外地请给“0”
	private int residentalYear;//本地居住年限
	private String houseType;//住房性质
	private int housePurchaseYear;//房产已购买年限
	private int houseNumber;//房产套数
	private String companyType;//单位性质
	private int currentWorkMonth;//现单位工作月份数  现单位入职时间与申请时间的月份之差。如2016年2月份入职，申请时间为2016年3月份，则该值为1
	private int workYear;//工作年限
	private String region;//借贷人所在城市地域    东地区，华南地区等
	private String branchCode;//门店的code
	
	private String cityCategory;//借贷人所在城市的级别   一线，二线，三线
	private int cardOrgCNT;//贷记卡张数
	private int cardForeignOrgCNT;//外币账户贷记卡张数
	private int cardUncancelOrgCNT;//未销户贷记卡张数
	private int cardFirstOpenMonth;//首张贷记开户距今月份数  首张贷记卡开户日期与申请日期的月份之差。如首张贷记卡2016年2月份开户，申请日期为2016年3月份，则该值为1
	private int cardOpen06MONTHOrgCNT;//近6个月新开贷记卡张数  开户时间距离申请时间在180天内（含）的贷记卡发卡机构数量
	private BigDecimal cardMaxCreditLineAmtSum=new BigDecimal(0);//贷记卡最大授信额度之和  每家发卡机构取最大信用额度进行累加
	private BigDecimal cardMaxCreditLineAmt=new BigDecimal(0);//贷记卡最大授信额度
	private BigDecimal cardAvgCreditLineAmt=new BigDecimal(0);//贷记卡平均授信额度
	private BigDecimal cardCreditUsedLineTotal=new BigDecimal(0);//贷记卡使用总额度
	private BigDecimal cardCreditUsedPercent=new BigDecimal(0);//贷记卡额度使用率
	private int loanAccountCNT;//贷款总账户数
	private int loanUnclearedAccountCNT;//未结清贷款账户数
	private int loanFirstOpenMonth;//首笔贷款发放距今月份数 首笔贷款发放日期与申请日期的月份之差。
	private BigDecimal loanMaxCreditLineAmt=new BigDecimal(0);//单笔最大贷款授信额度
	private BigDecimal loanBalanceSum=new BigDecimal(0);//贷款总余额
	private BigDecimal loanUnclearedCreditLineAmtSum=new BigDecimal(0);//未结清贷款授信额度总和
	private BigDecimal loanBalancePercent=new BigDecimal(0);//贷款余额占授信总额的比例
	private int selfQuery01MonthFrequency;//最近1个月内查询次数-本人查询
	private int orgQuery01MonthFrequency;//最近1个月内查询次数-机构查询	
	private int selfQuery03MonthFrequencyRaw;//最近3个月内原始查询次数-本人查询
	private int orgQuery03MonthFrequency;//最近3个月内查询次数-机构查询
	private int selfQuery06MonthFrequency;//最近6个月内查询次数-本人查询
	private int orgQuery06MonthFrequency;//最近6个月内查询次数-机构查询
	private int selfQuery12MonthFrequency;//最近12个月内查询次数-本人查询
	private int orgQuery12MonthFrequency;//最近12个月内查询次数-机构查询
	private int selfQuery24MonthFrequency;//最近24个月内查询次数-本人查询
	private int orgQuery24MonthFrequency;//最近24个月内查询次数-机构查询
	private int loanApply24MonthFrequency;//最近24个月内查询次数-贷款审批
	private int cardApply06MonthFrequency;//最近6个月内查询次数-信用卡审批
	private int cardReject06MonthFrequency;//近6个月信用卡申请被拒次数
	private int cardApply24MonthFrequency;//最近24个月内查询次数-信用卡审批
	private int cardOpen24MonthOrgCNT;//近24个月新开贷记卡张数
	private int cardReject24MonthFrequency;//近24个月信用卡申请被拒次数
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getCensusFlag() {
		return censusFlag;
	}
	public void setCensusFlag(String censusFlag) {
		this.censusFlag = censusFlag;
	}
	public String getNativeFlag() {
		return nativeFlag;
	}
	public void setNativeFlag(String nativeFlag) {
		this.nativeFlag = nativeFlag;
	}
	public int getResidentalYear() {
		return residentalYear;
	}
	public void setResidentalYear(int residentalYear) {
		this.residentalYear = residentalYear;
	}
	public String getHouseType() {
		return houseType;
	}
	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}
	public int getHousePurchaseYear() {
		return housePurchaseYear;
	}
	public void setHousePurchaseYear(int housePurchaseYear) {
		this.housePurchaseYear = housePurchaseYear;
	}
	public int getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getCompanyType() {
		return companyType;
	}
	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}
	public int getCurrentWorkMonth() {
		return currentWorkMonth;
	}
	public void setCurrentWorkMonth(int currentWorkMonth) {
		this.currentWorkMonth = currentWorkMonth;
	}
	public int getWorkYear() {
		return workYear;
	}
	public void setWorkYear(int workYear) {
		this.workYear = workYear;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCityCategory() {
		return cityCategory;
	}
	public void setCityCategory(String cityCategory) {
		this.cityCategory = cityCategory;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public int getCardOrgCNT() {
		return cardOrgCNT;
	}
	public void setCardOrgCNT(int cardOrgCNT) {
		this.cardOrgCNT = cardOrgCNT;
	}
	public int getCardForeignOrgCNT() {
		return cardForeignOrgCNT;
	}
	public void setCardForeignOrgCNT(int cardForeignOrgCNT) {
		this.cardForeignOrgCNT = cardForeignOrgCNT;
	}
	public int getCardUncancelOrgCNT() {
		return cardUncancelOrgCNT;
	}
	public void setCardUncancelOrgCNT(int cardUncancelOrgCNT) {
		this.cardUncancelOrgCNT = cardUncancelOrgCNT;
	}
	public int getCardFirstOpenMonth() {
		return cardFirstOpenMonth;
	}
	public void setCardFirstOpenMonth(int cardFirstOpenMonth) {
		this.cardFirstOpenMonth = cardFirstOpenMonth;
	}
	public int getCardOpen06MONTHOrgCNT() {
		return cardOpen06MONTHOrgCNT;
	}
	public void setCardOpen06MONTHOrgCNT(int cardOpen06MONTHOrgCNT) {
		this.cardOpen06MONTHOrgCNT = cardOpen06MONTHOrgCNT;
	}
	public BigDecimal getCardMaxCreditLineAmtSum() {
		return cardMaxCreditLineAmtSum;
	}
	public void setCardMaxCreditLineAmtSum(BigDecimal cardMaxCreditLineAmtSum) {
		this.cardMaxCreditLineAmtSum = cardMaxCreditLineAmtSum;
	}
	public BigDecimal getCardMaxCreditLineAmt() {
		return cardMaxCreditLineAmt;
	}
	public void setCardMaxCreditLineAmt(BigDecimal cardMaxCreditLineAmt) {
		this.cardMaxCreditLineAmt = cardMaxCreditLineAmt;
	}
	public BigDecimal getCardAvgCreditLineAmt() {
		return cardAvgCreditLineAmt;
	}
	public void setCardAvgCreditLineAmt(BigDecimal cardAvgCreditLineAmt) {
		this.cardAvgCreditLineAmt = cardAvgCreditLineAmt;
	}
	public BigDecimal getCardCreditUsedLineTotal() {
		return cardCreditUsedLineTotal;
	}
	public void setCardCreditUsedLineTotal(BigDecimal cardCreditUsedLineTotal) {
		this.cardCreditUsedLineTotal = cardCreditUsedLineTotal;
	}
	public BigDecimal getCardCreditUsedPercent() {
		return cardCreditUsedPercent;
	}
	public void setCardCreditUsedPercent(BigDecimal cardCreditUsedPercent) {
		this.cardCreditUsedPercent = cardCreditUsedPercent;
	}
	public int getLoanAccountCNT() {
		return loanAccountCNT;
	}
	public void setLoanAccountCNT(int loanAccountCNT) {
		this.loanAccountCNT = loanAccountCNT;
	}
	public int getLoanUnclearedAccountCNT() {
		return loanUnclearedAccountCNT;
	}
	public void setLoanUnclearedAccountCNT(int loanUnclearedAccountCNT) {
		this.loanUnclearedAccountCNT = loanUnclearedAccountCNT;
	}
	public int getLoanFirstOpenMonth() {
		return loanFirstOpenMonth;
	}
	public void setLoanFirstOpenMonth(int loanFirstOpenMonth) {
		this.loanFirstOpenMonth = loanFirstOpenMonth;
	}
	public BigDecimal getLoanMaxCreditLineAmt() {
		return loanMaxCreditLineAmt;
	}
	public void setLoanMaxCreditLineAmt(BigDecimal loanMaxCreditLineAmt) {
		this.loanMaxCreditLineAmt = loanMaxCreditLineAmt;
	}
	public BigDecimal getLoanBalanceSum() {
		return loanBalanceSum;
	}
	public void setLoanBalanceSum(BigDecimal loanBalanceSum) {
		this.loanBalanceSum = loanBalanceSum;
	}
	public BigDecimal getLoanUnclearedCreditLineAmtSum() {
		return loanUnclearedCreditLineAmtSum;
	}
	public void setLoanUnclearedCreditLineAmtSum(
			BigDecimal loanUnclearedCreditLineAmtSum) {
		this.loanUnclearedCreditLineAmtSum = loanUnclearedCreditLineAmtSum;
	}
	public BigDecimal getLoanBalancePercent() {
		return loanBalancePercent;
	}
	public void setLoanBalancePercent(BigDecimal loanBalancePercent) {
		this.loanBalancePercent = loanBalancePercent;
	}
	public int getSelfQuery01MonthFrequency() {
		return selfQuery01MonthFrequency;
	}
	public void setSelfQuery01MonthFrequency(int selfQuery01MonthFrequency) {
		this.selfQuery01MonthFrequency = selfQuery01MonthFrequency;
	}
	public int getOrgQuery01MonthFrequency() {
		return orgQuery01MonthFrequency;
	}
	public void setOrgQuery01MonthFrequency(int orgQuery01MonthFrequency) {
		this.orgQuery01MonthFrequency = orgQuery01MonthFrequency;
	}
	public int getSelfQuery03MonthFrequencyRaw() {
		return selfQuery03MonthFrequencyRaw;
	}
	public void setSelfQuery03MonthFrequencyRaw(int selfQuery03MonthFrequencyRaw) {
		this.selfQuery03MonthFrequencyRaw = selfQuery03MonthFrequencyRaw;
	}
	public int getOrgQuery03MonthFrequency() {
		return orgQuery03MonthFrequency;
	}
	public void setOrgQuery03MonthFrequency(int orgQuery03MonthFrequency) {
		this.orgQuery03MonthFrequency = orgQuery03MonthFrequency;
	}
	public int getSelfQuery06MonthFrequency() {
		return selfQuery06MonthFrequency;
	}
	public void setSelfQuery06MonthFrequency(int selfQuery06MonthFrequency) {
		this.selfQuery06MonthFrequency = selfQuery06MonthFrequency;
	}
	public int getOrgQuery06MonthFrequency() {
		return orgQuery06MonthFrequency;
	}
	public void setOrgQuery06MonthFrequency(int orgQuery06MonthFrequency) {
		this.orgQuery06MonthFrequency = orgQuery06MonthFrequency;
	}
	public int getSelfQuery12MonthFrequency() {
		return selfQuery12MonthFrequency;
	}
	public void setSelfQuery12MonthFrequency(int selfQuery12MonthFrequency) {
		this.selfQuery12MonthFrequency = selfQuery12MonthFrequency;
	}
	public int getOrgQuery12MonthFrequency() {
		return orgQuery12MonthFrequency;
	}
	public void setOrgQuery12MonthFrequency(int orgQuery12MonthFrequency) {
		this.orgQuery12MonthFrequency = orgQuery12MonthFrequency;
	}
	public int getSelfQuery24MonthFrequency() {
		return selfQuery24MonthFrequency;
	}
	public void setSelfQuery24MonthFrequency(int selfQuery24MonthFrequency) {
		this.selfQuery24MonthFrequency = selfQuery24MonthFrequency;
	}
	public int getOrgQuery24MonthFrequency() {
		return orgQuery24MonthFrequency;
	}
	public void setOrgQuery24MonthFrequency(int orgQuery24MonthFrequency) {
		this.orgQuery24MonthFrequency = orgQuery24MonthFrequency;
	}
	public int getLoanApply24MonthFrequency() {
		return loanApply24MonthFrequency;
	}
	public void setLoanApply24MonthFrequency(int loanApply24MonthFrequency) {
		this.loanApply24MonthFrequency = loanApply24MonthFrequency;
	}
	public int getCardApply06MonthFrequency() {
		return cardApply06MonthFrequency;
	}
	public void setCardApply06MonthFrequency(int cardApply06MonthFrequency) {
		this.cardApply06MonthFrequency = cardApply06MonthFrequency;
	}
	public int getCardReject06MonthFrequency() {
		return cardReject06MonthFrequency;
	}
	public void setCardReject06MonthFrequency(int cardReject06MonthFrequency) {
		this.cardReject06MonthFrequency = cardReject06MonthFrequency;
	}
	public int getCardApply24MonthFrequency() {
		return cardApply24MonthFrequency;
	}
	public void setCardApply24MonthFrequency(int cardApply24MonthFrequency) {
		this.cardApply24MonthFrequency = cardApply24MonthFrequency;
	}
	public int getCardOpen24MonthOrgCNT() {
		return cardOpen24MonthOrgCNT;
	}
	public void setCardOpen24MonthOrgCNT(int cardOpen24MonthOrgCNT) {
		this.cardOpen24MonthOrgCNT = cardOpen24MonthOrgCNT;
	}
	public int getCardReject24MonthFrequency() {
		return cardReject24MonthFrequency;
	}
	public void setCardReject24MonthFrequency(int cardReject24MonthFrequency) {
		this.cardReject24MonthFrequency = cardReject24MonthFrequency;
	}
	@Override
	public String toString() {
		return "CreditScoreAutoAuditBaseIn [appId=" + appId + ", age=" + age
				+ ", gender=" + gender + ", degree=" + degree
				+ ", maritalStatus=" + maritalStatus + ", censusFlag="
				+ censusFlag + ", nativeFlag=" + nativeFlag
				+ ", residentalYear=" + residentalYear + ", houseType="
				+ houseType + ", housePurchaseYear=" + housePurchaseYear
				+ ", houseNumber=" + houseNumber + ", companyType="
				+ companyType + ", currentWorkMonth=" + currentWorkMonth
				+ ", workYear=" + workYear + ", region=" + region
				+ ", branchCode=" + branchCode + ", cityCategory="
				+ cityCategory + ", cardOrgCNT=" + cardOrgCNT
				+ ", cardForeignOrgCNT=" + cardForeignOrgCNT
				+ ", cardUncancelOrgCNT=" + cardUncancelOrgCNT
				+ ", cardFirstOpenMonth=" + cardFirstOpenMonth
				+ ", cardOpen06MONTHOrgCNT=" + cardOpen06MONTHOrgCNT
				+ ", cardMaxCreditLineAmtSum=" + cardMaxCreditLineAmtSum
				+ ", cardMaxCreditLineAmt=" + cardMaxCreditLineAmt
				+ ", cardAvgCreditLineAmt=" + cardAvgCreditLineAmt
				+ ", cardCreditUsedLineTotal=" + cardCreditUsedLineTotal
				+ ", cardCreditUsedPercent=" + cardCreditUsedPercent
				+ ", loanAccountCNT=" + loanAccountCNT
				+ ", loanUnclearedAccountCNT=" + loanUnclearedAccountCNT
				+ ", loanFirstOpenMonth=" + loanFirstOpenMonth
				+ ", loanMaxCreditLineAmt=" + loanMaxCreditLineAmt
				+ ", loanBalanceSum=" + loanBalanceSum
				+ ", loanUnclearedCreditLineAmtSum="
				+ loanUnclearedCreditLineAmtSum + ", loanBalancePercent="
				+ loanBalancePercent + ", selfQuery01MonthFrequency="
				+ selfQuery01MonthFrequency + ", orgQuery01MonthFrequency="
				+ orgQuery01MonthFrequency + ", selfQuery03MonthFrequencyRaw="
				+ selfQuery03MonthFrequencyRaw + ", orgQuery03MonthFrequency="
				+ orgQuery03MonthFrequency + ", selfQuery06MonthFrequency="
				+ selfQuery06MonthFrequency + ", orgQuery06MonthFrequency="
				+ orgQuery06MonthFrequency + ", selfQuery12MonthFrequency="
				+ selfQuery12MonthFrequency + ", orgQuery12MonthFrequency="
				+ orgQuery12MonthFrequency + ", selfQuery24MonthFrequency="
				+ selfQuery24MonthFrequency + ", orgQuery24MonthFrequency="
				+ orgQuery24MonthFrequency + ", loanApply24MonthFrequency="
				+ loanApply24MonthFrequency + ", cardApply06MonthFrequency="
				+ cardApply06MonthFrequency + ", cardReject06MonthFrequency="
				+ cardReject06MonthFrequency + ", cardApply24MonthFrequency="
				+ cardApply24MonthFrequency + ", cardOpen24MonthOrgCNT="
				+ cardOpen24MonthOrgCNT + ", cardReject24MonthFrequency="
				+ cardReject24MonthFrequency + "]";
	}
		
}
