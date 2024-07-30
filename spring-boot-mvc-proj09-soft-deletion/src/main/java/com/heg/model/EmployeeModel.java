package com.heg.model;





import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="emp_detail")
@SQLDelete(sql = "UPDATE emp_detail SET STATUS='deleted' WHERE EMPNo=?")
@Where(clause = "STATUS NOT IN ('deleted')")
public class EmployeeModel {

	@Id	
	@Column(name="empno")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long eno;	
	private String  name;
	private Integer   dept ;
	private String   unit ;
	private String   designation ;
	private Float sal;
	private String   status="Active";
}
