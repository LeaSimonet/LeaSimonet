package cinemaJpa;

import java.time.LocalDate;

import cinemaJpa.entities.Reservation;
import cinemaJpa.repositories.DaoReservation;
import cinemaJpa.repositories.JpaContext;

public class AppTest {
	public static void main(String[] args) {
		DaoReservation daoReservation =JpaContext.getDaoReservation();
		Reservation resa1 =new Reservation(50, LocalDate.parse("2023-03-21"), null);
		daoReservation.insert(resa1);
		
		Reservation reservationEnBase=daoReservation.findByKey(resa1.getId());
		
		
		System.out.println(reservationEnBase.getPrix());
		

		
		
	}
}
