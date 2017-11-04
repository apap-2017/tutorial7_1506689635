package com.example.Tutorial07Consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.Tutorial07Consumer.dao.CourseDAO;
import com.example.Tutorial07Consumer.model.CourseModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Primary
public class CourseServiceRest implements CourseService 
{
	@Autowired
	private CourseDAO courseDAO;
	
	@Override
	public CourseModel selectCourse (String id) {
		log.info ("REST - select Course");
		return courseDAO.selectCourse(id);
	}
}
