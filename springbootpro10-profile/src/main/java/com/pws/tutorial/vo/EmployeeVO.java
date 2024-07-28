package com.pws.tutorial.vo;





public class EmployeeVO {
	private String srNo;
	private String empNo;
	private String ename;
	private String job;
	private String sal;
	private String deptNo;
	private String mngNo;
	public String getSrNo() {
		return srNo;
	}
	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
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
	public String getSal() {
		return sal;
	}
	public void setSal(String sal) {
		this.sal = sal;
	}
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	public String getMngNo() {
		return mngNo;
	}
	public void setMngNo(String mngNo) {
		this.mngNo = mngNo;
	}
	@Override
	public String toString() {
		return "EmployeeVO [srNo=" + srNo + ", empNo=" + empNo + ", ename=" + ename + ", job=" + job + ", sal=" + sal
				+ ", deptNo=" + deptNo + ", mngNo=" + mngNo + "]";
	}
	
	
	
}
