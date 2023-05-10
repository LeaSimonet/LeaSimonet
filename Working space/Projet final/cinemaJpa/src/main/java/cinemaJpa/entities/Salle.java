package cinemaJpa.entities;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="Salle")

public class Salle {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="acteur_id")
		private Long id;
		@Column(name="acteur_nom",nullable = false)
		private String nom;
		@Column(name="places",nullable = false)
		private int places;
	
		
		
		public Salle() {
			
		}
	
	
	public Salle(String nom, int places) {
		this.nom = nom;
		this.places = places;
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

	public int getPlaces() {
		return places;
	}

	public void setPlaces(int places) {
		this.places = places;
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
		Salle other = (Salle) obj;
		return Objects.equals(id, other.id);
	}

	

	
	
}
