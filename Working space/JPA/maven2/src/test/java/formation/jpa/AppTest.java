package formation.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Jpa.context.Jpacontext;
import formation.Jpa.entities.Produit;
import formation.Jpa.repositories.DaoProduit;

public class AppTest {
	public static void main(String[]args) {
		/*EntityManagerFactory emf = Persistence.createEntityManagerFactory("eshop");
		System.out.println(emf);
		
		
		Produit p1=new Produit();
		p1.setId(1L);
		p1.setNom("TV");
		p1.setPrix(500);
		
		EntityManager em=emf.createEntityManager(); // Permet de récupérer l'objet pour exécuter nos requêtes. 
		
		// Pour insert update ou delete => obligation de gérer une transaction. 
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.persist(p1); // permet de donner la référence d'un entité. En entrée cela doit être une classe avec l'annotation ?? Et permet de faire un insert dans la base. 
		tx.commit();
		
		
		em.close();
		
		
		
		
		em=emf.createEntityManager();
		Produit produitEnBase=em.find(Produit.class, 1L);
		System.out.println(produitEnBase);
		
		Ces deux lignes de code sont écrites en langage Java et utilisent la bibliothèque Java Persistence API (JPA) pour interagir avec une base de données relationnelle.
		La première ligne de code exécute une requête de recherche dans la base de données pour récupérer l'objet "Produit" 
		correspondant à la clé primaire "1L" (qui est de type long). Cette requête utilise la méthode "find" fournie par l'objet "EntityManager" 
		(abrévié "em" dans le code) qui représente le contexte de persistance de JPA. La variable "produitEnBase" est une référence à l'objet "Produit" trouvé dans la base de données.
		La deuxième ligne de code affiche le contenu de la variable "produitEnBase" à la console en utilisant la méthode "println" fournie par la classe "System". 
		Cela permet de vérifier que l'objet "Produit" a bien été récupéré depuis la base de données et que son contenu est correct. Le résultat affiché dépend de l'implémentation de la méthode 
		"toString" de la classe "Produit".
		
		
		em.close();
		
		
		
		produitEnBase.setDescription("une Tv 4K");
		System.out.println("----------merge-----------");
		em=emf.createEntityManager();
		tx=em.getTransaction();
		tx.begin();
		produitEnBase=em.merge(produitEnBase); // essaie de retrouver le produit dans la base de données sinon insert mais pas terrible pour l'utiliser en insert
		produitEnBase.setPrix(10000);
		tx.commit();
		em.close();
		
		DELETE
		em=emf.createEntityManager();
		tx=em.getTransaction();
		tx.begin();
		em.remove(em.merge(produitEnBase));
		tx.commit();
		em.close();
		// on peut garantir que l'objet est dans la base avec un remove. Il faut donc faire un merge de notre produit. La véritable opération de merge est de rattacher l'objet en base. 
		// Je vais être obliger de prendre le produit de le rattacher à la base et ensuite de remove 
		
		
		emf.close();
		*/
		
		Produit p1 = new Produit();
		p1.setId(1L);
		p1.setNom("TV");
		p1.setPrix(100);
		
		DaoProduit daoProduit=Jpacontext.getDaoProduit();
		daoProduit.insert(p1);
		p1.setDescription("Cette TV est super cool");
		daoProduit.update(p1);
		System.out.println(daoProduit.findAll());
		
		// EN dernier
		
		Jpacontext.destroy();
		
		
		
		
	}
	


}
