package com.microservice.student.controller;

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

import com.microservice.student.entities.Student;
import com.microservice.student.service.IStudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private IStudentService iStudentService;

    @GetMapping("all")
    public ResponseEntity<?> findAllStudent(){
        return ResponseEntity.ok(iStudentService.findAll());
    }

    @GetMapping("search/{id}")
    public ResponseEntity<?> findByIdStudent(@PathVariable Long id){
        return ResponseEntity.ok(iStudentService.findById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("create")
    public void saveStudent(@RequestBody Student student){
        iStudentService.save(student);
    }

    @GetMapping("/search-by-course/{idCourse}")
    public ResponseEntity<?> findByIdCourse(@PathVariable Long idCourse){
        return ResponseEntity.ok(iStudentService.findByCourse(idCourse));
    }
}
