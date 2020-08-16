package com.sinyard.service.impl;

import com.sinyard.dao.AdminMapper;
import com.sinyard.entity.Admin;
import com.sinyard.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sinyard
 * @date 2020-08-13 13:26
 * @desc
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public List<Admin> selectAll() {
        return adminMapper.selectAll();
    }

    @Override
    public Admin selectByPrimaryKey(Integer adminid) {
        return adminMapper.selectByPrimaryKey(adminid);
    }

    @Override
    public int insert(Admin record) {
        return adminMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKey(Admin record) {
        return adminMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer adminid) {
        return adminMapper.deleteByPrimaryKey(adminid);
    }

    @Override
    public String login(Integer adminid, String password) {
        Admin admin = adminMapper.selectAdminByIdAndPass(adminid, password);
        if (admin != null) { //登录成功
            return "Admin/Index";
        }
        return "login";  //失败--后续添加提示信息等
    }
}
