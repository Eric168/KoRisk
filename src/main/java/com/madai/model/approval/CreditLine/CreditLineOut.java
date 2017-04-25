package com.madai.model.approval.CreditLine;

public class CreditLineOut {
       
	 private  String appId;
	 private  String productCode;//产品code
	 private  String returnCode;//返回码
     private  double times;//额度建议倍数
     private  double amount;//建议额度=income(收入)*times(额度建议倍数)
     
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
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	public double getTimes() {
		return times;
	}
	public void setTimes(double times) {
		this.times = times;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "CreditLineOut [appId=" + appId + ", productCode=" + productCode
				+ ", returnCode=" + returnCode + ", times=" + times
				+ ", amount=" + amount + "]";
	}
	
}
