package test.task;

import java.io.*;
import java.util.*;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;

public class Task implements ServletContextAware{
	private ServletContext serCont;
    public void deletePic() {  
    	//��ȡȫ��ͼƬ
    	String rootPath = serCont.getRealPath("/");
    	File uploadPath = new File(rootPath +"upload");
    	File dealPath = new File(rootPath +"dealPath");
    	String[] uploadPics = uploadPath.list();
    	String[] dealPics = dealPath.list();
    	//��ȡ��ǰ������
    	Calendar cal = Calendar.getInstance();
    	int curMinute = cal.get(Calendar.MINUTE);
    	//����dropMinute��ͼƬ��ɾ��
    	int dropMinute = 5;
    	for(String path:uploadPics){
    		File f = new File(uploadPath.getPath() + "\\" + path);
    		long picTime = f.lastModified();
    		cal.setTimeInMillis(picTime);
    		int picMinute = cal.get(Calendar.MINUTE);
    		//��������ʱ��
    		int delMinute = curMinute - picMinute;
    		if(delMinute < 0){
    			delMinute += 60;	//���ʱ��Ӧ��Ϊ��
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
    		//��������ʱ��
    		int delMinute = curMinute - picMinute;
    		if(delMinute < 0){
    			delMinute += 60;	//���ʱ��Ӧ��Ϊ��
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
