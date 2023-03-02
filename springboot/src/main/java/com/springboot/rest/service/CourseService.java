package com.springboot.rest.service;

import com.springboot.rest.entity.Courses;

import java.util.List;

public interface CourseService {

    public List<Courses> getCourses();

    public Courses getCourses(Long courseId);

    public Courses addCourses(Courses course);

    public void deleteCourses(Long courseId);

    public Courses updateCourses(Courses course, Long courseId);

}
