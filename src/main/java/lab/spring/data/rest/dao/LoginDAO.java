package lab.spring.data.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lab.spring.data.rest.entity.Login;

public interface LoginDAO extends JpaRepository<Login, Integer> {

}
