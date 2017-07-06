package com.ustc.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Login {
	public Object login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
}
