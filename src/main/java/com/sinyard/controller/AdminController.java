package com.sinyard.controller;

import com.sinyard.entity.Admin;
import com.sinyard.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
//    @Autowired
//    private Admin admin;
    @RequestMapping(value = "/test")
    @ApiOperation("实现管理员登录")
    public String login(@RequestParam Integer adminid, @RequestParam String adminpassword){
//        return "index";
        String statu = adminService.login(adminid,adminpassword);
        System.out.println(statu);
        return statu;
    }

    @RequestMapping(value = "/selectAll")
    @ApiOperation("查询所有用户")
    @ResponseBody
    public List<Admin> selectAll() {
        return adminService.selectAll();
    }

    @RequestMapping(value = "/insert")
    @ApiOperation("插入管理员")
    @ResponseBody
    public int insert(@RequestBody Admin record) {
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
    public int updateByPrimaryKey(@RequestBody Admin record) {
        return adminService.updateByPrimaryKey(record);
    }

    @RequestMapping(value = "/deleteById")
    @ApiOperation("根据ID删除管理员")
    @ResponseBody
    public int deleteByPrimaryKey(Integer adminid) {
        return adminService.deleteByPrimaryKey(adminid);
    }

}
