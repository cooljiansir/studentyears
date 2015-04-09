package com.studentyears.network;

import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.studentyears.Database.DbPool;
import com.studentyears.Database.HighLevelDbPro;
import com.studentyears.Model.Details;
import com.studentyears.Model.GoodsOrder;
import com.studentyears.Utils.Constant;
import com.studentyears.Utils.ConstantUtils;
import com.studentyears.Utils.ImageFolderUtils;
import com.studentyears.Utils.StringUtils;

//@SuppressWarnings("serial")
public class PublishAction extends ActionSupport{
	
	private Details details;
    
	private String title;
	private String description;
	private String tradelocation;
	private String littlelocation;
	private int    price;
	private int    newpercent;
	private String category;
	private String tel;
	private String name;
    private File[] image; //上传的文件
    private String[] imageFileName; //文件名称
    private String[] imageContentType; //文件类型
    
    public File[] getImage() {
        return image;
    }

    public void setImage(File[] image) {
        this.image = image;
    }

    public String[] getImageContentType() {
        return imageContentType;
    }

    public void setImageContentType(String[] imageContentType) {
        this.imageContentType = imageContentType;
    }

    public String[] getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String[] imageFileName) {
        this.imageFileName = imageFileName;
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTradelocation() {
		return tradelocation;
	}

	public void setTradelocation(String tradelocation) {
		this.tradelocation = tradelocation;
	}

	public String getLittlelocation() {
		return littlelocation;
	}

	public void setLittlelocation(String littlelocation) {
		this.littlelocation = littlelocation;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNewpercent() {
		return newpercent;
	}

	public void setNewpercent(int newpercent) {
		this.newpercent = newpercent;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Details getDetails() {
		return details;
	}

	public void setDetails(Details details) {
		this.details = details;
	}

	public boolean upload(String user, String order) throws IOException
	{
		ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
        String realpath = ServletActionContext.getServletContext().getRealPath(Constant.UPLOAD_IMAGE_FOLDER);
        String userpath = realpath+"/"+user;
        String orderpath = userpath + "/"+order;
        System.out.println(realpath);
        if (image == null) {
			return false;
		}
        else {
            File savedir=new File(orderpath);
            if(!savedir.getParentFile().exists())
                savedir.getParentFile().mkdirs();
            for(int i=0;i<image.length;i++){
                //File savefile = new File(savedir, imageFileName[i]);
            	System.out.println(imageFileName[i]);
                File savefile = new File(savedir, StringUtils.genImageName(i, imageFileName[i]));
                
                FileUtils.copyFile(image[i], savefile);
            }
            ActionContext.getContext().put("message", "文件上传成功");
            return true;
        }
	}
	
	public String getViewtimes(String goodsorderid)
	{
		String sql = "select viewtimes from goodsorder where goodsorderid = ?;";
		String viewtimes = HighLevelDbPro.dbReturnSingleValue(sql, goodsorderid);
		return viewtimes;
	}
	
	public int dataToDatabase(DbPool dbPool, String user, String order)
	{
		
		GoodsOrder goodsOrder = new GoodsOrder();
		System.out.println(getTitle());
		goodsOrder.setemail(user);
		goodsOrder.setgoodsorderId(order);
		goodsOrder.settitle(getTitle());
		goodsOrder.setdescription(getDescription());
		goodsOrder.setcollege("中科院大学");
		goodsOrder.setcampus("雁西湖校区");
		goodsOrder.setcategory(getCategory());
		String picturepackageString = ImageFolderUtils.genOrderImageFolderBase(user, order);
		goodsOrder.setpicturepackage(picturepackageString);
		goodsOrder.setnewofpercentage(getNewpercent());
		goodsOrder.setprice(getPrice());
		goodsOrder.setsold(Constant.NOTSOLD);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		goodsOrder.setreleasedate(timestamp);
		goodsOrder.settel(getTel());
		goodsOrder.setname(getName());
		dbPool.insert(goodsOrder);
		dbPool.updExecute("update user set goodscount=goodscount+1;");
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("title", getTitle());
		request.setAttribute("price", getPrice());
		String tradelocation = getTradelocation()+getLittlelocation();
		request.setAttribute("tradelocation", tradelocation);
		request.setAttribute("viewtimes", "0");
		request.setAttribute("name", getName());
		request.setAttribute("tel", getTel());
		request.setAttribute("date", StringUtils.timestampToDateString(timestamp));
		request.setAttribute("goodsorderid", order);
		request.setAttribute("description", getDescription());
		request.setAttribute("picturepackage", picturepackageString);
		System.err.println(ConstantUtils.returnUserImage(user));
		request.setAttribute("picturepath", ConstantUtils.returnUserImage(user));
		return 0;
	}

    public String execute() {
    	System.out.println("ok");
    	DbPool dbPool = new DbPool();
    	String user = (String) ServletActionContext.getRequest().getSession().getAttribute("username");
    	String sql = "select goodscount from user where email = \"?\";";
    	sql = sql.replaceFirst("\\?", user);
    	String ordercount = dbPool.querySingleValue(sql);
    	String order = StringUtils.generateOrderId(user, ordercount); 
    	
        try {
			if (upload(user,order)) {
				dataToDatabase(dbPool, user, order);
				dbPool.close();
				return "success";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
    }
}