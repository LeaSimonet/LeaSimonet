package cinemaJpa.entities;


import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="reservation")

public class Reservation {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="acteur_id")
		private Long id;
		@Column(name="prix",nullable = false)
		private double prix;
		@Column(name="date_resa",nullable = false)
		private LocalDate dateReservation;
	
	
		@ManyToOne
		@JoinColumn(name="reservation_client_id",foreignKey = @ForeignKey(name="reservation_client_id_fk"))
		private Client client;
		
		
		@ManyToOne
		@JoinColumn(name="reservation_seance_id",foreignKey = @ForeignKey(name="reservation_seance_id_fk"))
		private Seance seance;
		
		
		
		public Reservation() {
			
		}
		
	
	public Reservation(double prix, LocalDate dateReservation, Seance seance) {
		this.prix = prix;
		this.dateReservation = dateReservation;
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

	public Seance getSeance() {
		return seance;
	}

	public void setSeance(Seance seance) {
		this.seance = seance;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
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
