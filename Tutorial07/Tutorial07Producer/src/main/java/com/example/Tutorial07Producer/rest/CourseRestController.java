package com.example.Tutorial07Producer.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Tutorial07Producer.model.CourseModel;
import com.example.Tutorial07Producer.service.StudentService;

@RestController
@RequestMapping("/rest")
public class CourseRestController 
{
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/course/view/{id}")
	public CourseModel view (@PathVariable(value = "id") String id) {
	CourseModel course = studentService.selectCourse(id);
	return course;
	}
	
	@RequestMapping("/course/viewall")
	public List<CourseModel> viewall () {
	List<CourseModel> courseList = studentService.selectAllCourses();
	return courseList;
	}
}
