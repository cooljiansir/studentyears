package com.studentyears.ProcessAction;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.studentyears.Database.HighLevelDbPro;
import com.studentyears.Utils.StringUtils;

public class ShowDetailsAction extends ActionSupport{
	
	private String goodsorderid;

	public String getGoodsorderid() {
		return goodsorderid;
	}

	public void setGoodsorderid(String goodsorderid) {
		this.goodsorderid = goodsorderid;
	}

	@Override
	public String execute() throws Exception {
	if(true){
		System.out.println("aa"+this.getGoodsorderid());
		showdetail(goodsorderid);
		return SUCCESS;
	}
	  	return LOGIN;
	}
	
	public void showdetail(String goodsorderid)
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("goodsorderid", goodsorderid);
		String sql = "select g.email, title, description, g.college, g.campus, picturepackage, price, viewtimes, releasedate, g.tel, name, u.picturepath " +
				"from goodsorder as g left join user as u on g.email = u.email " +
				"where goodsorderid = ?;";
		//String arg = goodsorderid;
		String arg = "1451607278@qq.com0";
		String jsonString  = HighLevelDbPro.dbReturnRsJson(sql, arg);
		System.out.println(jsonString);
		JSONArray array = JSONArray.fromObject(jsonString);
		for(int i = 0; i < array.size(); i++){
            JSONObject jsonObject = array.getJSONObject(i);
			request.setAttribute("title", jsonObject.get("title"));
			String location = jsonObject.getString("college")+jsonObject.getString("campus");
			request.setAttribute("tradelocation", location);
			request.setAttribute("price", jsonObject.get("price"));
			request.setAttribute("date", StringUtils.timestampToDateString((String)jsonObject.get("releasedate")));
			request.setAttribute("viewtimes", jsonObject.get("viewtimes"));
			request.setAttribute("tel", jsonObject.get("tel"));
			request.setAttribute("name", jsonObject.get("name"));
			//request.setAttribute("orderid", jsonObject.get("goodsorderid"));
			request.setAttribute("description", jsonObject.get("description"));
			request.setAttribute("email", jsonObject.get("email"));
			request.setAttribute("picturepackage", jsonObject.get("picturepackage"));
			request.setAttribute("picturepath", jsonObject.get("picturepath"));
        }
	}
}
