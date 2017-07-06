package com.ustc.javabean;

import java.util.Map;

public class ActionBean {
	private String actionname;	
	private String className;	
	private String method;	
	private String inter_refName;
	private Map<String, ResultBean> results;
	
	public String getActionname() {
		return actionname;
	}
	public void setActionname(String actionname) {
		this.actionname = actionname;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public Map<String, ResultBean> getResults() {
		return results;
	}
	public void setResults(Map<String, ResultBean> results) {
		this.results = results;
	}
	public String getInter_refName() {
		return inter_refName;
	}
	public void setInter_refName(String inter_refName) {
		this.inter_refName = inter_refName;
	}
}
