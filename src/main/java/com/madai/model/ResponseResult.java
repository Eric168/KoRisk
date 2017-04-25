package com.madai.model;

import java.math.BigDecimal;

public class ResponseResult {
    
	private String status;
	private String type;//1-->拒绝  2-->警告   3-->展示提醒   4-->评分  5--> 最大额度   6-->建议拒绝
	private String returnCode;//规则系统中的返回码
	private String refuseCode;//规则拒绝码
	private String level;
	private String id;
	private BigDecimal score;
	private BigDecimal maxAmount;//最大额度
	private String remark;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public BigDecimal getScore() {
		return score;
	}
	public void setScore(BigDecimal score) {
		this.score = score;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRefuseCode() {
		return refuseCode;
	}
	public void setRefuseCode(String refuseCode) {
		this.refuseCode = refuseCode;
	}
	public BigDecimal getMaxAmount() {
		return maxAmount;
	}
	public void setMaxAmount(BigDecimal maxAmount) {
		this.maxAmount = maxAmount;
	}
	@Override
	public String toString() {
		return "ResponseResult [status=" + status + ", type=" + type
				+ ", returnCode=" + returnCode + ", refuseCode=" + refuseCode
				+ ", level=" + level + ", id=" + id + ", score=" + score
				+ ", maxAmount=" + maxAmount + ", remark=" + remark + "]";
	}
	
}
