package lab.spring.data.rest.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.spring.data.rest.dao.LoginDAO;
import lab.spring.data.rest.dao.UserDAO;
import lab.spring.data.rest.entity.Login;
import lab.spring.data.rest.entity.User;

@Service
public class UserService {
	@Autowired
	private UserDAO userDao;

	@Autowired
	private LoginDAO loginDao;

	@Transactional
	public void createuser() {
		try {
			User user = new User("harihana.r@isteer.com", "hariharan");
			Login login = new Login("admin");

			User u = userDao.save(user);

			login.setUser(u);
			////////////////////////////////
			System.out.println(u.getId());
			loginDao.save(login);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
