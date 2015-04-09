package com.studentyears.Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class JSONArray {

	private ArrayList<JSONObject> jsArray;
	
	public JSONArray(){
		jsArray = new ArrayList<JSONObject>();
	}
	
	public void add(JSONObject jsonObject) {
		this.jsArray.add(jsonObject);
	}
	
	public String toArray() {
		StringBuffer returnString = new StringBuffer("[");
		for (int i = 0; i < jsArray.size(); i++) {
			JSONObject jsonObject = jsArray.get(i);
			StringBuffer temp = new StringBuffer("{");
			Iterator iter = jsonObject.getjsHashMap().entrySet().iterator();
			while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			temp.append(entry.getKey()).append(":").append("\""+entry.getValue()+"\"").append(",");
			}
			temp.append("}");
			temp.replace(temp.length()-2, temp.length()-1, "");
			returnString.append(temp).append(",");
			System.out.println("returnstring:"+returnString);
		}
		returnString.append("]");
		returnString.replace(returnString.length()-2, returnString.length()-1, "");
		return returnString.toString();
	}

	private StringBuffer StringBuffer(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
