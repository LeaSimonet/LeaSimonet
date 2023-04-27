package cinemaJpa.entities;

public class Admin extends Compte{

	public Admin(Integer id, String login, String password,String email) {
		super(login, password,email);
	}
	
	public Admin(String login, String password,String email) {
		super(login, password,email);
	}

	
	
}