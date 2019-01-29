package applicationevent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationEventTest {

	private static ApplicationContext context;

	public static void main(String[] args) {

		context = new ClassPathXmlApplicationContext("application_event_beans.xml");

		context.publishEvent(new Event(new Object(), "Message 1"));
		context.publishEvent(new Event(new Object(), "Message 2"));
		context.publishEvent(new Event(new Object(), "Message 3"));
		context.publishEvent(new Event(new Object(), "Message 4"));

	}

}
