package programmatictransaction;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class PersonDAOImpl implements PersonDAO {

	private static final String INSERT_PERSON = "INSERT INTO person(name, surname, age) VALUES (:name,:surname,:age)";
	private static final String INSERT_ADDRESS = "INSERT INTO address(province,district) VALUES (:province,:district)";
	private static final String UPDATE = "UPDATE person SET addressId = :addressId WHERE id = :id";
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private PlatformTransactionManager transactionManager;

	public void setDataSource(DataSource dataSource) {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public void setTransactionManager(
			PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	private TransactionStatus getTransactionStatus() {
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager
				.getTransaction(transactionDefinition);
		return status;
	}

	public void insert(Person2 person) {
		
		TransactionStatus status = getTransactionStatus();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", person.getName());
		params.put("surname", person.getSurname());
		params.put("age", person.getAge());
		try {

			namedParameterJdbcTemplate.update(INSERT_PERSON, params);
			System.out.println("Person is inserted... " + person);

			insertAddress(person.getAddress());
			updatePersonAddress(person.getId(), person.getAddress().getAddressId());
			System.out.println("Address is inserted... " + person);

			transactionManager.commit(status);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("rollback...");
			transactionManager.rollback(status);
		}

	}

	public void insertAddress(Address address) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("province", address.getProvince());
		params.put("district", address.getDistrict());
		namedParameterJdbcTemplate.update(INSERT_ADDRESS, params);

	}

	public void updatePersonAddress(int id, int addressId) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		params.put("addressId", addressId);
		namedParameterJdbcTemplate.update(UPDATE, params);
		
	}

}
