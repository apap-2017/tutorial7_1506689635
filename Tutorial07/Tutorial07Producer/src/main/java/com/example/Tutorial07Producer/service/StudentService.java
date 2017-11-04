package com.example.Tutorial07Producer.service;

import java.util.List;

import com.example.Tutorial07Producer.model.CourseModel;
import com.example.Tutorial07Producer.model.StudentModel;



public interface StudentService
{
    StudentModel selectStudent (String npm);
    
    List<StudentModel> selectAllStudents (); 
    
    void addStudent (StudentModel student);

    void deleteStudent (String npm);
    
    void updateStudent (StudentModel student);
    
    CourseModel selectCourse (String id);
    
    List<CourseModel> selectAllCourses();
}
