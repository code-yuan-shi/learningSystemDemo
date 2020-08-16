package com.sinyard.dao;

import com.sinyard.entity.Admin;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  //加上这个注解防止service报错
public interface AdminMapper {

    List<Admin> selectAll();

    List<Admin> selectLike(Admin record);

    int deleteByPrimaryKey(Integer adminid);

    Integer countAdmin();

    int insert(Admin record);

    Admin selectByPrimaryKey(Integer adminid);

    int updateByPrimaryKey(Admin record);

    Admin selectAdminByIdAndPass(Integer adminid, String adminpassword);
}