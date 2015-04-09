package com.studentyears.AjaxAction;

import java.util.HashMap;
import java.util.Map;
import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.studentyears.Database.DbPool;
import com.studentyears.Utils.StringUtils;
 
public class LoadAction extends ActionSupport {
	
	private String clear;
	private String result;

	public String getClear() {
		return clear;
	}
	public void setClear(String clear) {
		this.clear = clear;
	}
	public String getResult() {
	
	   return result;
	}
	public void setResult(String result) {
	   this.result=result;
	}
	  
	public String clear() throws Exception {
	       //System.out.println("asdfsdaf");
        // 用一个Map做例�?
           Map<String, String> map = new HashMap<String, String>(); 
           if(clear.equals("true")){
        	   ActionContext.getContext().getSession().clear();
    	   		map.put("name", "success");        	               
           }                         
           else{
        	   map.put("name", "error");
           }
           // 将要返回的map对象进行json处理
           JSONObject jo = JSONObject.fromObject(map);

           // 调用json对象的toString方法转换为字符串然后赋�?给result
           this.result = jo.toString();
           System.out.println(result);
           return SUCCESS;
    }
	

}

