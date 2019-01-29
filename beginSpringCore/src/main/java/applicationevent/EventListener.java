package applicationevent;

import org.springframework.context.ApplicationListener;

public class EventListener implements ApplicationListener<Event> {

	public void onApplicationEvent(Event event) {
		
		Event messageEvent = (Event) event;
		System.out.println("Message Received : " + messageEvent.getMessage());
	}

}
