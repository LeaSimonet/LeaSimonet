package cinemaSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cinemaSpring.entities.Evaluation;
import cinemaSpring.entities.EvaluationKey;

public interface EvaluationRepository extends JpaRepository<Evaluation, EvaluationKey>{

}
