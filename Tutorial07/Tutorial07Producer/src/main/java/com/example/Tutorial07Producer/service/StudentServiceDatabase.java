package com.example.Tutorial07Producer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Tutorial07Producer.dao.StudentMapper;
import com.example.Tutorial07Producer.model.CourseModel;
import com.example.Tutorial07Producer.model.StudentModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentServiceDatabase implements StudentService
{
    @Autowired
    private StudentMapper studentMapper;


    @Override
    public StudentModel selectStudent (String npm)
    {
        log.info ("select student with npm {}", npm);
        return studentMapper.selectStudent (npm);
    }

    @Override
    public CourseModel selectCourse (String id)
    {
        log.info ("select course with id {}", id);
        return studentMapper.selectCourse (id);
    }


    @Override
    public List<StudentModel> selectAllStudents ()
    {
        log.info ("select all students");
        return studentMapper.selectAllStudents ();
    }


    @Override
    public void addStudent (StudentModel student)
    {
        studentMapper.addStudent (student);
    }


    @Override
    public void deleteStudent (String npm)
    {
    	log.info ("student "+npm+" deleted");
    	studentMapper.deleteStudent(npm);
    }
    
    @Override
    public void updateStudent(StudentModel student) {
    	log.info ("student "+student+" updated");
    	studentMapper.updateStudent(student);
    }
    
    @Override
    public List<CourseModel> selectAllCourses()
    {
        log.info ("select all Courses");
        return studentMapper.selectAllCourses ();
    }
    

}
