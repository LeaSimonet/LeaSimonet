package musicien;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import musicien.beans.Musicien;

public class AppSpring {

    @Autowired
    private Musicien guitariste;

    @Autowired
    private Musicien saxophoniste;

    
    public void run(String... args) {
        guitariste.performer();
        saxophoniste.performer();
    }

   
}

	



