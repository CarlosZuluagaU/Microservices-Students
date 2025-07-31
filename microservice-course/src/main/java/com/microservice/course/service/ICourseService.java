package com.microservice.course.service;

import com.microservice.course.Entities.Courses;
import com.microservice.course.http.response.StudentByCourseResponse;

import java.util.List;

public interface ICourseService {

    List<Courses> findAll();

    Courses findById(Long id);

    void save(Courses courses);

    StudentByCourseResponse findStudentsByIdCourse(Long idCourse);
}
