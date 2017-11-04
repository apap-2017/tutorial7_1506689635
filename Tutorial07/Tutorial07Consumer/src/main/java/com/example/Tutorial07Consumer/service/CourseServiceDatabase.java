package com.example.Tutorial07Consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Tutorial07Consumer.dao.StudentMapper;
import com.example.Tutorial07Consumer.model.CourseModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CourseServiceDatabase implements CourseService {
	@Autowired
    private StudentMapper studentMapper;
	
    @Override
    public CourseModel selectCourse (String id)
    {
        log.info ("select course with id {}", id);
        return studentMapper.selectCourse (id);
    }
}
