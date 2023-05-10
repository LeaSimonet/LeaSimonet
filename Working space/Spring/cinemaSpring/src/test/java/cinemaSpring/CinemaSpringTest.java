package cinemaSpring;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import cinemaSpring.config.JpaConfig;
import cinemaSpring.entities.Salle;
import cinemaSpring.repositories.DaoSalle;

@SpringJUnitConfig(JpaConfig.class)

public class CinemaSpringTest {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Autowired
	private DaoSalle daoSalle;
	
	
	@Test
	void dataSourceTest() {
		assertNotNull(dataSource);
		assertNotNull(entityManagerFactory);
		assertNotNull(daoSalle);
		
	
	}

}
