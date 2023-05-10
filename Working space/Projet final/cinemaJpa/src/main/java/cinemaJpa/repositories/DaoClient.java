package cinemaJpa.repositories;

import java.util.List;

import cinemaJpa.entities.Client;

public interface DaoClient extends DaoGeneric<Client, Long>{
	public List<Client> findMajor( );
	public List<Client> findMineur( );
	public List<Client> findSenior( );

}
