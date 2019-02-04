package aspectjxml;

import java.util.List;

public class PersonService {

	public void savePerson() {

		System.out.println("savePerson is invoked...");

	}

	public void updatePerson() {

		System.out.println("updatePerson is invoked...");
	}

	public String getPersonId() {

		System.out.println("getPersonId is invoked...");

		return "getPersonId";
	}

	public void deletePerson() {

		System.out.println("deletePerson is invoked...");

		throw new RuntimeException();
	}

	public List<Object> getAllPersons() {

		System.out.println("getAllPersons is invoked...");

		return null;
	}

}
