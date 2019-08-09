/**
 * 
 */
package com.cinglevue.data.db;

import java.util.HashMap;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.typesafe.config.Config;
import org.slf4j.LoggerFactory;

/**
 * @author mhashendre
 *
 */

@Singleton
public class Mongo {
	
	protected final org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());
	
	public static String DB_ST = "studentmanagementdata";
	public static String DB_STUDENT_TABLE = "student";

	public HashMap<String, MongoDatabase> databaseMap = new HashMap<>();
	public MongoClient mongoClient 	= null;

	private static Mongo mongo = null;
	private static Config configuration;

	@Inject
	private Mongo() {
		logger.info("DB : [Mongo] - Starting...");
		MongoClientURI connectionString = new MongoClientURI(configuration.getString("app.db.mongo.url"));
		mongoClient = new MongoClient(connectionString);

        databaseMap.put(Mongo.DB_ST, mongoClient.getDatabase(configuration.getString("app.db.mongo.studentDBName")));

	}

	public static void setConfiguration(Config configuration) {
		Mongo.configuration = configuration;
	}

	public void mongoClose() {
		mongoClient.close();
	}

	public static Mongo getInstance() {
		if (mongo == null) {
			synchronized (Mongo.class) {
				if (mongo == null) {
					mongo = new Mongo();
				}
			}
		}
		return mongo;
	}

	public MongoDatabase getDatabase(String databaseName) {
		return databaseMap.get(databaseName);
	}


}
