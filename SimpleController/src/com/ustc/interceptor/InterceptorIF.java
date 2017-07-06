package com.ustc.interceptor;

import com.ustc.javabean.ActionBean;

public interface InterceptorIF {
	 void before(ActionBean action);
	 void after(String result);
}
