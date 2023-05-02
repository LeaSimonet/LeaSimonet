package cinemaJpa.entities;

import java.util.Objects;
import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "evaluation")

	public class Evaluation {

			@EmbeddedId
			private EvaluationKey id;
			
			private int note;
			private Long commentaire;
			
			

			public Evaluation() {

			}

			public Evaluation(EvaluationKey id,int note, Long commentaire) {
				super();
				this.id = id;
				this.note=note;
				this.commentaire=commentaire;
			}

			public EvaluationKey getId() {
				return id;
			}

			public void setId(EvaluationKey id) {
				this.id = id;
			}

			public int getNote() {
				return note;
			}

			public void setNote(int note) {
				this.note = note;
			}

			public Long getCommentaire() {
				return commentaire;
			}

			public void setCommentaire(Long commentaire) {
				this.commentaire = commentaire;
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
				Evaluation other = (Evaluation) obj;
				return Objects.equals(id, other.id);
			}
	
	
	

	
}
