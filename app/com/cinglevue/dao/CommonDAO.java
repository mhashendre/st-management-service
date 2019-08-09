/**
 * 
 */
package com.cinglevue.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.bson.Document;

import com.cinglevue.data.db.Mongo;
import com.mongodb.MongoException;
import com.mongodb.MongoWriteConcernException;
import com.mongodb.client.MongoDatabase;

/**
 * @author mhashendre
 *
 */

@Singleton
public class CommonDAO {

	protected HashMap<String, MongoDatabase> databaseMap;

	@Inject
	public CommonDAO(Mongo mongo) {
		this.databaseMap = mongo.databaseMap;
	}

	public Object saveOrUpdateObject(String collectionName, Document document) {
		Map<String, Object> result = new HashMap<String, Object>();

		Document filter = new Document();
		filter.put("nic", document.get("nic"));

		Document res = (Document) retreiveObject(collectionName, filter);
		if (res == null) {
			try {
				databaseMap.get(Mongo.DB_ST).getCollection(collectionName).insertOne(document);
				result.put("result", "Successfully Added");
			} catch (com.mongodb.MongoWriteException e) {
				e.printStackTrace();
				result.put("result", "Failed ! with " + e);
			} catch (MongoWriteConcernException e) {
				e.printStackTrace();
				result.put("result", "Failed ! with " + e);
			} catch (MongoException e) {
				e.printStackTrace();
				result.put("result", "Failed ! with " + e);
			}
		} else {
			updateObject(collectionName,filter, document);
			result.put("result", "Successfully Updated");
		}

		return result;
	}

	public Object retreiveObject(String collectionName, Document filter) {
		Document doc = databaseMap.get(Mongo.DB_ST).getCollection(collectionName).find(filter).first();
		return doc;
	}
	
	public Object retreiveObjects(String collectionName, Document filter) {
		List<Document> resultArrayList = new ArrayList<>();
		Iterator<Document> iterator = databaseMap.get(Mongo.DB_ST).getCollection(collectionName).find(filter).iterator();
		while (iterator.hasNext()) {
            Document document = iterator.next();
            document.put("_id",document.get("_id").toString());
            resultArrayList.add(document);
        }
		return resultArrayList;
	}

	public Object deleteObject(String collectionName , Document filter) {
		return databaseMap.get(Mongo.DB_ST).getCollection(collectionName).deleteMany(filter);
	}

	public void updateObject(String collectionName,Document filter , Document document) {
		databaseMap.get(Mongo.DB_ST).getCollection(collectionName).updateOne(filter, new Document("$set" ,document));
	}

}
