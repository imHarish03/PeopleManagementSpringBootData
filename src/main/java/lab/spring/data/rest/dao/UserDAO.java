package lab.spring.data.rest.dao;

import org.springframework.data.repository.CrudRepository;

import lab.spring.data.rest.entity.User;

public interface UserDAO extends CrudRepository<User, Integer> {

}
