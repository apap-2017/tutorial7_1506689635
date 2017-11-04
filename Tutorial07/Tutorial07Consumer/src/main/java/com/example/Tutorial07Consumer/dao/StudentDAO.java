package com.example.Tutorial07Consumer.dao;

import java.util.List;

import com.example.Tutorial07Consumer.model.StudentModel;

public interface StudentDAO {
	StudentModel selectStudent (String npm);
	
	List<StudentModel> selectAllStudents ();

}
