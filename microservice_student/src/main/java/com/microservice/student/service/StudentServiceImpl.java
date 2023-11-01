package com.microservice.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.student.entities.Student;
import com.microservice.student.persistence.StudentRepository;

@Service
public class StudentServiceImpl implements IStudentService{

    @Autowired
    private StudentRepository studenRepository;

    @Override
    public List<Student> findAll() {
        return (List<Student>) studenRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studenRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Student student) {
        studenRepository.save(student);
    }

    @Override
    public List<Student> findByCourse(Long idCourse) {
        return studenRepository.findAllByCourseId(idCourse);
    }
    
}
