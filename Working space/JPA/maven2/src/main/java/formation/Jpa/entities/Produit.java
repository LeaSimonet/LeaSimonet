package formation.Jpa.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//POGO donc contructeur sans rien

//Les annotations pour faire le lien avec la base. 


@Entity // associer la classe Produit à une table mais quelle table ? Attention, à besoin de la clé primaire. 
@Table(name="product") // Attend une proprité : name =nom de la table que l'on souhaite associé de la table produit. Peut importe le nom mais doit être cohérent. Techniquement on eut metre des nom différent.  

public class Produit {
	
	@Id   // clé primaire
	@Column (name="product_id") // définit le nom de mes colonnes 
	private long id; // comment différencier 0 de "j'ai initialisé l'entier de 0 j'ai mis un 0 dans ma variable => impossible. 0 c'est le chiffre. On peut pas savoir quel cas c'est. 
	// Le principe de la classe Integer : permet de gérer un nombre entier. Mais sa valeur par défaut est nulle. DOnc on peut distiguer le j'"ai rien mis du 0
	// Pour gérer des clés, on va justment gérer les 0. 
	// Ici on préfèrera le long qui a une plus grande capacité que le int. 
	
	@Column (name="product_name")
	private String nom;
	
	@Column (name="product_description")
	private String description;
	
	@Column (name="product_price") // nullable : est ce que la table peut prendre une vaeur nulle ou non. 
	private double prix;
	
	public Produit () {
		
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
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
		Produit other = (Produit) obj;
		return id == other.id;
	}
	

}
