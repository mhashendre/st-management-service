/**
 * 
 */
package controllers;


import javax.inject.Inject;

import com.cinglevue.service.StudentService;
import com.fasterxml.jackson.databind.JsonNode;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * @author mhashendre
 *
 */

public class StudentController extends Controller{
	
	private final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(getClass().getName());
	
	private StudentService studentService;
	
	@Inject
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	public Result saveStudent() {
		@SuppressWarnings("deprecation")
		JsonNode requestData = request().body().asJson();
		Object result = this.studentService.saveOrUpdate(requestData);
		return ok(Json.toJson(result));
	}
	
	public Result fetchStudents() {
		Object result = this.studentService.fetchStudents();
		return ok(Json.toJson(result));
	}

}
