/**
 * 
 */
package com.cinglevue.service.impl;

import javax.inject.Inject;

import org.bson.Document;

import com.cinglevue.dao.impl.StudentDAOImpl;
import com.cinglevue.data.db.Mongo;
import com.cinglevue.data.transformer.StudentDataTransformer;
import com.cinglevue.service.StudentService;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * @author mhashendre
 *
 */
public class StudenServiceImpl implements StudentService{

	private StudentDAOImpl studentDao;
	StudentDataTransformer transformer = new StudentDataTransformer();
	
	@Inject
	public StudenServiceImpl(StudentDAOImpl studentDao) {
		this.studentDao = studentDao;
	}
	
	@Override
	public Object saveOrUpdate(JsonNode data) {
		Document doc = transformer.transform(data);
		Object result = studentDao.saveOrUpdateObject(Mongo.DB_STUDENT_TABLE, doc);
		return result;
	}
	
	@Override
	public Object fetchStudents() {
		Document filter = new Document();
		Object result = studentDao.retreiveObjects(Mongo.DB_STUDENT_TABLE, filter);
		return result;
	}

}
