package applicationevent;

import org.springframework.context.ApplicationEvent;

public class Event extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	private String message;

	public Event(Object source, String message) {

		super(source);
		System.out.println("Start Constructor");
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Event [message=" + message + "]";
	}

}
