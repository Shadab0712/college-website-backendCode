package com.website.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.dto.NewsDTO;
import com.website.model.News;
import com.website.repository.NewsRepository;

@Service
public class NewsService {

	@Autowired
	private NewsRepository newsRepository;

	@Autowired
	private ModelMapper modelMapper;

	public void updateNews(NewsDTO newsDTO) {
		News existingNews = newsRepository.findById(1L) // Assuming the ID is 1
				.orElseThrow(() -> new RuntimeException("News entry not found"));

		existingNews.setNews(newsDTO.getNews()); // Update fields as needed
		newsRepository.save(existingNews);
	}

	public NewsDTO getNews(Long id) {
		// Fetch the news item with id = 1
		Long fixedId = 1L;
		News news = newsRepository.findById(fixedId).orElseThrow(() -> new RuntimeException("News entry not found"));
		return modelMapper.map(news, NewsDTO.class);
	}
}
