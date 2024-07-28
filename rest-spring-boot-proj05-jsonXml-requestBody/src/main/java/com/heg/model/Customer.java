package com.heg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	private Integer cno;
	private String name;
	private String caddrs;
	private Float billAmount;
}
