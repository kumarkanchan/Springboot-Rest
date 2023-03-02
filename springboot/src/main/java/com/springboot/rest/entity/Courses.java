package com.springboot.rest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class Courses {

    @Id
    private long courseId;
    private String title;
    private String description;

}
