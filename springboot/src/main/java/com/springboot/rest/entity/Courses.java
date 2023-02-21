package com.springboot.rest.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class Courses {

    private long courseId;
    private String title;
    private String description;

}
