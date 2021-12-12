package utils;

import javax.servlet.jsp.JspWriter;

public class JSFunction {
	
	public static void alertLocation(String msg, String url, JspWriter out) {
		try {
			String script = "" 
						+ "<script>"
						+ "     alert('" + msg + "');" 
						+ "     location.href='"+url+"';"
						+ "</script>";
			out.println(script); //스크립트 문자열을 웹브라우저에 출력한다.
		} 
		catch (Exception e) {}
	}
	
	public static void alertBack (String msg, JspWriter out) {
		try {
			String script = "" 
						+ "<script>"
						+ "     alert('" + msg + "');"
						+ "     history.back();"
						+ "</script>";
			out.println(script);
		} 
		catch (Exception e) {}
	}
}
