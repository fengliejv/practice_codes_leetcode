package com.ustc.interceptor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ustc.javabean.ActionBean;

public class LogWriter implements InvocationHandler{  
	  // 可以写作配置：true写文件; false输出控制台  
	  private static boolean fileLog = true;  
	  private static String logFileName = "G://eclipseWorkPlace//SimpleController//src//log.xml";
	  Object target;
	  ActionBean actionbean;
	  
	  File file = new File(logFileName);
	  StringBuilder sb = new StringBuilder(); 
	  
	  public LogWriter(ActionBean actionbean, Object actionObj) {
		 this.actionbean = actionbean;
		 this.target = actionObj;
		 if (!file.exists())
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	  }
	
	  
	  public void log(ActionBean action) throws IOException {  
		  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	      sb.append("<?xml version='1.0' encoding='UTF-8'?>\r\n");  
	      sb.append("<log>\r\n");  
	      sb.append("    <action>\r\n");  
	      sb.append("         <name>"+action.getActionname()+"</name>\r\n");
	      sb.append("         <s-time>"+df.format(new Date())+"</s-time>\r\n");
	  }  
	  
	  
	  public void log(String result) throws IOException {  
		  OutputStream out = new FileOutputStream(file);
		  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  sb.append("         <e-time>"+df.format(new Date())+"</e-time>\r\n");  
	      sb.append("         <result>"+result+"</result>\r\n");  
	      sb.append("    </action>\r\n");    
	      sb.append("</log>\r\n"); 
	      out.write(sb.toString().getBytes("utf-8"));  
	  }  

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		log(actionbean);
		String result=(String) method.invoke(target,args[0],args[1]);
		log(result);
		return result;
	}  
	}  
