/**
 * 
 */
package com.cinglevue.service;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * @author mhashendre
 *
 */
public interface StudentService {

	public Object saveOrUpdate(JsonNode data);
	
	public Object fetchStudents();
	
}
