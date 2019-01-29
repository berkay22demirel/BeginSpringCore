package lifecycle;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;

public class BeanDestructionWriter implements DisposableBean {

	private String property;

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public void destroy() throws Exception {

		System.out.println("-----------> destroy -");
	}

	@PreDestroy
	public void preDestroyTestMethod() {

		System.out.println("-----------> preDestroyTestMethod -");
	}

	public void testDestroyMethod() {

		System.out.println("-----------> testDestroyMethod -");
	}

	@Override
	public String toString() {
		return "BeanDestructionWriter [property=" + property + "]";
	}

}
