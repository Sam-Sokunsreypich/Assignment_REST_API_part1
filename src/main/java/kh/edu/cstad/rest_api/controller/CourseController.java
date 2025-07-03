package kh.edu.cstad.rest_api.controller;

import kh.edu.cstad.rest_api.domain.Course;
import kh.edu.cstad.rest_api.dto.CourseResponse;
import kh.edu.cstad.rest_api.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<CourseResponse> getAllCourses(@RequestParam(required = false, defaultValue = "true") Boolean status) {

        return courseService.getAllCourses(status);
    }

    @GetMapping("/search")
    public List<CourseResponse> getCourses(@RequestParam(required = false, defaultValue = "true") Boolean status,
                                           @RequestParam(required = false,defaultValue = "") String title) {
        return courseService.getCourses(status,title);
    }

    @GetMapping("/id/{id}")
    public CourseResponse getCourseById(@PathVariable String id) {
        return courseService.getCourseById(id);
    }

    @GetMapping("/code/{code}")
    public CourseResponse getCourseByCode(@PathVariable String code) {
        return courseService.getCourseByCode(code);
    }
}
