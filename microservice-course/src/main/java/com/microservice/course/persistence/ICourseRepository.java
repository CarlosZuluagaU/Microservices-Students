package com.microservice.course.persistence;

import com.microservice.course.Entities.Courses;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepository extends CrudRepository<Courses, Long> {
}
