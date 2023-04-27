package formationJpa.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="person")
@Inheritance(strategy =InheritanceType.SINGLE_TABLE) // On utilisera toujours cette inheritance. 
@DiscriminatorColumn(name="type", discriminatorType = DiscriminatorType.STRING, length=1)

public abstract class Personne {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="personne_id")
	private long id;
	

	@Column(name="nom")
	private String nom;
	
	@Embadded
	@AttributeOverrides({
		@AttributeOverride(name="numero", column=@Column(name="person-number", length=50)),
		@AttributeOverride(name="rue", column=@Column(name="person-street")),
		@AttributeOverride(name="codePostal", column=@Column(name="person-zip", length=50)),
		@AttributeOverride(name="ville", column=@Column(name="person-ville")),
	})
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
