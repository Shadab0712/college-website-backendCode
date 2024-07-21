package com.website.dto;

import java.io.Serializable;

public class NewsDTO implements Serializable {

	private static final long serialVersionUID = 412724913983203134L;

	private String news;

	public String getNews() {
		return news;
	}

	public void setNews(String news) {
		this.news = news;
	}

}
