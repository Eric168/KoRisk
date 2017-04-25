package com.madai.model.approval.ProductRate;

public class ProductRateIn {
       
	   private String appId;
	   private String isLocal;//1代表是，0代表不是；
	   private double dsr;//DSR 负债率
	   private String isDivorce;//是否离异
	   private int age;//年龄
	   private String productCode;//产品	   
	   
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getIsLocal() {
		return isLocal;
	}
	public void setIsLocal(String isLocal) {
		this.isLocal = isLocal;
	}
	public double getDsr() {
		return dsr;
	}
	public void setDsr(double dsr) {
		this.dsr = dsr;
	}
	public String getIsDivorce() {
		return isDivorce;
	}
	public void setIsDivorce(String isDivorce) {
		this.isDivorce = isDivorce;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	@Override
	public String toString() {
		return "ProductRateIn [appId=" + appId + ", isLocal=" + isLocal
				+ ", dsr=" + dsr + ", isDivorce=" + isDivorce + ", age=" + age
				+ ", productCode=" + productCode + "]";
	}
	
}
