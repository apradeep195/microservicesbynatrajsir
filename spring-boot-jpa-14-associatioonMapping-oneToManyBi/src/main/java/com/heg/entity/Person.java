package com.heg.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity

public class Person implements Serializable {

	private Integer pId;
	private String pname;
	private String paddrs;
	private Set<PhoneNumber> contactDetails;
}
