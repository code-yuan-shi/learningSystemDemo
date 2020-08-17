package com.sinyard.controller;

import com.sinyard.dao.StudentMapper;
import com.sinyard.entity.Course;
import com.sinyard.entity.CourseExample;
import com.sinyard.entity.Student;
import com.sinyard.service.CourseService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author sinyard
 * @date 2020-08-13 22:37
 * @desc
 */
@Controller
@Api(value = "indexController",description = "主页")
public class IndexController {
    @Autowired
    private CourseService courseService;
    @RequestMapping(value = "/index")
    public String index(Model model, HttpServletRequest request){
        HttpSession session = request.getSession(true);
        if(session.getAttribute("USER_INFO") != null) { //如果这个session在（已登陆）
            CourseExample example = new CourseExample();
            CourseExample.Criteria criteria = example.createCriteria();
            criteria.andLeveEqualTo(1);
            criteria.andPidEqualTo(0);
            List<Course> courseList = courseService.selectByExampleWithBLOBs(example);
            for (Course cl : courseList) {
                CourseExample example2 = new CourseExample();
                CourseExample.Criteria criteria2 = example2.createCriteria();
                criteria2.andLeveEqualTo(2);
                criteria2.andPidEqualTo(cl.getCourseid());
                List<Course> next = courseService.selectByExampleWithBLOBs(example2);
                cl.setListCourse(next);
            }
            model.addAttribute("courseList", courseList);
            return "index";
        }
        return "studentlogin";
    }
   /* @RequestMapping(value = "/content-data")
    @ResponseBody
    public Course contentData(Model model,int pid){
        CourseExample example = new CourseExample();
        CourseExample.Criteria criteria = example.createCriteria();
        criteria.andPidEqualTo(pid);
        Course course = courseService.selectByExampleWithBLOBs(example).get(0);
        return course;
    }*/
}
