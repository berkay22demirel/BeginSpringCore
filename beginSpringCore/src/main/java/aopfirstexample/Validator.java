package aopfirstexample;

public class Validator {

	public void validateAge(int age) throws Exception {
		if (age < 0) {
			throw new ArithmeticException("Not Valid Age");
		} else {
			System.out.println("It is valid age!");
		}
	}

}
