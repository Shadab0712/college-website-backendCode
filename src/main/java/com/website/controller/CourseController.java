package com.website.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.website.dto.CourseDTO;
import com.website.service.CourseService;

@RestController()
@RequestMapping("/api/v1/course")
@CrossOrigin("http://localhost:3001")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@PostMapping("/save")
	public ResponseEntity<String> addCourse(@RequestBody CourseDTO courseDTO) {
		courseService.addCourse(courseDTO);
		return new ResponseEntity<>("Course added successfully", HttpStatus.CREATED);
	}

	@GetMapping("/getAllCourses")
	public ResponseEntity<List<CourseDTO>> getAllCourses() {
		List<CourseDTO> allCourses = courseService.getAllCourses();
		return new ResponseEntity<>(allCourses, HttpStatus.OK);
	}
	
}
