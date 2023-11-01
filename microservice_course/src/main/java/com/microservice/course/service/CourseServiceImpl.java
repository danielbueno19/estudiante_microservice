package com.microservice.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.course.client.StudentClient;
import com.microservice.course.controller.dto.StudentDTO;
import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudentByCourseResponse;
import com.microservice.course.persistence.ICourseRespository;

@Service
public class CourseServiceImpl implements ICourseService{

    @Autowired
    private ICourseRespository iCourseRespository;

    @Autowired
    private StudentClient studentClient;

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

    @Override
    public StudentByCourseResponse findStudentByIdCourse(Long idCourse) {
        Course course = iCourseRespository.findById(idCourse).orElse(new Course());

        List<StudentDTO> studentDTOList = studentClient.findAllStudentByCourse(idCourse);

        return StudentByCourseResponse.builder()
                                      .courseName(course.getName())
                                      .teacher(course.getTeacher())
                                      .studentDTOList(studentDTOList)
                                      .build();
    }
    
}
