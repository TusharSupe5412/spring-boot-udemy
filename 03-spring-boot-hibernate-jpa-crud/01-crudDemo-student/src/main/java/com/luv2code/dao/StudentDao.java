package com.luv2code.dao;

import com.luv2code.entity.Student;

import java.util.List;

public interface StudentDao {

    void save(Student student);

    Student finById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();
}
