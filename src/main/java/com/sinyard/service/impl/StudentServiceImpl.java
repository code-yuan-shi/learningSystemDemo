package com.sinyard.service.impl;

import com.sinyard.dao.StudentMapper;
import com.sinyard.entity.Admin;
import com.sinyard.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sinyard
 * @date 2020-08-13 13:26
 * @desc
 */
@Service
public class StudentServiceImpl implements com.sinyard.service.StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> selectAll() {
        return studentMapper.selectAll();
    }

    @Override
    public Integer countStudent() {
        return studentMapper.countStudent();
    }

    @Override
    public List<Student> selectLike(Student record) {
        return studentMapper.selectLike(record);
    }

    @Override
    public Student selectByPrimaryKey(Integer studentid) {
        return studentMapper.selectByPrimaryKey(studentid);
    }

    @Override
    public int insert(Student record) {
        return studentMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        return studentMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer studentid) {
        return studentMapper.deleteByPrimaryKey(studentid);
    }

    @Override
    public String login(Integer studentid, String password) {
        Student student = studentMapper.selectStudentByIdAndPass(studentid, password);
        if (student != null) { //登录成功
            return "redirect:../index";
        }
        return "studentlogin";  //失败--后续添加提示信息等
    }
}
