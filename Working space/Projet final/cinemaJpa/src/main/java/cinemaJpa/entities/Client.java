package cinemaJpa.entities;


import java.time.LocalDate;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="client")


public class Client extends Compte {
	
		
		@Column(name="client_last_name")
		private String nom;
		@Column(name="client_first_name")
		private String prenom;
		@Column(name="client_phone")
		private String telephone;
		@Column(name="client_birth")
		private LocalDate naissance;
		
		@Embedded
		@AttributeOverrides({
			@AttributeOverride(name = "numero",column = @Column(name="client_number",length = 50)),
			@AttributeOverride(name="voie",column = @Column(name="client_voie")),
			@AttributeOverride(name="ville",column = @Column(name="client_ville",length = 50)),
			@AttributeOverride(name="cp",column = @Column(name="client_cp"))
		})
		private Adresse adresse;
		
		@OneToMany(mappedBy = "client")
		private Set<Reservation> resaDuClient;
		

		@OneToMany(mappedBy = "client")
		private Set<Evaluation> evaluations;
		
		public Client() {
			
		}

		public Client(String login, String password, String email, String nom, String prenom, String telephone,
				LocalDate naissance, Adresse adresse) {
			super(login, password,email);
			this.nom = nom;
			this.prenom = prenom;
			this.telephone = telephone;
			this.naissance = naissance;
			this.adresse = adresse;
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

		public String getTelephone() {
			return telephone;
		}

		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}

		public LocalDate getNaissance() {
			return naissance;
		}

		public void setNaissance(LocalDate naissance) {
			this.naissance = naissance;
		}

		public Adresse getAdresse() {
			return adresse;
		}

		public void setAdresse(Adresse adresse) {
			this.adresse = adresse;
		}

		public Set<Reservation> getResaDuClient() {
			return resaDuClient;
		}

		public void setResaDuClient(Set<Reservation> resaDuClient) {
			this.resaDuClient = resaDuClient;
		}

		public Set<Evaluation> getEvaluations() {
			return evaluations;
		}

		public void setEvaluations(Set<Evaluation> evaluations) {
			this.evaluations = evaluations;
		}


		
		


}
