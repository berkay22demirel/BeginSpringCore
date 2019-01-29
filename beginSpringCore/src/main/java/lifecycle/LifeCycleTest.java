package lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleTest {
	
	private static ApplicationContext context;

	public static void main(String[] args) {

		context = new ClassPathXmlApplicationContext("lifecycle.xml");

		AwarenessWriter awarenessWriter = context.getBean("awarenessWriter", AwarenessWriter.class);
		System.out.println(awarenessWriter);
		
		BeanCreationWriter creationWriter = context.getBean("creationWriter", BeanCreationWriter.class);
		System.out.println(creationWriter);
		
		BeanDestructionWriter destructionWriter = context.getBean("destructionWriter", BeanDestructionWriter.class);
		System.out.println(destructionWriter);

		((ClassPathXmlApplicationContext) context).close();

	}

}
