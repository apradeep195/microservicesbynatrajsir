package com.heg.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name="OTM_PERSON")
public class Person implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pid;
	
	@Column(length = 20)
	private String pname;
	
	@Column(length = 100)
	private String paddrs;
	
	@OneToMany(targetEntity = PhoneNumber.class, cascade = CascadeType.ALL, mappedBy = "person",fetch = FetchType.EAGER)
	//@JoinColumn(name="PERSON_ID", referencedColumnName = "PID")
	private Set<PhoneNumber> contactDetails; //for one to many Association

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPaddrs() {
		return paddrs;
	}

	public void setPaddrs(String paddrs) {
		this.paddrs = paddrs;
	}

	public Set<PhoneNumber> getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(Set<PhoneNumber> contactDetails) {
		this.contactDetails = contactDetails;
	}

	public Person(Integer pid, String pname, String paddrs, Set<PhoneNumber> contactDetails) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.paddrs = paddrs;
		this.contactDetails = contactDetails;
	}

	public Person(String pname, String paddrs) {
		super();
		this.pname = pname;
		this.paddrs = paddrs;
	}

	public Person(String pname, String paddrs, Set<PhoneNumber> contactDetails) {
		super();
		this.pname = pname;
		this.paddrs = paddrs;
		this.contactDetails = contactDetails;
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
