package cinemaJpa.entities;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="Reservation")

public class Reservation {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="acteur_id")
		private Long id;
		@Column(name="prix",nullable = false)
		private double prix;
		@Column(name="date_resa",nullable = false)
		private LocalDate dateReservation;
	
		@Transient
		private List<Spectateur> spectateurs = new ArrayList();
		
		@Transient
		private Client client;
		
		
		@Transient
		private Seance seance;
		
		
		
		public Reservation() {
			
		}
		
	
	public Reservation(double prix, LocalDate dateReservation, Client client, Seance seance) {
		this.prix = prix;
		this.dateReservation = dateReservation;
		this.client = client;
		this.seance = seance;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public LocalDate getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(LocalDate dateReservation) {
		this.dateReservation = dateReservation;
	}

	public List<Spectateur> getSpectateurs() {
		return spectateurs;
	}

	public void setSpectateurs(List<Spectateur> spec) {
		this.spectateurs = spec;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Seance getSeance() {
		return seance;
	}

	public void setSeance(Seance seance) {
		this.seance = seance;
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
		Reservation other = (Reservation) obj;
		return Objects.equals(id, other.id);
	}


	
	
	
	
	
}
