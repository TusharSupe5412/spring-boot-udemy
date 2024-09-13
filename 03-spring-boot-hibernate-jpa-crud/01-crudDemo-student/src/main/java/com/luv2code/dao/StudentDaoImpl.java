package com.luv2code.dao;

import com.luv2code.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao{

    // Define a field for entity manager
    private EntityManager entityManager;

    // Generate constructor
    @Autowired
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student finById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        //Create a query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student",Student.class);
        //return query result
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {

        //Create a query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student where lastName=: theLastName",Student.class);

        //Set query parameter
        theQuery.setParameter("theLastName",lastName);

        //return query result
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student myStudent = entityManager.find(Student.class,id);
        entityManager.remove(myStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        return entityManager.createQuery("DELETE Student").executeUpdate();
    }

}
