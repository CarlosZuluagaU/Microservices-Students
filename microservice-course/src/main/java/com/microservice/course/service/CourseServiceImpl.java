package com.microservice.course.service;

import com.microservice.course.Entities.Courses;
import com.microservice.course.client.StudentClient;
import com.microservice.course.dto.StudentDTO;
import com.microservice.course.http.response.StudentByCourseResponse;
import com.microservice.course.persistence.ICourseRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService{

    @Autowired
    private ICourseRepository courseRepository;

    @Autowired
    private StudentClient studentClient;

    @Override
    public List<Courses> findAll() {
        return (List<Courses>) courseRepository.findAll();
    }

    @Override
    public Courses findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Courses courses) {
        courseRepository.save(courses);
    }

    @Override
    public StudentByCourseResponse findStudentsByIdCourse(Long idCourse) {

        //Consultar el curso
        Courses courses = courseRepository.findById(idCourse).orElse(new Courses());

        //Get list of students
        List<StudentDTO> studentDTOList = studentClient.findAllStudentByCourse(idCourse);

        return StudentByCourseResponse.builder()
                .courseName(courses.getName())
                .teacher(courses.getTeacher())
                .studentDTOS(studentDTOList)
                .build();
    }
}
