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
}
