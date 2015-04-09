package com.studentyears.Utils;

import java.io.FileNotFoundException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.studentyears.IpSeeker.IPSeeker;

public class NetworkUtils {
	
	public static String getAddress()
	{
		String ipString = getIpAddr(ServletActionContext.getRequest());
		String ipresource = ServletActionContext.getServletContext().getRealPath("/ipresource");
		IPSeeker ipSeeker = null;
		try {
			ipSeeker = new IPSeeker(ipresource+"/QQWry.Dat");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ipSeeker.getAddress(ipString);
	}
	
	public static String getIpAddr(HttpServletRequest request) {
	     String ip = request.getHeader("x-forwarded-for");
	     if(null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
	         ip = request.getHeader("Proxy-Client-IP");
	     }
	     if(null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
	         ip = request.getHeader("WL-Proxy-Client-IP");
	     }
	     if(null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
	         ip = request.getHeader("X-Real-IP");
	     }
	     if(null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
	         ip = request.getRemoteAddr();
	     }
	     return ip;
		}
}
