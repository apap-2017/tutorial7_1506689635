package com.example.Tutorial07Producer.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class StudentModel
{
    private String npm;
    private String name;
    private Double gpa;
    private List<CourseModel> courses;

}
