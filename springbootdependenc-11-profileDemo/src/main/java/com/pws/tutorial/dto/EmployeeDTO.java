package com.pws.tutorial.dto;

import java.io.Serializable;

import lombok.Data;


public class EmployeeDTO implements Serializable {
	private Integer srNo;
	private Integer empNo;
	private String ename;
	private String job;
	private Double sal;
	private Integer deptNo;
	private Integer mngNo;
	public Integer getSrNo() {
		return srNo;
	}
	public void setSrNo(Integer srNo) {
		this.srNo = srNo;
	}
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	public Integer getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}
	public Integer getMngNo() {
		return mngNo;
	}
	public void setMngNo(Integer mngNo) {
		this.mngNo = mngNo;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [srNo=" + srNo + ", empNo=" + empNo + ", ename=" + ename + ", job=" + job + ", sal=" + sal
				+ ", deptNo=" + deptNo + ", mngNo=" + mngNo + "]";
	}
	
	
}
