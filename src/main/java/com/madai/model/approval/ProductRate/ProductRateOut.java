package com.madai.model.approval.ProductRate;

public class ProductRateOut {
	
	 private  String appId;
	 private  String productCode;//产品code
	 private  String returnCode;//返回码
     private  double rate;//费率
     private  String subProductCode;//产品小类code

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

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getSubProductCode() {
		return subProductCode;
	}

	public void setSubProductCode(String subProductCode) {
		this.subProductCode = subProductCode;
	}

	@Override
	public String toString() {
		return "ProductRateOut [appId=" + appId + ", productCode="
				+ productCode + ", returnCode=" + returnCode + ", rate=" + rate
				+ ", subProductCode=" + subProductCode + "]";
	}

}
