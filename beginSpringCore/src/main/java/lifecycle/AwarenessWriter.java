package lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class AwarenessWriter implements BeanNameAware,
		BeanClassLoaderAware, ApplicationContextAware {

	private String beanName;

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {

		System.out.println("-----------> setApplicationContext - " + applicationContext.getDisplayName());
	}

	public void setBeanClassLoader(ClassLoader classLoader) {

		System.out.println("-----------> setBeanClassLoader - " + classLoader.getClass());
	}

	public void setBeanName(String arg0) {

		beanName = beanName;
		System.out.println("-----------> setBeanName -");
	}

}
