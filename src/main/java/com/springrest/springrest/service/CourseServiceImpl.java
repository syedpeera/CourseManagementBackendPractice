package com.springrest.springrest.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.springrest.springrest.entity.Course;

@Service
public class CourseServiceImpl implements CourseService{

	List<Course> courses;

	public CourseServiceImpl() {
		courses  = new ArrayList<>();
		courses.add(new Course(123,"Java Core","Java OOPS concepts"));
		courses.add(new Course(212,"Java Advance", "Servlets and JSP"));
	}
	
	@Override
	public List<Course> getCourses() {
		return courses;
	}

	@Override
	public Course getCourse(long courseId) {
		Course c=null;
		for(Course course: courses){
			if(course.getId()==courseId) {
				c=course;
				break;
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		courses.add(course);
		return course;
	}

	@Override
	public Course updateCourse(Long courseId, Course updatedCourse) {
		for(Course course: courses) {
			if(course.getId()==courseId) {
				course.setId(updatedCourse.getId());
				course.setName(updatedCourse.getName());
				course.setDescription(updatedCourse.getDescription());
				return course;
			}
		}
		return null;
	}

	@Override
	public boolean deleteCourse(Long courseId) {
		for(int i=0;i<courses.size();i++) {
			Course course = courses.get(i);
			if(course.getId()==courseId) {
				courses.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public Course patchCourse(Long courseId, Course patchCourse) {
		for(Course course: courses) {
			if(course.getId()==courseId) {
				course.setDescription(patchCourse.getDescription());
				return course;
			}
		}
		return null;
	}
}
