package com.studentyears.network;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {
	// username属性用来封装用户名
	private String username;
	
	// myFile属性用来封装上传的文件
	private File myFile;
	
	// myFileContentType属性用来封装上传文件的类型
	private String myFileContentType;

	// myFileFileName属性用来封装上传文件的文件名
	private String myFileFileName;

	
	//获得username值
	public String getUsername() {
		return username;
	}

	//设置username值
	public void setUsername(String username) {
		this.username = username;
	}

	//获得myFile值
	public File getMyFile() {
		return myFile;
	}

	//设置myFile值
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	//获得myFileContentType值
	public String getMyFileContentType() {
		return myFileContentType;
	}

	//设置myFileContentType值
	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	//获得myFileFileName值
	public String getMyFileFileName() {
		return myFileFileName;
	}

	//设置myFileFileName值
	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	public String execute() throws Exception {
		
		//基于myFile创建一个文件输入流
		InputStream is = new FileInputStream(myFile);
		
		// 设置上传文件目录
		String uploadPath = ServletActionContext.getServletContext()
				.getRealPath("/upload");
		File file =new File(uploadPath+"/aa");    
		//如果文件夹不存在则创建    
		if (!file.exists() && !file.isDirectory()) {       
				file.mkdir();
		}
		
		// 设置目标文件
		File toFile = new File(uploadPath, "aa/aaa.jpg");
		
		// 创建一个输出流
		OutputStream os = new FileOutputStream(toFile);

		//设置缓存
		byte[] buffer = new byte[1024];

		int length = 0;

		//读取myFile文件输出到toFile文件中
		while ((length = is.read(buffer)) > 0) {
			os.write(buffer, 0, length);
		}
		System.out.println("上传用户"+username);
		System.out.println("上传文件名"+myFileFileName);
		System.out.println("上传文件类型"+myFileContentType);
		//关闭输入流
		is.close();
		
		//关闭输出流
		os.close();
		
		return SUCCESS;
	}
}
