package com.sinyard.controller;

import com.sinyard.entity.Course;
import com.sinyard.entity.CourseExample;
import com.sinyard.service.CourseService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
        HashMap<String, Object> mun = new HashMap<String, Object>();
        CourseExample example = new CourseExample();
        CourseExample.Criteria criteria = example.createCriteria();
        criteria.andLeveEqualTo(1);
        criteria.andPidEqualTo(0);
        List<Course> courseList = courseService.selectByExampleWithBLOBs(example);
        for (Course cl : courseList){
            CourseExample example2 = new CourseExample();
            CourseExample.Criteria criteria2 = example.createCriteria();
            criteria2.andLeveEqualTo(2);
            criteria2.andPidEqualTo(cl.getCourseid());
            List<Course> next = courseService.selectByExampleWithBLOBs(example2);
            cl.setListCourse(next);
        }
        System.out.println(courseList);
        model.addAttribute("courseList",courseList);
        return "index";
    }
}
