/**
 * 
 */
package com.cinglevue.dao.impl;

import javax.inject.Inject;

import com.cinglevue.dao.CommonDAO;
import com.cinglevue.data.db.Mongo;

/**
 * @author mhashendre
 *
 */
public class StudentDAOImpl extends CommonDAO{

	@Inject
	public StudentDAOImpl(Mongo mongo) {
		super(mongo);
	}

}
