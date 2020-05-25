package com.dona.tarealabo5.service;

import java.util.List;

import com.dona.tarealabo5.dao.StudentDAO;
import com.dona.tarealabo5.domain.Estudiante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDAO studentDao;

    @Override
    public List<Estudiante> findAll() throws DataAccessException {
        return studentDao.findAll();
    }

    @Override
    public Estudiante findOne(Integer code) throws DataAccessException {
        return studentDao.findOne(code);
    }

    @Override
    public void save(Estudiante student) throws DataAccessException {
        studentDao.save(student);

    }

    @Override
    public void delete(Integer code) throws DataAccessException {
        studentDao.delete(code);
    }
    
}