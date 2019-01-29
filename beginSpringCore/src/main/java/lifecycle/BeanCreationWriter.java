package lifecycle;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;

public class BeanCreationWriter implements InitializingBean {

	private String property;

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public void afterPropertiesSet() throws Exception {

		System.out.println("-----------> afterPropertiesSet -");
	}

	@PostConstruct
	public void postConstructTestMethod() {

		System.out.println("-----------> postConstructTestMethod -");
	}

	public void initTestMethod() {

		System.out.println("-----------> initTestMethod -");
	}

	@Override
	public String toString() {
		return "BeanCreationWriter [property=" + property + "]";
	}

}
