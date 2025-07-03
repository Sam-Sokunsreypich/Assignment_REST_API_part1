package kh.edu.cstad.rest_api.repository;

import kh.edu.cstad.rest_api.domain.Course;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
@Setter
@Getter
public class CourseRepository {
    private List<Course> courses;
    public CourseRepository() {
        courses = new ArrayList<>();
        courses.add(Course.builder()
                .id(UUID.randomUUID().toString())
                .title("Java")
                .code("ISTAD-001")
                .status(false)
                .price(300.0)
                .build());
        courses.add(Course.builder()
                .id(UUID.randomUUID().toString())
                .title("Python")
                .code("ISTAD-002")
                .status(true)
                .price(400.0)
                .build());
        courses.add(Course.builder()
                .id("3")
                .title("Spring")
                .code("ISTAD-003")
                .status(true)
                .price(300.0)
                .build());
        courses.add(Course.builder()
                .id("4")
                .title("Spring Boot")
                .code("ISTAD-004")
                .status(true)
                .price(400.0)
                .build());
    }

}
