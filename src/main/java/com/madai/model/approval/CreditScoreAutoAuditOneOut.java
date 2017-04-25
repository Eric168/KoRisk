package com.madai.model.approval;


public class CreditScoreAutoAuditOneOut {

	private String appId;//申请编号
	private double score;//评分
	private String groupLevel;//分群
	private String riskLevel;//风险等级
	private String modelVersion;//评分模型版本
	private String remark;//备注信息
	
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
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
	public String getModelVersion() {
		return modelVersion;
	}
	public void setModelVersion(String modelVersion) {
		this.modelVersion = modelVersion;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "CreditScoreAutoAuditOneOut [appId=" + appId + ", score="
				+ score + ", groupLevel=" + groupLevel + ", riskLevel="
				+ riskLevel + ", modelVersion=" + modelVersion + ", remark="
				+ remark + "]";
	}
	
}
