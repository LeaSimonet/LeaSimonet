package musiciens.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Spectateur {

    @Before("execution(void musicien.beans.Guitariste.performer())")
    public void avantGuitaristePerformer() {
        System.out.println("Le spectateur coupe son téléphone");
    }
    
    
    @Before("execution(void musicien.beans.Guitariste.performer())")
    public void avantSaxophonistePerformer() {
        System.out.println("Le spectateur s'installe.");
    }

 
    
    
    @AfterReturning("execution(void musicien.beans.Guitariste.performer())")
    public void apresGuitaristePerformer() {
        System.out.println("Le guitariste remercie le public.");
        if (Math.random() < 0.5) {
            System.out.println("Le spectateur applaudit !");
        } else {
            System.out.println("Le spectateur hue...");
        }
    }
    

    
    @Before("execution(void musicien.beans.Saxophoniste.performer())")
    public void demanderAuSaxophoniste() {
        System.out.println("Les spectateurs demandent au saxophoniste de performer.");
    }
    
    @AfterReturning("execution(void musicien.beans.Saxophoniste.performer())")
    public void apresSaxophonistePerformer() {
        if (Math.random() < 0.5) {
            System.out.println("Le spectateur applaudit !");
        } else {
            System.out.println("Le spectateur hue...");
        }
    }
    
   

    
}



	
