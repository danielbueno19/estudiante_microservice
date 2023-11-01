package com.microservice.course.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {    
    private String name;
    private String lastname;
    private String email;
    private Long courseId;
}
