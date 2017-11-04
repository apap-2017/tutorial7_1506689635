package com.example.Tutorial07Producer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Tutorial07Producer.model.CourseModel;
import com.example.Tutorial07Producer.model.StudentModel;
import com.example.Tutorial07Producer.service.StudentService;



@Controller
public class StudentController
{
    @Autowired
    StudentService studentDAO;


    @RequestMapping("/")
    public String index ()
    {
        return "index";
    }


    @RequestMapping("/student/add")
    public String add ()
    {
        return "form-add";
    }


    @RequestMapping("/student/add/submit")
    public String addSubmit (
            @RequestParam(value = "npm", required = false) String npm,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "gpa", required = false) double gpa)
    {
        StudentModel student = new StudentModel (npm, name, gpa, null);
        studentDAO.addStudent (student);

        return "success-add";
    }


    @RequestMapping("/student/view")
    public String view (Model model,
            @RequestParam(value = "npm", required = false) String npm)
    {
        StudentModel student = studentDAO.selectStudent (npm);

        if (student != null) {
            model.addAttribute ("student", student);
            return "view";
        } else {
            model.addAttribute ("npm", npm);
            return "not-found";
        }
    }


    @RequestMapping("/student/view/{npm}")
    public String viewPath (Model model,
            @PathVariable(value = "npm") String npm)
    {
        StudentModel student = studentDAO.selectStudent (npm);

        if (student != null) {
            model.addAttribute ("student", student);
            return "view";
        } else {
            model.addAttribute ("npm", npm);
            return "not-found";
        }
    }
    
    @RequestMapping("/course/view/{id}")
    public String viewCourse (Model model,
            @PathVariable(value = "id") String id)
    {
        CourseModel course = studentDAO.selectCourse (id);
        
        if (course != null) {
            model.addAttribute ("course", course);
       
            return "view-course";
        } else {
            model.addAttribute ("id", id);
            return "not-found-course";
        }
    }


    @RequestMapping("/student/viewall")
    public String view (Model model)
    {
        List<StudentModel> students = studentDAO.selectAllStudents ();
        model.addAttribute ("students", students);

        return "viewall";
    }


    @RequestMapping("/student/delete/{npm}")
    public String delete (Model model, @PathVariable(value = "npm") String npm)
    {
    	StudentModel student = studentDAO.selectStudent (npm);

        if(student == null) {
        	model.addAttribute("npm", npm);
        	return "not-found";
        }
        else{
        	studentDAO.deleteStudent(npm);
        }
        return "delete";
    }
    
    
    @RequestMapping("/student/update/{npm}")
    public String update(@PathVariable(value = "npm") String npm, Model model) {
    	
    	StudentModel student = studentDAO.selectStudent (npm);

        if(student == null) {
        	model.addAttribute("npm", npm);
        	return "not-found";
        }
        model.addAttribute("student", student);
    	return "form-update";
    }
    
    /*@RequestMapping(value = "/student/update/submit", method = RequestMethod.POST)
    public String updateSubmit(@RequestParam(value = "npm", required = false)String npm,
    							@RequestParam(value = "name", required = false)String name,
    							@RequestParam(value = "gpa", required = false)double gpa){
    	
        studentDAO.updateStudent(npm, name, gpa);
        
    	return "success-update";
    }*/
   
    @RequestMapping(value ="/student/update/submit", method = RequestMethod.POST)
    public String updateSubmit (@ModelAttribute StudentModel student) {
        studentDAO.updateStudent(student);
        return "success-update";
    }

}