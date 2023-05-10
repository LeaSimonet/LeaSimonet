package cinemaJpa;

import java.time.LocalDate;
import java.time.LocalTime;

import cinemaJpa.entities.Acteur;
import cinemaJpa.entities.Admin;
import cinemaJpa.entities.Adresse;
import cinemaJpa.entities.Categorie;
import cinemaJpa.entities.Client;
import cinemaJpa.entities.Evaluation;
import cinemaJpa.entities.EvaluationKey;
import cinemaJpa.entities.Film;
import cinemaJpa.entities.Langue;
import cinemaJpa.entities.Reservation;
import cinemaJpa.entities.Salle;
import cinemaJpa.entities.Seance;
import cinemaJpa.repositories.DaoActeur;
import cinemaJpa.repositories.DaoAdmin;
import cinemaJpa.repositories.DaoClient;
import cinemaJpa.repositories.DaoEvaluation;
import cinemaJpa.repositories.DaoFilm;
import cinemaJpa.repositories.DaoReservation;
import cinemaJpa.repositories.DaoSalle;
import cinemaJpa.repositories.DaoSeance;
import cinemaJpa.repositories.JpaContext;

public class AppTest {
	
//	Scanner scanner = new Scanner(System.in);
//	System.out.print("Entrez le titre du film: ");
//	String titre = scanner.nextLine();
//
//	System.out.print("Entrez la durée du film (hh:mm:ss): ");
//	LocalTime duree = LocalTime.parse(scanner.nextLine());
//
//	System.out.print("Entrez la date de sortie du film (aaaa-mm-jj): ");
//	LocalDate sortie = LocalDate.parse(scanner.nextLine());
//
//	System.out.print("Entrez la catégorie du film: ");
//	Categorie categorie = Categorie.valueOf(scanner.nextLine().toUpperCase());
//
//	System.out.print("Le film est-il disponible (true/false): ");
//	boolean disponible = Boolean.parseBoolean(scanner.nextLine());
//
//	Film nouveauFilm = new Film(titre, categorie, duree, sortie, disponible);
//	filmDao.save(nouveauFilm);
//
//  
	
	
	public static void main(String[] args) {
		DaoReservation daoReservation =JpaContext.getDaoReservation();
		DaoClient daoClient = JpaContext.getDaoClient();
		DaoFilm daoFilm = JpaContext.getDaoFilm();
		DaoEvaluation daoEvaluation = JpaContext.getDaoEvaluation();
		DaoActeur daoActeur = JpaContext.getDaoActeur();
		DaoSalle daoSalle = JpaContext.getDaoSalle();
		DaoSeance daoSeance = JpaContext.getDaoSeance();
		DaoAdmin doaAdmin = JpaContext.getDaoAdmin();
		
		
		Client client = new Client("toto", null, "toto", null, null, null, LocalDate.parse("1997-01-10"), null);
		daoClient.insert(client);
	
		
		Film film = new Film("Avatar", Categorie.Fantastique, LocalTime.parse("03:50"),LocalDate.parse("2023-03-21") , false);
		Film film1 = new Film("Harry Potter", Categorie.Fantastique, LocalTime.parse("01:20"),LocalDate.parse("2024-07-01") , true);
		

		daoFilm.insert(film);
		
		
		Evaluation eval1 = new Evaluation(new EvaluationKey(film, client), 5, null);
		daoEvaluation.insert(eval1);


		Adresse adresse1= new Adresse("12","rue de Paris","Paris","75013");
		Adresse adresse2= new Adresse("15","rue de Toulouse","Toulouse","31000");

		Client client1=new Client("Toto","client1","mail@mail.fr","Dupond","Toto","0678352639",LocalDate.parse("1990-01-01"),adresse1);
		Client client2=new Client("Titi","client2","mail@mail.com","Dupond","Titi","0612345673",LocalDate.parse("1990-12-31"),adresse2);
		daoClient.insert(client2);
		daoClient.insert(client1);


		//Acteurs
		Acteur acteur1= new Acteur("B. Jordan","Michael","Americain");
		Acteur acteur2= new Acteur("Worthington","Sam","Australien");
		Acteur acteur3= new Acteur("Doe","Jane","Anglais");
		daoActeur.insert(acteur3);
		daoActeur.insert(acteur2);
		daoActeur.insert(acteur1);


		//Salles
		Salle salle1= new Salle("1",120);
		Salle salle2= new Salle("2",130);
		Salle salle3= new Salle("3",150);
		daoSalle.insert(salle3);
		daoSalle.insert(salle2);
		daoSalle.insert(salle1);

		//Seance 1 et 2 pour le film 1, seance 3 pour le film 2, salle au choix
		Seance seance1=new Seance(LocalDate.parse("2023-03-21"), LocalTime.parse("20:00"), 12.50, film1, salle1, Langue.VF);
		Seance seance2=new Seance(LocalDate.parse("2023-03-22"), LocalTime.parse("20:30"), 12.50, film1, salle3, Langue.VO);
		Seance seance3=new Seance(LocalDate.parse("2023-03-22"), LocalTime.parse("16:15"), 12.50, film1, salle2, Langue.VOSTFR);
//		daoSeance.insert(seance3);
//		daoSeance.insert(seance2);
//		daoSeance.insert(seance1);

		
		//reservation1 pour le film 1 /client1, reservation2 film2 / client1
		Reservation reservation1=new Reservation(1, LocalDate.parse("2023-03-21"), seance1);
		Reservation reservation2=new Reservation(2, LocalDate.parse("2023-03-28"), seance2);
						
		Reservation resa1 =new Reservation(50, LocalDate.parse("2023-03-21"), null);
		daoReservation.insert(resa1);
				
		Reservation reservationEnBase=daoReservation.findByKey(resa1.getId());
		System.out.println(reservationEnBase.getPrix());
				
		
		
		
		
		
	}
	
	
}
