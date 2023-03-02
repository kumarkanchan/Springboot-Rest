package com.springboot.rest.dao;

import com.springboot.rest.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Courses, Long> {


}
