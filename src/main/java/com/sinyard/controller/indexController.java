package com.sinyard.controller;

import com.alibaba.fastjson.JSON;
import com.sinyard.entity.Course;
import com.sinyard.entity.CourseExample;
import com.sinyard.service.CourseService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.spring.web.json.Json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author sinyard
 * @date 2020-08-13 22:37
 * @desc
 */
@Controller
@Api(value = "indexController",description = "主页")
public class indexController {
    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/index")
    public String index(Model model){
        CourseExample example = new CourseExample();
        CourseExample.Criteria criteria = example.createCriteria();
        criteria.andLeveEqualTo(1);
        criteria.andPidEqualTo(0);
        List<Course> courseList = courseService.selectByExampleWithBLOBs(example);
        for (Course cl : courseList){
            CourseExample example2 = new CourseExample();
            CourseExample.Criteria criteria2 = example2.createCriteria();
            criteria2.andLeveEqualTo(2);
            criteria2.andPidEqualTo(cl.getCourseid());
            List<Course> next = courseService.selectByExampleWithBLOBs(example2);
            cl.setListCourse(next);
        }
        int course_id = courseList.get(0).getListCourse().get(0).getCourseid();
        CourseExample example3 = new CourseExample();
        CourseExample.Criteria criteria3 = example3.createCriteria();
        criteria3.andPidEqualTo(course_id);
        Course course = courseService.selectByExampleWithBLOBs(example3).get(0);
        model.addAttribute("courseList",courseList);
        model.addAttribute("course",course);
        return "index";
    }
    @RequestMapping(value = "/content-data")
    @ResponseBody
    public Course ontentData(Model model,int pid){
        CourseExample example = new CourseExample();
        CourseExample.Criteria criteria = example.createCriteria();
        criteria.andPidEqualTo(pid);
        Course course = courseService.selectByExampleWithBLOBs(example).get(0);
        return course;
    }
}
