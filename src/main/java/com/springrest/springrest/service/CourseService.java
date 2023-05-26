package com.springrest.springrest.service;

import java.util.List;

import com.springrest.springrest.entity.Course;

public interface CourseService {
	public List<Course> getCourses();
	public Course getCourse(long courseId);
	public Course addCourse(Course course);
	public Course updateCourse(Long courseId, Course course);
	public Course patchCourse(Long courseId, Course course);
	public boolean deleteCourse(Long courseId);
}
