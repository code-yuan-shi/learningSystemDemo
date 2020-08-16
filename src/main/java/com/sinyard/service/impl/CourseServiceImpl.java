package com.sinyard.service.impl;

import com.sinyard.dao.CourseMapper;
import com.sinyard.entity.Course;
import com.sinyard.entity.CourseExample;
import com.sinyard.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author sinyard
 * @date 2020-08-13 13:26
 * @desc
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> selectByExampleWithBLOBs(CourseExample example) {
        return courseMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public Course selectByPrimaryKey(Integer courseid) {
        return courseMapper.selectByPrimaryKey(courseid);
    }

    @Override
    public int insertSelective(Course record) {
        return courseMapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer courseid) {
        return courseMapper.deleteByPrimaryKey(courseid);
    }

    @Override
    public int deleteByExample(CourseExample example) {
        return courseMapper.deleteByExample(example);
    }

    @Override
    public int updateByPrimaryKeySelective(Course record) {
        return courseMapper.updateByPrimaryKeySelective(record);
    }
}
