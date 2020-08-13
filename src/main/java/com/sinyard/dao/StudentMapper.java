package com.sinyard.dao;

import com.sinyard.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer studentid);

    int insert(Student record);

    Student selectByPrimaryKey(Integer studentid);

    List<Student> selectAll();

    int updateByPrimaryKey(Student record);
}