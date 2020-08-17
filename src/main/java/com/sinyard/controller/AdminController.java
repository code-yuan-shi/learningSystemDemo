package com.sinyard.controller;
import com.sinyard.entity.Admin;
import com.sinyard.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sinyard
 * @date 2020-08-13 13:36
 * @desc
 */
@Controller
@RequestMapping(value = "/admin",method = {RequestMethod.POST,RequestMethod.GET})
@Api(tags = "AdminController",description = "管理员操作")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/loginCheck")
    @ApiOperation("实现管理员登录")
    public String login(@RequestParam Integer adminid, @RequestParam String adminpassword, HttpServletRequest request) {
        String statu = adminService.login(adminid, adminpassword);
        System.out.println(statu);
        //创建session对象
        HttpSession session = request.getSession(true);
        session.setAttribute("USER_INFO",adminid);
        return statu;
    }
    @RequestMapping(value = "/test")
    @ApiOperation("测试类")
    public String logintest(){
        return "Admin/index";
    }

    @RequestMapping(value = "/login")
    @ApiOperation("实现访问管理员登录页")
    public String login(){
        return "login";
    }


    @RequestMapping(value = "/countAdmin")
    @ApiOperation("统计管理员数量")
    @ResponseBody
    public Integer countAdmin() {
        Integer count = adminService.countAdmin();

     //   System.out.println(count);
        return count;
    }

    @RequestMapping(value = "/selectLike")
    @ApiOperation("模糊查询管理员")
    @ResponseBody
    public Map<String, Object> selectLike(Admin record) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "提示信息");
        result.put("count",String.valueOf(adminService.countAdmin())); //后续从数据库统计
        result.put("data", adminService.selectLike(record));
        System.out.println(result);
        return result;
    }

    @RequestMapping(value = "/insert")
    @ApiOperation("插入管理员")
    @ResponseBody
    public int insert(@RequestBody Admin record) {
        System.out.println("执行了插入管理员");
        System.out.println(record);
        return adminService.insert(record);
    }
    @RequestMapping(value = "/selectById")
    @ApiOperation("根据ID查询管理员")
    @ResponseBody
    public Admin selectByPrimaryKey (@RequestBody Integer adminid) {
        return adminService.selectByPrimaryKey(adminid);
    }
    @RequestMapping(value = "/updateById" )
    @ApiOperation("根据ID修改管理员")
    @ResponseBody
    public int updateByPrimaryKey( Admin record) {
        System.out.println(record);
        System.out.println("执行了修改管理员");
        return adminService.updateByPrimaryKey(record);
    }

    @RequestMapping(value = "/deleteById")
    @ApiOperation("根据ID删除管理员")
    @ResponseBody
    public int deleteByPrimaryKey(Integer adminid) {
        adminService.deleteByPrimaryKey(adminid);
        int suc = 200;
        return suc;
    }

}
