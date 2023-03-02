package com.springboot.rest.service;

import com.springboot.rest.dao.CourseDao;
import com.springboot.rest.entity.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    public CourseServiceImpl() {
    }

    @Override
    public List<Courses> getCourses() {
        return courseDao.findAll();
    }

    @Override
    public Courses getCourses(Long courseId) {
        return courseDao.getOne(courseId);
    }

    @Override
    public Courses addCourses(Courses course) {
        courseDao.save(course);
        return course;
    }

    @Override
    public void deleteCourses(Long parseLong) {
        Courses entity = courseDao.getOne(parseLong);
        courseDao.delete(entity);
    }

    @Override
    public Courses updateCourses(Courses courses, Long courseId) {
        return courses;
    }
}
