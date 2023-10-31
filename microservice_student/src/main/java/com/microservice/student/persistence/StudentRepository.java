package com.microservice.student.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microservice.student.entities.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findAllByCourseId(Long idCorse);
}
