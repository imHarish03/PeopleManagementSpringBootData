package lab.spring.data.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "person")
@DynamicUpdate

@NamedQueries(value = { @NamedQuery(name = "Person.hari", query = "SELECT p FROM Person p WHERE p.lastName=?1") })

public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	@Column(name = "FirstName")
	private String firstName;
	@Column(name = "Country")
	private String country;
	@Column(name = "LastName")
	private String lastName;

	public Person() {

	}

	public Person(String firstName, String lastName, String country) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", country=" + country + ", lastName=" + lastName
				+ "]";
	}

}
