package com.studentyears.Model;

import java.util.HashMap;
import java.util.Map;

public class JSONObject {
	
	private HashMap<String, String> jsHashMap;

	public JSONObject()
	{
		jsHashMap = new HashMap<String, String>();
	}
	
	public void put(String key, String value)
	{
		jsHashMap.put(key, value);
	}

	public HashMap<String, String> getjsHashMap()
	{
		return jsHashMap;
	}
}
