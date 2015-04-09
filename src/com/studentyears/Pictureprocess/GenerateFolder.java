package com.studentyears.Pictureprocess;

import java.io.File;
import java.io.IOException;

public class GenerateFolder {

	public static boolean genFolder(String path){
		File file =new File(path);    
		//如果文件夹不存在则创建    
		if (!file.exists() && !file.isDirectory())      {       
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    return false;
		}else{  
			file.mkdir();    
			return true;
		}  
	}
	
	public static void main(String[] args) {
		System.out.println(GenerateFolder.genFolder(".\\goodsImage\\test1.html"));
	}
}
