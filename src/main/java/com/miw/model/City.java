package com.miw.model;

import javax.validation.constraints.NotEmpty;

public class City {
	
	@NotEmpty
	private int id;
	@NotEmpty
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
