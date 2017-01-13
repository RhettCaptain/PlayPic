package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.HashMap;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Filters extends ActionSupport{
	private HashMap<String, String> filters;

	public HashMap<String, String> getFilters() {
		return filters;
	}

	public void setFilters(HashMap<String, String> filters) {
		this.filters = filters;
	}
	
	public String execute() throws Exception
	{
		ActionContext.getContext().put("filterList", getFilters());		
		return SUCCESS;  
	}
	
}
