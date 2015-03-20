package com.studentyears.Utils;

public class StringUtils {

	public static String [] splitStrings(String arg)
	{
		String [] tempsStrings = arg.split(" ");
		if (tempsStrings.length < 2) {
			tempsStrings = new String[2];
			tempsStrings[0] = "本地地址";
			tempsStrings[1] = "二级";
		}
		return tempsStrings;
	}
}
