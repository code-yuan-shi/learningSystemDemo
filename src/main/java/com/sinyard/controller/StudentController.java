package com.sinyard.controller;

import com.sinyard.entity.Admin;
import com.sinyard.entity.Student;
import com.sinyard.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping(value = "/student",method = {RequestMethod.POST,RequestMethod.GET})
@Api(value = "StudentController",description = "管理学生操作")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/deleteById")
    @ApiOperation("根据学号删除学生")
    @ResponseBody
    public int deleteByPrimaryKey(Integer studentid) {
        studentService.deleteByPrimaryKey(studentid);
        int suc = 200;
        return suc;
    }

    @RequestMapping("/insert")
    @ApiOperation("添加学生")
    @ResponseBody
    public int insert(@RequestBody Student record) {
        return studentService.insert(record);
    }

    @RequestMapping("/selectById")
    @ApiOperation("根据学号查找")
    @ResponseBody
    public Student selectByPrimaryKey(@RequestBody Integer studentid) {
        return studentService.selectByPrimaryKey(studentid);
    }

    @RequestMapping("/selectAll")
    @ApiOperation("查询所有学生")
    @ResponseBody
    public List<Student> selectAll() {
        return studentService.selectAll();
    }

    @RequestMapping("/selectLike")
    @ApiOperation("模糊查询学生")
    @ResponseBody
    public Map<String, Object> selectLike(Student record) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "提示信息");
        result.put("count",String.valueOf(studentService.countStudent()));
        result.put("data", studentService.selectLike(record));
        System.out.println(result);
        return result;
    }
    @RequestMapping("/updateById")
    @ApiOperation("根据学号更新信息")
    @ResponseBody
    public int updateByPrimaryKey(@RequestBody Student record) {
        return studentService.updateByPrimaryKey(record);
    }

}
