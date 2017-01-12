package test.task;

import java.io.*;
import java.util.*;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;

public class Task implements ServletContextAware{
	private ServletContext serCont;
    public void deletePic() {  
    	//获取全部图片
    	String rootPath = serCont.getRealPath("/");
    	File uploadPath = new File(rootPath +"upload");
    	File dealPath = new File(rootPath +"dealPath");
    	String[] uploadPics = uploadPath.list();
    	String[] dealPics = dealPath.list();
    	//获取当前分钟数
    	Calendar cal = Calendar.getInstance();
    	int curMinute = cal.get(Calendar.MINUTE);
    	//超过dropMinute的图片则删除
    	int dropMinute = 5;
    	for(String path:uploadPics){
    		File f = new File(uploadPath.getPath() + "\\" + path);
    		long picTime = f.lastModified();
    		cal.setTimeInMillis(picTime);
    		int picMinute = cal.get(Calendar.MINUTE);
    		//计算相差的时间
    		int delMinute = curMinute - picMinute;
    		if(delMinute < 0){
    			delMinute += 60;	//相差时间应当为正
    		}
    		if(delMinute > dropMinute){
    			f.delete();
    		}
    	}
    	for(String path:dealPics){
    		File f = new File(uploadPath.getPath() + "\\" + path);
    		long picTime = f.lastModified();
    		cal.setTimeInMillis(picTime);
    		int picMinute = cal.get(Calendar.MINUTE);
    		//计算相差的时间
    		int delMinute = curMinute - picMinute;
    		if(delMinute < 0){
    			delMinute += 60;	//相差时间应当为正
    		}
    		if(delMinute > dropMinute){
    			f.delete();
    		}
    	}
    } 
    
    public static void main(String[] args){
    	Task ttt = new Task();
    	ttt.deletePic();
    }

	@Override
	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		serCont = arg0;
	}
}
