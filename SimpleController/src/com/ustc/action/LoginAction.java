package com.ustc.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ustc.javabean.UserBean;
import com.ustc.DAO.UserDAO;

public class LoginAction implements Login{	
	public Object login(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub		
		Object uri = null;
		boolean flag = false;
		// 1. 获取请求数据，封装
		String name = request.getParameter("uname");
		String password = request.getParameter("upass");
		UserBean user = null;		
		UserDAO userDao = new UserDAO();
		user = userDao.queryUser(name);
		userDao.closeDBConnection();
	    if(user!=null){
	    	if(password.equals(user.getPassword())){
	    		flag = true;
	    	}else{
	    		flag = false;
	    	}
	    }else{
	    	flag = false;
	    }	
//		boolean flag = user.check(name,password);
		if (flag) {
			uri = "success";  
		} else {
			uri = "fail"; 
		}
		return uri;
	}

}
