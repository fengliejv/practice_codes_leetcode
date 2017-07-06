package com.ustc.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ustc.javabean.UserBean;

public class RegisterAction {
	public Object login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Object uri = null;

		// 1. 获取请求数据，封装
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		UserBean user = new UserBean();
		
		uri = "success";
		
		return uri;
	}
}