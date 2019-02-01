package programmatictransaction;


public interface PersonDAO {

	public void insert(Person2 person);

	public void insertAddress(Address address);

	public void updatePersonAddress(int id, int addressId);

}
