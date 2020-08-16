package com.sinyard.controller;

import com.sinyard.entity.Course;
import com.sinyard.entity.CourseExample;
import com.sinyard.service.CourseService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sinyard
 * @date 2020-08-13 22:37
 * @desc
 */
@Controller
@Api(value = "CourseController",description = "主页")
@RequestMapping(value = "/course",method = {RequestMethod.POST,RequestMethod.GET})
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/title")
    @ResponseBody
    public Map<String, Object> title(Course Course){
        CourseExample example = new CourseExample();
        CourseExample.Criteria criteria = example.createCriteria();
        criteria.andLeveEqualTo(1);
        criteria.andPidEqualTo(0);
        List<Course> courseList = courseService.selectByExampleWithBLOBs(example);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "提示信息");
        result.put("count","15"); //条数
        result.put("data", courseList);
        return result;
    }

    @RequestMapping(value = "/add-title")
    @ResponseBody
    public int addTitle(Course course){
        course.setLeve(1);
        course.setPid(0);
        return courseService.insertSelective(course);
    }
    @RequestMapping(value = "/deleteById")
    @ResponseBody
    public int deleteById(int courseid){
        return courseService.deleteByPrimaryKey(courseid);
    }
}
