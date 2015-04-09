package com.studentyears.Pictureprocess;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GetImageSize {

	public BufferedImage sourceImg;
	
	public void setImage(String filepath){
		File picture = new File(filepath);
		try {
			sourceImg =ImageIO.read(new FileInputStream(picture));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public int getWidth(){
		return sourceImg.getWidth();
	}
	
	public int getHeight(){
		return sourceImg.getHeight();
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		File picture = new File("e:/1.png");
		BufferedImage sourceImg =ImageIO.read(new FileInputStream(picture)); 
		System.out.println(String.format("%.1f",picture.length()/1024.0));
		System.out.println(sourceImg.getWidth());
		System.out.println(sourceImg.getHeight());
		
		GetImageSize getImageSize = new GetImageSize();
		getImageSize.setImage("e:/1.png");
		System.out.println(getImageSize.getWidth());
		System.out.println(getImageSize.getHeight());		
	}
}
