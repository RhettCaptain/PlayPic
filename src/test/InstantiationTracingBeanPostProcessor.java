package test;

import org.opencv.core.Core;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class InstantiationTracingBeanPostProcessor implements ApplicationListener<ContextRefreshedEvent>{

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// TODO �Զ����ɵķ������
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);  
	    System.out.println("######## Opencv������� ########");  
	}

}
