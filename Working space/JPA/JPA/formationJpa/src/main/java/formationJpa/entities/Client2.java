package formationJpa.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("C")

public class Client2 extends Personne{
	
	private String prenom;
	
	
	public Client2 () {
		
	}
	
	public Client2 (String nom, Adresse adresse, String prenom) {
		super(nom, adresse);
		this.prenom = prenom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	

}
