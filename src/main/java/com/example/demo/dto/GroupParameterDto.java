package com.example.demo.dto;

import java.io.Serializable;

public class GroupParameterDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	
	public GroupParameterDto() {
		super();
	}

	public GroupParameterDto(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "GroupParameterDto [id=" + id + ", name=" + name + "]";
	}
	


}
