package com.website.dto;

import java.io.Serializable;

public class CourseDTO implements Serializable {

	private static final long serialVersionUID = 715605377604669631L;

	private String title;
	private String description;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}