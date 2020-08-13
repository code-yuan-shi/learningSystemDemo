package com.sinyard.service.impl;

import com.sinyard.dao.StudentMapper;
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
public class StudentService implements com.sinyard.service.StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> selectAll() {
        return studentMapper.selectAll();
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
}
