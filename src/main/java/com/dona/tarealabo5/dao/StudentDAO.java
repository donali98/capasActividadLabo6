package com.dona.tarealabo5.dao;

import java.util.List;

import com.dona.tarealabo5.domain.Estudiante;

import org.springframework.dao.DataAccessException;

public interface StudentDAO {

    public List<Estudiante> findAll() throws DataAccessException;

    public Estudiante findOne(Integer code) throws DataAccessException;

    public void save(Estudiante e) throws DataAccessException;

    public void delete(Integer codStudent) throws DataAccessException;
}