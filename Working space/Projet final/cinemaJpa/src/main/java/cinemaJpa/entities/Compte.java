package cinemaJpa.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Compte")


public class Compte {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="acteur_id")
	private Long id;
	@Column(name="login")
	private String login;
	@Column(name="password")
	private String password;
	@Column(name="email")
	private String email;
	
	public Compte() {
		
	}


	public Compte(String login, String password,String email) {
		this.login = login;
		this.password = password;
		this.email=email;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compte other = (Compte) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
}
