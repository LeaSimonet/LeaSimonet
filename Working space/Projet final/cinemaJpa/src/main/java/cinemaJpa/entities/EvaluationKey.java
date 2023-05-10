package cinemaJpa.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Embeddable

public class EvaluationKey implements Serializable{
	
		@ManyToOne
		@JoinColumn(name="evaluation_film_id",foreignKey = @ForeignKey(name="evaluationfilm_id_FK"))
		private Film film;
		@ManyToOne
		@JoinColumn(name="evaluation_client_id",foreignKey = @ForeignKey(name="evaluation_clientt_id_FK"))
		private Client client;

		public EvaluationKey() {

		}

		public EvaluationKey(Film film, Client client) {
			super();
			this.film = film;
			this.client = client;
		}

		public Film getFilm() {
			return film;
		}

		public void setFilm(Film film) {
			this.film = film;
		}

		public Client getClient() {
			return client;
		}

		public void setClient(Client client) {
			this.client = client;
		}

		@Override
		public int hashCode() {
			return Objects.hash(client, film);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			EvaluationKey other = (EvaluationKey) obj;
			return Objects.equals(client, other.client) && Objects.equals(film, other.film);
		}
		
		
		
		

}
