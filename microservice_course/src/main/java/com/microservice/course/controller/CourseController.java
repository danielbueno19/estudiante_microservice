package com.microservice.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.course.entities.Course;
import com.microservice.course.service.ICourseService;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private ICourseService iCourseService;

     @GetMapping("all")
    public ResponseEntity<?> findAllCourse(){
        return ResponseEntity.ok(iCourseService.findAll());
    }

    @GetMapping("search/{id}")
    public ResponseEntity<?> findByIdCourse(@PathVariable Long id){
        return ResponseEntity.ok(iCourseService.findById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("create")
    public void saveCourse(@RequestBody Course course){
        iCourseService.save(course);
    }

    @GetMapping("search-student/{idCourse}")
    public ResponseEntity<?> findStudentByIdCourse(@PathVariable Long idCourse){
        return ResponseEntity.ok(iCourseService.findStudentByIdCourse(idCourse));
    }
}
