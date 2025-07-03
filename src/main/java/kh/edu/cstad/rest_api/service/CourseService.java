package kh.edu.cstad.rest_api.service;

import kh.edu.cstad.rest_api.domain.Course;
import kh.edu.cstad.rest_api.dto.CourseResponse;

import java.util.List;

public interface CourseService {
    /**
     * For get all courses
     * @author SreyPich
     * @return List<CourseResponse>
     */
    List<CourseResponse> getAllCourses(Boolean status);

    /**
     * For get courses By Status and By Title
     * @author SreyPich
     * @return List<CourseResponse>
     */
    List<CourseResponse> getCourses(Boolean status,String title);

    /**
     * For get course By Code
     * @author SreyPich
     * @return CourseResponse
     */
    CourseResponse getCourseByCode(String code);

    /**
     * For get course By Id
     * @author SreyPich
     * @return CourseResponse
     */
    CourseResponse getCourseById(String id);
}
