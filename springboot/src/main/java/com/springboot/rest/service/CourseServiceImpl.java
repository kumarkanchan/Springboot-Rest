package com.springboot.rest.service;

import com.springboot.rest.entity.Courses;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    List<Courses> list;

    public CourseServiceImpl() {
        list = new ArrayList<>();

        list.add(new Courses(111, "DS", "This is DS Book Using Java"));
        list.add(new Courses(333, "ALGO", "This is ALGO Book for Algorithm"));
        list.add(new Courses(222, "MATH", "This is Math Book for Discrete Math"));
    }

    @Override
    public List<Courses> getCourses() {
        return list;
    }

    @Override
    public Courses getCourses(Long courseId) {
        Courses courses = null;

        for (Courses course : list) {
            if (course.getCourseId() == courseId) {
                courses = course;
            }
        }
        return courses;
    }

    @Override
    public Courses addCourses(Courses course) {
        list.add(course);
        return course;
    }

    @Override
    public Courses deleteCourses(Long courseId) {
        Iterator<Courses> coursesIterator = list.iterator();
        while (coursesIterator.hasNext()) {
            Courses courses = coursesIterator.next();
            System.out.println("Course Deleting is : " + courseId);
            if (courses.getCourseId() == courseId) {
                coursesIterator.remove();
                return courses;
            }
        }
        return null;
    }

    @Override
    public Courses updateCourses(Courses courses, Long courseId) {
        list = list.stream().map(c -> {
            if (c.getCourseId() == courseId) {
                c.setTitle(courses.getTitle());
                c.setDescription(courses.getDescription());
            }
            return c;
        }).collect(Collectors.toList());

        return courses;
    }
}
