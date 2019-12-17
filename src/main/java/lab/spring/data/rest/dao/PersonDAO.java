package lab.spring.data.rest.dao;

import org.springframework.data.repository.CrudRepository;

import lab.spring.data.rest.entity.Person;

public interface PersonDAO extends CrudRepository<Person, Integer> {

}
