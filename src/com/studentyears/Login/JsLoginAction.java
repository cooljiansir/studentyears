package com.studentyears.Login;

import java.util.HashMap;
import java.util.Map;
import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.studentyears.Database.DbPool;
import com.studentyears.Utils.StringUtils;
 
public class JsLoginAction extends ActionSupport {
	
	private String username;
	  private String password;
	 private String result;
	 
	  public String getUsername() {
	   return username;
	  }
	  public void setUsername(String username) {
	   this.username = username;
	  }
	  public String getPassword() {
	   return password;
	  }
	  public void setPassword(String password) {
	   this.password = password;
	  }
	
	 
	   public String getResult() {
	
		   return result;
		  }
		  public void setResult(String result) {
		   this.result=result;
		  }
	  
	public String login() throws Exception {
	       
        // 用一个Map做例�?
           Map<String, String> map = new HashMap<String, String>(); 
       if(username.equals("admin") && password.equals("admin")){
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
	
	public String exist() throws Exception {
	   DbPool dbPool = new DbPool();
	   System.out.println("1");
	   String sql = "select * from user where email = \"?\";";
	   System.out.println("2");
	   sql = sql.replaceFirst("\\?", "asdf");
	   dbPool.exist(sql);
	   System.out.println("3");
	   dbPool.close();
        // 用一个Map做例�?
           Map<String, String> map = new HashMap<String, String>(); 
       if(username.equals("admin") ){
    	   this.result = StringUtils.returnSuccessJson(true);   
       }
       else{
    	   this.result = StringUtils.returnSuccessJson(false);   
       }

       /*// 将要返回的map对象进行json处理
       JSONObject jo = JSONObject.fromObject(map);

       // 调用json对象的toString方法转换为字符串然后赋�?给result
       this.result = jo.toString();*/
       System.out.println(this.result);
       System.out.println(result);
       return SUCCESS;
    }
}

