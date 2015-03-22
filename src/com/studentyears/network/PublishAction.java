package com.studentyears.network;

import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.studentyears.Database.DbPool;
import com.studentyears.Model.GoodsOrder;
import com.studentyears.Utils.Constant;
import com.studentyears.Utils.ImageFolderUtils;
import com.studentyears.Utils.StringUtils;

//@SuppressWarnings("serial")
public class PublishAction extends ActionSupport{
    
	private String title;
	private String description;
	private String tradelocation;
	private String littlelocation;
	private int    price;
	private int    newpercent;
	private String category;
	private String tel;
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
	
	public int dataToDatabase(String user, String order)
	{
		DbPool dbPool = new DbPool();
		GoodsOrder goodsOrder = new GoodsOrder();
		System.out.println(getTitle());
		goodsOrder.setgoodsorderId("fasdf");
		goodsOrder.settitle(getTitle());
		goodsOrder.setdescription(getDescription());
		goodsOrder.setemail("sdaf");
		goodsOrder.setcategory(getCategory());
		goodsOrder.setpicturepackage(ImageFolderUtils.genOrderImageFolderBase(user, order));
		goodsOrder.setnewofpercentage(getNewpercent());
		goodsOrder.setprice(getPrice());
		goodsOrder.setsold(Constant.NOTSOLD);
		goodsOrder.setreleasedate(new Timestamp(System.currentTimeMillis()));
		dbPool.insert(goodsOrder);
		dbPool.close();
		//System.out.println("sdfsd");
		return 0;
	}

    public String execute() {
        try {
        	String user = "user_a";
        	String order = "order_a";
			if (upload(user,order)) {
				dataToDatabase(user, order);
				return "Upresult";
				//return "success";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
    }

    
	
	

}