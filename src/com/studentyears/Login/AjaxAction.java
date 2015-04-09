package com.studentyears.Login;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class AjaxAction extends ActionSupport {

    private String mname;

    private String mpass;
    /*省略getter和setter方法*/
    
	public String getMname() {
		return mname;
	}
	
	public void setMname(String mname) {
		this.mname = mname;
	}



	public String getMpass() {
		return mpass;
	}



	public void setMpass(String mpass) {
		this.mpass = mpass;
	}
    
    
    public String execute() throws Exception {
       boolean result=false;
       System.out.println("ok");
       System.out.println(getMname());
       System.out.println(getMpass());
       
       if("wll".equals(mname)&& "123".equals(mpass))
       {
           result=true;
       }
       //向客户端传递数据

       ServletActionContext.getResponse().getWriter().print(result); 

       return null;

    }

}
