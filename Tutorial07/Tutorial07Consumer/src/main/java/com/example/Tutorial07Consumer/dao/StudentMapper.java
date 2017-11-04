package com.example.Tutorial07Consumer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.Tutorial07Consumer.model.CourseModel;
import com.example.Tutorial07Consumer.model.StudentModel;



@Mapper
public interface StudentMapper
{
    @Select("select npm, name, gpa from student where npm = #{npm}")
    @Results(value = {
    		@Result(property = "npm", column = "npm"),
    		@Result(property = "name", column = "name"),
    		@Result(property = "gpa", column = "gpa"),
    		@Result(property = "courses", column = "npm", javaType = List.class, many=@Many(select="selectCourses"))
    })
    StudentModel selectStudent (@Param("npm") String npm);

    @Select("select npm, name, gpa from student")
    @Results(value = {
    		@Result(property = "npm", column = "npm"),
    		@Result(property = "name", column = "name"),
    		@Result(property = "gpa", column = "gpa"),
    		@Result(property = "courses", column = "npm", javaType = List.class, many=@Many(select="selectCourses"))
    })
    List<StudentModel> selectAllStudents ();
    
    @Select("SELECT course.id_course, name, credits FROM studentcourse join course on studentcourse.id_course = course.id_course "
    		+ "WHERE studentcourse.npm = #{npm}")
    List<CourseModel> selectCourses (@Param("npm") String npm);

    @Insert("INSERT INTO student (npm, name, gpa) VALUES (#{npm}, #{name}, #{gpa})")
    void addStudent (StudentModel student);
    
    @Delete("DELETE FROM student WHERE npm = #{npm}")
    void deleteStudent (@Param("npm") String npm);
    
    @Update("UPDATE student SET npm = #{npm}, name = #{name}, gpa = #{gpa} WHERE npm = #{npm}")
    void updateStudent (StudentModel student);
    
    @Select("SELECT student.npm, name, gpa FROM studentcourse join student on studentcourse.npm = student.npm WHERE studentcourse.id_course = #{id}")
    List<StudentModel> selectStudentCourse (@Param("id") String id);
    
    @Select("select id_course, name, credits from course where id_course = #{id}")
    @Results(value = {
    		@Result(property = "idCourse", column = "id_course"),
    		@Result(property = "name", column = "name"),
    		@Result(property = "credits", column = "credits"),
    		@Result(property = "students", column = "id_course", javaType = List.class, many=@Many(select="selectStudentCourse"))
    })
    CourseModel selectCourse (@Param("id") String id);
    
}
