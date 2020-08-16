package com.sinyard.controller;

import com.sinyard.entity.Admin;
import com.sinyard.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
//    @Autowired
//    private Admin admin;
    @RequestMapping(value = "/loginCheck")
    @ApiOperation("实现管理员登录")
    public String login(@RequestParam Integer adminid, @RequestParam String adminpassword){
        String statu = adminService.login(adminid,adminpassword);
        System.out.println(statu);
        //创建session对象
//        HttpSession session = request.getSession(true);
//        session.setAttribute("USER_INFO",userInfo);
        return statu;
    }

    @RequestMapping(value = "/login")
    @ApiOperation("实现访问管理员登录页")
    public String login(){
        return "login";
    }


    @RequestMapping(value = "/selectAll")
    @ApiOperation("查询所有用户")
    @ResponseBody
    public  Map<String, Object>  selectAll() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "提示信息");
        result.put("count","2"); //条数
        result.put("data", adminService.selectAll());
        return result;
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
    public int updateByPrimaryKey( Admin record) {
        System.out.println("执行了修改管理员");
        adminService.updateByPrimaryKey(record);
        return 1;
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
