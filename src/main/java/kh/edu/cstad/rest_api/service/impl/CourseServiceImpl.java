package kh.edu.cstad.rest_api.service.impl;

import kh.edu.cstad.rest_api.domain.Course;
import kh.edu.cstad.rest_api.dto.CourseResponse;
import kh.edu.cstad.rest_api.repository.CourseRepository;
import kh.edu.cstad.rest_api.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;


    @Override
    public List<CourseResponse> getAllCourses(Boolean status) {

        //filter Data
        List<Course> filteredCourses = courseRepository.getCourses().stream()
                .filter(course -> course.getStatus().equals(true))
                .toList();

        //Map data
        List<CourseResponse> courseResponseList = filteredCourses
                .stream()
                .map(course -> CourseResponse.builder()
                        .title(course.getTitle())
                        .code(course.getCode())
                        .price(course.getPrice())
                        .status(course.getStatus())
                        .build()
                )
                .toList();


        return courseResponseList;
    }



    @Override
    public List<CourseResponse> getCourses(Boolean status, String title) {
        List<CourseResponse> courseResponseList = courseRepository.getCourses()
                .stream()
                .filter(course -> course.getStatus().equals(status) )
                .filter(course -> course.getTitle().toLowerCase().startsWith(title.toLowerCase()))
                .map(course -> CourseResponse.builder()
                            .title(course.getTitle())
                            .code(course.getCode())
                            .price(course.getPrice())
                            .status(course.getStatus())
                        .build())
                .toList();
        return courseResponseList;
    }

    @Override
    public CourseResponse getCourseByCode(String code) {
        return courseRepository.getCourses()
                .stream().filter(course -> course.getCode().equals(code))
                .findFirst()
                .map(course -> CourseResponse.builder()
                        .title(course.getTitle())
                        .code(course.getCode())
                        .price(course.getPrice())
                        .status(course.getStatus())
                        .build())
                .orElse(null);
    }

    @Override
    public CourseResponse getCourseById(String id) {
        return courseRepository.getCourses()
                .stream().filter(course -> course.getId().equals(id))
                .findFirst()
                .map(course -> CourseResponse.builder()
                        .title(course.getTitle())
                        .code(course.getCode())
                        .price(course.getPrice())
                        .status(course.getStatus())
                        .build())
                .orElse(null);
    }


}
