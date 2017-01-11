package test.task;

import java.io.*;
import java.util.*;

public class Task {
	
    public void deletePic() {  
    	//��ȡȫ��ͼƬ
    	String rootPath = new File("").getAbsolutePath();
    	File uploadPath = new File(rootPath +"\\WebContent\\upload");
    	File dealPath = new File(rootPath +"\\WebContent\\dealPath");
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
}
