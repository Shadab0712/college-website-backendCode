package com.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.website.dto.NewsDTO;
import com.website.exception.ErrorResponseDTO;
import com.website.service.NewsService;

@RestController
@RequestMapping("/api/v1/news")
@CrossOrigin
public class NewsController {

	@Autowired
	private NewsService newsService;

	@PutMapping("/update")
	public ResponseEntity<String> updateNews(@RequestBody NewsDTO newsDTO) {
		try {
			newsService.updateNews(newsDTO);
			return ResponseEntity.ok("News updated successfully");
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("News entry not found");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getNews(@PathVariable Long id) {
		try {
			// Fetch the news item with id = 1 regardless of the requested id
			Long fixedId = 1L;
			NewsDTO news = newsService.getNews(fixedId);
			return ResponseEntity.ok(news);
		} catch (RuntimeException e) {
			ErrorResponseDTO errorResponse = new ErrorResponseDTO("News entry not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
		} catch (Exception e) {
			ErrorResponseDTO errorResponse = new ErrorResponseDTO("An error occurred");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
		}
	}
}
