package com.studentyears.network;

import com.opensymphony.xwork2.ActionSupport;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//@SuppressWarnings("serial")
public class UploadAction extends ActionSupport{
    
    private File[] image; //上传的文件
    private String[] imageFileName; //文件名称
    private String[] imageContentType; //文件类型

    public String execute() throws Exception {
        ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
        String realpath = ServletActionContext.getServletContext().getRealPath("/multiupload");
        System.out.println(realpath);
        if (image != null) {
        	System.out.println("ok");
            File savedir=new File(realpath);
            if(!savedir.getParentFile().exists())
                savedir.getParentFile().mkdirs();
            for(int i=0;i<image.length;i++){
                File savefile = new File(savedir, imageFileName[i]);
                FileUtils.copyFile(image[i], savefile);
            }
            ActionContext.getContext().put("message", "文件上传成功");
        }
        return "success";
    }

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



    
}