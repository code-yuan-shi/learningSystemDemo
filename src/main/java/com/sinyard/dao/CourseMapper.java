package com.sinyard.dao;

import com.sinyard.entity.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface CourseMapper {
    int deleteByPrimaryKey(Integer courseid);

    int insert(Course record);

    Course selectByPrimaryKey(Integer courseid);

    List<Course> selectAll();

    int updateByPrimaryKey(Course record);
}