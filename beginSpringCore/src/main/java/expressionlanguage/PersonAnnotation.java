package expressionlanguage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("personAnnotation")
public class PersonAnnotation {

	@Value("#{configAnnotation.name}")
	private String name;
	@Value("#{configAnnotation.surname}")
	private String surname;
	@Value("#{configAnnotation.age}")
	private int age;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "PersonAnnotation [name=" + name + ", surname=" + surname
				+ ", age=" + age + "]";
	}

}
