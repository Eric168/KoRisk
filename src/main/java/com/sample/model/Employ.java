package com.sample.model;

import java.util.List;

public class Employ {
    
	private String educationInfo;
	private String resume;
	private String awardPunish;
	private String bonus;
	private double basicSalary;
	private double dutySalary;
	private double bonusSalary;
	private double totalSalary;
	private double percent;
	private int kk=0;
	 
	private List<Worker> workerList;
	
	public String getEducationInfo() {
		return educationInfo;
	}
	public void setEducationInfo(String educationInfo) {
		this.educationInfo = educationInfo;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getAwardPunish() {
		return awardPunish;
	}
	public void setAwardPunish(String awardPunish) {
		this.awardPunish = awardPunish;
	}
	public double getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}
	public double getDutySalary() {
		return dutySalary;
	}
	public void setDutySalary(double dutySalary) {
		this.dutySalary = dutySalary;
	}
	public double getBonusSalary() {
		return bonusSalary;
	}
	public void setBonusSalary(double bonusSalary) {
		this.bonusSalary = bonusSalary;
	}
	public double getTotalSalary() {
		return totalSalary;
	}
	public void setTotalSalary(double totalSalary) {
		this.totalSalary = totalSalary;
	}
	public double getPercent() {
		return percent;
	}
	public void setPercent(double percent) {
		this.percent = percent;
	}
	public String getBonus() {
		return bonus;
	}
	public void setBonus(String bonus) {
		this.bonus = bonus;
	}
	public List<Worker> getWorkerList() {
		return workerList;
	}
	public void setWorkerList(List<Worker> workerList) {
		this.workerList = workerList;
	}
	public int getKk() {
		return kk;
	}
	public void setKk(int kk) {
		this.kk = kk;
	}
	
}
