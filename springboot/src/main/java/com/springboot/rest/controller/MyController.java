package com.springboot.rest.controller;

import com.springboot.rest.entity.Courses;
import com.springboot.rest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello This is Rest Response /hello";
    }

    @GetMapping("/home")
    public String home() {
        return "Hello This is Rest Response /home";
    }

    //Get All Courses
    @GetMapping("/courses")
    public List<Courses> getCourses() {
        return this.courseService.getCourses();
    }

    @GetMapping("/courses/{courseId}")
    public Courses getCourses(@PathVariable String courseId) {
        return this.courseService.getCourses(Long.parseLong(courseId));
    }

    @PostMapping("/courses")
    public Courses addCourses(@RequestBody Courses course) {
        return this.courseService.addCourses(course);
    }

    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity <HttpStatus> deleteCourses(@PathVariable String courseId ) {
        try{
            this.courseService.deleteCourses(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/courses/{courseId}")
    public Courses updateCourses(@RequestBody Courses course, @PathVariable ("courseId") String courseId ) {
        return this.courseService.updateCourses(course, Long.parseLong(courseId));
    }

}
