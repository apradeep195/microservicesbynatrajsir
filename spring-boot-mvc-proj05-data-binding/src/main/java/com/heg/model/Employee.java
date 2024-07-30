package com.heg.model;


public class Employee {

	private int eno;
	private String ename;
	private String eadd;
	private float salary;
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEadd() {
		return eadd;
	}
	public void setEadd(String eadd) {
		this.eadd = eadd;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", eadd=" + eadd + ", salary=" + salary + "]";
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int eno, String ename, String eadd, float salary) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.eadd = eadd;
		this.salary = salary;
	}
	public Employee(String ename, String eadd, float salary) {
		super();
		this.ename = ename;
		this.eadd = eadd;
		this.salary = salary;
	}
	
	
}
