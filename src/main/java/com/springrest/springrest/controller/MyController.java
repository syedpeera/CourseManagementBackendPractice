package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.springrest.springrest.entity.Course;
import com.springrest.springrest.service.CourseService;

@RestController
public class MyController {
	
	@Autowired
	private CourseService courseService;
	
	//@GetMapping("/courses")
	@RequestMapping(path="/courses", method=RequestMethod.GET)
	public ResponseEntity<List<Course>> getCourses(){
		List<Course> courses = this.courseService.getCourses();
		return new ResponseEntity<>(courses, HttpStatus.OK);
	}
	
	//@GetMapping("/courses/{courseId}")
	@RequestMapping(path="/courses/{courseId}", method=RequestMethod.GET)
	public ResponseEntity<Course> getCourse(@PathVariable String courseId) {
		Course course = this.courseService.getCourse(Long.parseLong(courseId));
		return new ResponseEntity<>(course, HttpStatus.OK);
	}
	
	//@PostMapping("/courses")
	@RequestMapping(path="/courses", method=RequestMethod.POST)
	public ResponseEntity<Course> addCourse(@RequestBody Course course) {
		Course addedCourse = this.courseService.addCourse(course);
		return new ResponseEntity<>(addedCourse, HttpStatus.OK);
	}
	
	//@PutMapping("/courses/{courseId}")
	@RequestMapping(path="/courses/{courseId}", method=RequestMethod.PUT)
	public ResponseEntity<Course> updateCourse(@PathVariable String courseId, @RequestBody Course course) {
		Long id = Long.parseLong(courseId);
		Course updatedCourse = this.courseService.updateCourse(id, course);
		return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
	}
	
	//@DeleteMapping("/courses/{courseId}")
	@RequestMapping(path="/courses/{courseId}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteCourse(@PathVariable String courseId) {
		boolean isDeleted = this.courseService.deleteCourse(Long.parseLong(courseId));
		if(isDeleted) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//@PutMapping("/courses/{courseId}")
	@RequestMapping(path="/courses/{courseId}", method=RequestMethod.PATCH)
	public ResponseEntity<Course> patchCourse(@PathVariable String courseId, @RequestBody Course course) {
		Long id = Long.parseLong(courseId);
		Course patchCourse = this.courseService.patchCourse(id, course);
		return new ResponseEntity<>(patchCourse, HttpStatus.OK);
	}
	
	@RequestMapping(path="/courses/{courseId}", method=RequestMethod.HEAD)
	public ResponseEntity<Course> headCourse(@PathVariable String courseId) {
		Course course = this.courseService.getCourse(Long.parseLong(courseId));
		if(course!=null) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path="/courses", method=RequestMethod.OPTIONS)
	public ResponseEntity<Void> optionsCourses(){
		return ResponseEntity.ok()
				.header("Allow", "GET", "POST", "PUT", "DELETE", "PATCH", "HEAD", "OPTIONS")
				.build();
	}
}
