package com.dona.tarealabo5.service;

import java.util.List;

import com.dona.tarealabo5.domain.Estudiante;

import org.springframework.dao.DataAccessException;

public interface StudentService {

    public List<Estudiante> findAll() throws DataAccessException;
    public Estudiante findOne(Integer code) throws DataAccessException;
    public void save(Estudiante student) throws DataAccessException;
    public void delete(Integer code) throws DataAccessException;


}