package formationJpa.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass // C'est pas une table mais on veut lui donner des indications et ce sera interpréter par des descendants. 

public abstract class Personne {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private long id;

	private String nom;
	
	private Adresse adresse;
	
	public Personne () {
		
	}

	public Personne(String nom, Adresse adresse) {
		this.nom = nom;
		this.adresse = adresse;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	

}
