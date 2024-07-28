package com.heg.model;



import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Table(name="security_users")
@Entity
@Data
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer uid;
	
	@Column(length = 20, unique = true, nullable = false)
	private String uname;
	
	@Column(length = 150,  nullable = false)
	private String pwd;
	
	@Column(length = 20, unique = true, nullable = false)
	private String email;
	
	
	private boolean status;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="security_roles", 
					joinColumns = @JoinColumn(name="user_id", referencedColumnName = "uid"))
	@Column(name="role")
	private Set<String> roles;
	

}
