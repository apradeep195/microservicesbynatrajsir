package com.heg.model;

import org.springframework.stereotype.Component;


@Component("company")

public class Company {
	
	private String title;
	private String location;
	private int size;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "Company [title=" + title + ", location=" + location + ", size=" + size + "]";
	}
	
	

}
