package com.sinyard.controller;

import com.sinyard.entity.Course;
import com.sinyard.entity.CourseExample;
import com.sinyard.service.CourseService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


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
        if(Course.getCourseid()!=null){
            criteria.andCourseidEqualTo(Course.getCourseid());
        }
        if(Course.getCoursetitle()!=null){
            criteria.andCoursetitleLike("%"+Course.getCoursetitle()+"%");
        }
        List<Course> courseList = courseService.selectByExampleWithBLOBs(example);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "提示信息");
        result.put("count","15"); //条数 从数据库拿
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
    public int deleteById(int courseid,String action){
            return  courseService.deleteByPrimaryKey(courseid);
    }

    @RequestMapping(value = "/content-list")
    @ResponseBody
    public Map<String, Object> contentList(@RequestParam(defaultValue = "1")int courseid){
        Map<String, Object> result = new HashMap<String, Object>();
        List<Course> contentList = new ArrayList<Course>();
        CourseExample example = new CourseExample();
        CourseExample.Criteria criteria = example.createCriteria();
        criteria.andLeveEqualTo(2);
        criteria.andPidEqualTo(courseid);
        contentList = courseService.selectByExampleWithBLOBs(example);
        result.put("code", 0);
        result.put("msg", "提示信息");
        result.put("count","15"); //条数
        result.put("data", contentList);
        return result;
    }
    @RequestMapping(value = "/add-content")
    @ResponseBody
    public int addContent(Course course,int id){
        String content = course.getCoursecontent();
        course.setLeve(2);
        course.setPid(id);
        int status2 = courseService.insertSelective(course);
        return status2;
    }

    @RequestMapping(value = "/update-content")
    @ResponseBody
    public int updateContent(Course course){
        System.out.println(course);
        int status = courseService.updateByPrimaryKeySelective(course);
        return status;
    }
    @RequestMapping(value = "/one-content")
    @ResponseBody
    public Course oneContent(int courseid){
        Course course = courseService.selectByPrimaryKey(courseid);
        return course;
    }

    @RequestMapping(value = "/one-title")
    @ResponseBody
    public Course oneTitle(int courseid){
        Course course = courseService.selectByPrimaryKey(courseid);
        return course;
    }

    @RequestMapping(value = "/update-title")
    @ResponseBody
    public int updateTitle(Course course){
        System.out.println(course);
        int status1 = courseService.updateByPrimaryKeySelective(course);
        return status1;
    }

}
