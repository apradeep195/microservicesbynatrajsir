package com.pws.tutorial.bo;

public class EmployeeBO {

	private Integer empNo;
	private String ename;
	private String job;
	private Double sal;
	private Integer deptNo;
	private Integer mngNo;
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
		return "EmployeeBO [empNo=" + empNo + ", ename=" + ename + ", job=" + job + ", sal=" + sal + ", deptNo="
				+ deptNo + ", mngNo=" + mngNo + "]";
	}
	
	
	
}
