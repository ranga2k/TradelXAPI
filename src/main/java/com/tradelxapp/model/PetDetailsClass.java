package com.tradelxapp.model;

import java.util.ArrayList;

public class PetDetailsClass {

	private Long id;
	CategoryClass category;
	ArrayList<TagsClass> tags;
	private String name;
	String[] photoUrls ;
	private String status;


	
	public PetDetailsClass(CategoryClass category, ArrayList<TagsClass> tags, String name, String[] photoUrls,
			String status) {
		this.category = category;
		this.tags = tags;
		this.name = name;
		this.photoUrls = photoUrls;
		this.status = status;
	}
	
	public PetDetailsClass(String name, Long petId,String status) {
		this.name = name;
		this.id=petId;
		this.status = status;
	} 

	public PetDetailsClass() {
	}

	public String[] getPhotoUrls() {
		return photoUrls;
	}

	public ArrayList<TagsClass> getTags() {
		return tags;
	}

	public void setTags(ArrayList<TagsClass> tags) {
		this.tags = tags;
	}

	public void setPhotoUrls(String[] photoUrls) {
		this.photoUrls = photoUrls;
	}

	public Long getId() {
		return id;
	}

	public CategoryClass getCategory() {
		return category;
	}

	public String getName() {
		return name;
	}

	public String getStatus() {
		return status;
	}

	// Setter Methods

	public void setId(Long id) {
		this.id = id;
	}

	public void setCategory(CategoryClass category) {
		this.category = category;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
