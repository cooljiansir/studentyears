package com.studentyears.Utils;

public class ImageFolderUtils {

	public static String genOrderImageFolderBase(String user, String order)
	{
		return Constant.UPLOAD_IMAGE_FOLDER+"/"+user+"/"+order;
	}
}
