package com.example.Tutorial07Consumer.service;

import java.util.List;

import com.example.Tutorial07Consumer.model.StudentModel;

public interface StudentService
{
    StudentModel selectStudent (String npm);
    
    List<StudentModel> selectAllStudents (); 
    
    void addStudent (StudentModel student);

    void deleteStudent (String npm);
    
    void updateStudent (StudentModel student);
    
    
}
