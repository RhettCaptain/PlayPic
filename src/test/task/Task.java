package test.task;

import java.io.*;
import java.util.*;

public class Task {
	
    public void deletePic() {  
    	//获取全部图片
    	String rootPath = new File("").getAbsolutePath();
    	File uploadPath = new File(rootPath +"\\WebContent\\upload");
    	File dealPath = new File(rootPath +"\\WebContent\\dealPath");
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
}
