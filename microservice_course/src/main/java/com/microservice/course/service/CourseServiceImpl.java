package com.microservice.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.course.entities.Course;
import com.microservice.course.persistence.ICourseRespository;

@Service
public class CourseServiceImpl implements ICourseService{

    @Autowired
    private ICourseRespository iCourseRespository;

    @Override
    public List<Course> findAll() {
        return (List<Course>) iCourseRespository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return iCourseRespository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        iCourseRespository.save(course);
    }
    
}
