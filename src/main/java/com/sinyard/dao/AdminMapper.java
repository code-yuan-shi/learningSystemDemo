package com.sinyard.dao;

import com.sinyard.entity.Admin;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AdminMapper {

    List<Admin> selectAll();

    int deleteByPrimaryKey(Integer adminid);

    int insert(Admin record);

    Admin selectByPrimaryKey(Integer adminid);

    int updateByPrimaryKey(Admin record);

    Admin selectAdminByIdAndPass(Integer adminid, String adminpassword);
}