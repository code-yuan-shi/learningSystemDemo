package com.sinyard.dao;

import com.sinyard.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  //加上这个注解防止service报错
public interface StudentMapper {
    int deleteByPrimaryKey(Integer studentid);

    int insert(Student record);

    Student selectByPrimaryKey(Integer studentid);

    List<Student> selectAll();

    List<Student> selectLike(Student record);

    Integer countStudent();

    int updateByPrimaryKey(Student record);

    Student selectStudentByIdAndPass(Integer studentid, String studentpassword);
}