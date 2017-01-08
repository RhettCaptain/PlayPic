package test;

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
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// TODO 自动生成的方法存根
		String path = servletContext.getRealPath("/");
		
		System.load(path+"WEB-INF\\lib\\"+Core.NATIVE_LIBRARY_NAME+".dll");  
	    System.out.println("######## Opencv加载完毕 ########");  
		
	}

	@Override
	public void setServletContext(ServletContext arg0) {
		// TODO 自动生成的方法存根
		servletContext=arg0;
	}

}
