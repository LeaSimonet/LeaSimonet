package Jpa.entities;

@Entity 

@Table(name="adresse") 

public class Adresse {
	
	
			@Id  
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			@Column (name="product_id") 
			private long id; 
			
			@Column (name="film_titre", nullable=false)
			private String nom;
			
			@Column (name="sortie")
			private LocalDate sortie;
			
			@Column (name="duree") 
			private LocalTime duree;
			
			@Column (name="dispo") 
			private boolean dispo;
			
			@Column (name="categorie")
			@Enumerated(EnumType.STRING)
			private Categorie categorie;
			
			//@Transient 
			@Embedded
			@AttributeOverrides({
				@AttributeOverride(name="numero", column=@Column(name="customer_number", length=50)),
				@AttributeOverride(name="rue", column=@Column(name="customer_street")),
				@AttributeOverride(name="codePostal", column=@Column(name="customer_zip", length=50)), 
				@AttributeOverride(name="ville", column=@Column(name="customer_city")) 
				
			})
			private Adresse adresse;
			
			
			public Film () {
				
			}
			
			public Film(String nom, LocalDate sortie, LocalTime duree, boolean dispo, Categorie categorie) {
				this.nom = nom;
				this.sortie = sortie;
				this.duree = duree;
				this.dispo = dispo;
				this.categorie = categorie;
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

			public LocalDate getSortie() {
				return sortie;
			}

			public void setSortie(LocalDate sortie) {
				this.sortie = sortie;
			}

			public LocalTime getDuree() {
				return duree;
			}

			public void setDuree(LocalTime duree) {
				this.duree = duree;
			}

			public boolean isDispo() {
				return dispo;
			}

			public void setDispo(boolean dispo) {
				this.dispo = dispo;
			}

			public Categorie getCategorie() {
				return categorie;
			}

			public void setCategorie(Categorie categorie) {
				this.categorie = categorie;
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
				Film other = (Film) obj;
				return id == other.id;
			}

			

	



}
