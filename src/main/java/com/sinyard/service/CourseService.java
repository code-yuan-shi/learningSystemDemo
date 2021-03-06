package com.sinyard.service;

import com.sinyard.entity.Course;
import com.sinyard.entity.CourseExample;

import java.util.List;

/**
 * @author sinyard
 * @date 2020-08-13 13:25
 * @desc
 */
public interface CourseService {
    List<Course> selectByExampleWithBLOBs(CourseExample example);
    Course selectByPrimaryKey(Integer courseid);
    int insertSelective(Course record);
    int deleteByPrimaryKey(Integer courseid);
    int deleteByExample(CourseExample example);
    int updateByPrimaryKeySelective(Course record);
}
