package com.studentyears.IpSeeker;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class Test {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		IPSeeker ip1 = new IPSeeker("f:\\QQWry.Dat");
		String ips = "222.195.92.61";
		String ips1 = "124.16.79.189";
		String country;
		String area;
		area = ip1.getAddress(ips);
		//country = ip1.getCountry(ips);
		System.out.println(area);
	}

}
