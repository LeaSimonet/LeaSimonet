package soprasteria.formation.eshop.entities;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class Compte implements UserDetails{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="account")
	private Integer id;
	@Column(name = "account", unique = true, nullable = false, length = 200)
	private String username;
	@Column(name = "account", nullable = false, length = 255)
	private String password;
	@Enumerated(EnumType.STRING)
	@Column(name="account")
	private Role role;
	@OneToOne(mappedBy = "compte")
	private Client client;
	
	
	public Compte() {
		super();
	}


	public Compte(Integer id, String username, String password, Role role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}


	public Compte(String username, String password, Role role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	


	public Compte(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	
	
	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
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
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return Arrays.asList(new SimpleGrantedAuthority(role.toString()));
	}


	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	
	
}
