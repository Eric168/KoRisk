package com.madai.model.approval.CreditLine;

public class CreditLineIn {
       
	   private String appId;
	   private String productCode;//产品大类code
	   private String isLocal;//是否本地户口         1代表是  0代表不是
	   private String isFemale;//是否女性              1代表是  0代表不是
	   private String isHasHouse;//是否有房           1代表是  0代表不是
	   private int age;//年龄
	   private int    lastMonthCreditQueryTimes;//客户最近1个月征信查询次数
	   private double dsr;//DSR 负债率
	   private double salary;//代发工资
	   private double income;//收入
	   private double base;//基数，目前针对于E社通的产品
	   private String middleCode;//中间码，无需传入变量
	   
	   
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getIsLocal() {
		return isLocal;
	}
	public void setIsLocal(String isLocal) {
		this.isLocal = isLocal;
	}
	public String getIsFemale() {
		return isFemale;
	}
	public void setIsFemale(String isFemale) {
		this.isFemale = isFemale;
	}
	public String getIsHasHouse() {
		return isHasHouse;
	}
	public void setIsHasHouse(String isHasHouse) {
		this.isHasHouse = isHasHouse;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getLastMonthCreditQueryTimes() {
		return lastMonthCreditQueryTimes;
	}
	public void setLastMonthCreditQueryTimes(int lastMonthCreditQueryTimes) {
		this.lastMonthCreditQueryTimes = lastMonthCreditQueryTimes;
	}
	public double getDsr() {
		return dsr;
	}
	public void setDsr(double dsr) {
		this.dsr = dsr;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		this.base = base;
	}
	public String getMiddleCode() {
		return middleCode;
	}
	public void setMiddleCode(String middleCode) {
		this.middleCode = middleCode;
	}
	@Override
	public String toString() {
		return "CreditLineIn [appId=" + appId + ", productCode=" + productCode
				+ ", isLocal=" + isLocal + ", isFemale=" + isFemale
				+ ", isHasHouse=" + isHasHouse + ", age=" + age
				+ ", lastMonthCreditQueryTimes=" + lastMonthCreditQueryTimes
				+ ", dsr=" + dsr + ", salary=" + salary + ", income=" + income
				+ ", base=" + base + ", middleCode=" + middleCode + "]";
	}
	
} 
