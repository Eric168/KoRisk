package com.sample.model;

public class Worker {

	  private String job;
	  private String sex;
	  private int kk=0;
	  private int i=3;
	  private int j=4;
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int createW(){
		return i+j;
	}
	
}
