package lab.spring.data.rest.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import lab.spring.data.rest.entity.Person;

public interface PersonDAO extends CrudRepository<Person, Integer> {

	public Person findByFirstNameIgnoreCase(String firstName);

	public Person readByFirstNameOrLastName(String firstName, String lastName);

	public Person getTopByCountry(String country);

	public Iterable<Person> getByCountry(String country);

	// Enabling static ORDER BY for a query
	List<Person> findByLastNameOrderByFirstNameAsc(String lastname);

	List<Person> findByLastNameOrderByFirstNameDesc(String lastname);

	List<Person> hari(String lastName);

	/// @Query() implementation
	@Query("Select p from Person p WHERE p.lastName=?1")
	List<Person> harishWith(String lastName);

	@Query("Select p from Person p WHERE p.lastName LIKE %?1")
	List<Person> loadHarish(String lastName);

	List<Person> findByCountry(String lastName, Pageable req);

	@Transactional
	@Modifying
	@Query(value = "UPDATE Person SET lastName=:name WHERE id=:identifyNumber")
	public void updatePersonLastNameById(@Param("name") String lastName, @Param("identifyNumber") int id);
}
