package kh.edu.cstad.rest_api.service;

import kh.edu.cstad.rest_api.domain.Course;
import kh.edu.cstad.rest_api.dto.CourseResponse;

import java.util.List;

public interface CourseService {
    /**
     * For get all course
     * @author SreyPich
     * @return List<CourseResponse>
     */
    List<CourseResponse> getAllCourses(Boolean status);

    List<CourseResponse> getCourses(Boolean status,String title);

    CourseResponse getCourseByCode(String code);

    CourseResponse getCourseById(String id);
}
