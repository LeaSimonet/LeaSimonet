package cinemaSpring.repositories;

import java.util.List;

import cinemaSpring.entities.Admin;
import cinemaSpring.entities.Client;
import cinemaSpring.entities.Compte;

public interface DaoCompte extends DaoGeneric<Compte, Long> {
	public List<Client> findAllClient();

	public List<Admin> findAllAdmin();
}
