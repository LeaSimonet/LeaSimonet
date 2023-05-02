package cinemaJpa.entities;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



	
@Entity
@Table(name="Acteur")

public class Acteur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="acteur_id")
	private Long id;
	@Column(name="acteur_nom",nullable = false)
	private String nom;
	@Column(name="acteur_prenom",nullable = false)
	private String prenom;
	@Column(name="acteur_nationalite")
	private String nationalite;
	
	
	@ManyToMany
	@JoinTable(
			name="participation",
			joinColumns = @JoinColumn(name="participation_purchase_number",foreignKey = @ForeignKey(name="participation_number_fk")),
			inverseJoinColumns = @JoinColumn(name="participation_product_id",foreignKey = @ForeignKey(name="participation_product_id_fk")))	
	private Set<Film> filmsActeurs;
	
	
	
	public Acteur() {
		
	}

	public Acteur(String nom, String prenom, String nationalite) {
		this.nom = nom;
		this.prenom = prenom;
		this.nationalite = nationalite;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	
	
	

	public Set<Film> getFilmsActeurs() {
		return filmsActeurs;
	}

	public void setFilmsActeurs(Set<Film> filmsActeurs) {
		this.filmsActeurs = filmsActeurs;
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
		Acteur other = (Acteur) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
