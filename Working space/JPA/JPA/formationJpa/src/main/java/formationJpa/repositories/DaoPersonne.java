package formationJpa.repositories;

import java.util.List;

import formationJpa.entities.Client2;
import formationJpa.entities.Fournisseur;
import formationJpa.entities.Personne;

public interface DaoPersonne extends DaoGeneric<Personne, Long>{
	public List<Client2> findAllClient();
	public List<Fournisseur> findAllFournisseur();

}
