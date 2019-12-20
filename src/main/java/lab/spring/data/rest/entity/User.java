package lab.spring.data.rest.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name = "UserName")
	private String userName;
	@Column(name = "FullName")
	private String fullName;

	/*
	 * @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name = "LoginID") private Login login;
	 */

	public User() {

	}

	public User(String userName, String fullName) {
		this.userName = userName;
		this.fullName = fullName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/*
	 * public Login getLogin() { return login; }
	 * 
	 * public void setLogin(Login login) { this.login = login; }
	 */

}
