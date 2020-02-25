package com.tradelxapp.model;

public class CategoryClass {

	private Long id;
	private String name;



	public CategoryClass() {
	}

	public CategoryClass(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
