package com.microservice.course.controller;


import com.microservice.course.Entities.Courses;
import com.microservice.course.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course")
public class CoursesController {

    @Autowired
    private ICourseService courseService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCourse(@RequestBody Courses courses){
        courseService.save(courses);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findByCourseId (@PathVariable Long id){
        return ResponseEntity.ok(courseService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllCourses(){
        return ResponseEntity.ok(courseService.findAll());

    }

    @GetMapping("/search-student/{idCourse}")
    public ResponseEntity<?> findStudentsByIdCourse(@PathVariable Long idCourse){
        return ResponseEntity.ok(courseService.findStudentsByIdCourse(idCourse));
    }

}
