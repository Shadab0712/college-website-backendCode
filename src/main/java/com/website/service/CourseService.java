package com.website.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.dto.CourseDTO;
import com.website.model.Course;
import com.website.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private ModelMapper modelMapper;

	public void addCourse(CourseDTO courseDTO) {
		Course courseEntity = modelMapper.map(courseDTO, Course.class);
		courseRepository.save(courseEntity);
	}

	public List<CourseDTO> getAllCourses() {
		Iterable<Course> allCourses = courseRepository.findAll();
		List<CourseDTO> courseDTOs = new ArrayList<>();

		for (Course course : allCourses) {
			CourseDTO courseDTO = modelMapper.map(course, CourseDTO.class);
			courseDTOs.add(courseDTO);
		}

		return courseDTOs;
	}

}
