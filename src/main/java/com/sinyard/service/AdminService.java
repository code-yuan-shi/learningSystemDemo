package com.sinyard.service;

import com.sinyard.entity.Admin;

import java.util.List;

/**
 * @author sinyard
 * @date 2020-08-13 13:25
 * @desc
 */
public interface AdminService {
    /**
     * 查询所有管理员
     * @return
     */
    public List<Admin> selectAll();

    /**
     *统计管理员数目
     * @return
     */
    public Integer countAdmin();
    /**
     * 模糊查询管理员
     * @return
     */
    public List<Admin> selectLike(Admin record);
    /**
     * 根据ID查询管理员
     * @param adminid
     * @return
     */
    public Admin selectByPrimaryKey(Integer adminid);
    /**
     * 注册管理员
     * @return
     */
    public int insert(Admin record);

    /**
     * 根据传来的ID修改其他信息
     * @param record
     * @return
     */
    public int updateByPrimaryKey(Admin record);

    /**
     * 根据ID删除管理员
     * @param adminid
     * @return
     */
    public int deleteByPrimaryKey(Integer adminid);

    /**
     * 实现登录功能
     * @param adminid 管理员编号
     * @param password 密码
     * @return
     */
    String login(Integer adminid,String password);
}
