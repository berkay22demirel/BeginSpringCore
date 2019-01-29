package autowiringAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Person {

	private String name;
	private String surname;
	private Job job;
	private Address address;

	@Autowired
	public Person(Job job) {
		super();
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Job getJob() {
		return job;
	}


	public void setJob(Job job) {
		this.job = job;
	}

	public Address getAddress() {
		return address;
	}

	@Autowired
	@Qualifier(value = "defaultAddress")
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", surname=" + surname + ", job=" + job
				+ ", address=" + address + "]";
	}

}
