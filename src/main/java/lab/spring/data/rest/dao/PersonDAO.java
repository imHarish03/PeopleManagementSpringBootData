package lab.spring.data.rest.dao;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.repository.CrudRepository;

import lab.spring.data.rest.entity.Person;

public interface PersonDAO extends CrudRepository<Person, Integer> {

	public Person findByFirstNameIgnoreCase(String firstName);

	public Person readByFirstNameOrLastName(String firstName, String lastName);

	public Person getTopByCountry(String country);

	public Iterable<Person> getByCountry(String country, Pageable pageable);

	// Enabling static ORDER BY for a query
	List<Person> findByLastNameOrderByFirstNameAsc(String lastname);

	List<Person> findByLastNameOrderByFirstNameDesc(String lastname);
}
