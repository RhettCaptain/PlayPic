package test;

import java.util.HashMap;

import javax.servlet.ServletContext;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.context.ServletContextAware;

public class InstantiationTracingBeanPostProcessor implements ServletContextAware, ApplicationListener<ContextRefreshedEvent> {
	private ServletContext servletContext;
	private HashMap<String, String> filters;

	public HashMap<String, String> getFilters() {
		return filters;
	}

	public void setFilters(HashMap<String, String> filters) {
		this.filters = filters;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// TODO �Զ����ɵķ������
		String path = servletContext.getRealPath("/");
		servletContext.setAttribute("filterList", getFilters());
		try{
			System.load(path+"WEB-INF\\lib\\"+Core.NATIVE_LIBRARY_NAME+".dll");  
		}
		catch(Throwable e)//��ֹ��ε��ñ��쳣
		{
			
		}
	    System.out.println("######## Opencv������� ########");  
		
	}

	@Override
	public void setServletContext(ServletContext arg0) {
		// TODO �Զ����ɵķ������
		servletContext=arg0;
	}

}
