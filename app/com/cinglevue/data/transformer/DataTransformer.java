package com.cinglevue.data.transformer;

import java.util.Map;

import org.bson.Document;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author mhashendre
 *
 */
abstract class DataTransformer {

	ObjectMapper mapper = new ObjectMapper();

	@SuppressWarnings("unchecked")
	public Document transform(JsonNode requestData) {
		Document doc = new Document();
		try {
			
			Map<String, Object> mapVal = mapper.readValue(requestData.toString(), Map.class);
			try {
				doc = Document.parse(mapper.writeValueAsString(mapVal));
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return doc;
	}

}
