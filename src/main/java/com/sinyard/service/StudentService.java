package com.sinyard.service;

import com.sinyard.entity.Student;

import java.util.List;

/**
 * @author sinyard
 * @date 2020-08-13 13:24
 * @desc
 */
public interface StudentService {
    /**
     * 查询所有学生
     * @return
     */
    public List<Student> selectAll();

    /**
     *统计学生数目
     * @return
     */
    public Integer countStudent();

    /**
     * 模糊查询学生
     * @param record
     * @return
     */
    public List<Student> selectLike(Student record);
    /**
     * 根据学号查询学生
     * @param adminid
     * @return
     */
    public Student selectByPrimaryKey(Integer adminid);

    /**
     * 添加学生
     * @param record
     * @return
     */
    public int insert(Student record);

    /**
     * 根据ID修改学生信息
     * @param record
     * @return
     */
    public int updateByPrimaryKey(Student record);

    /**
     * 根据ID删除学生
     * @param studentid
     * @return
     */
    public int deleteByPrimaryKey(Integer studentid);
}
