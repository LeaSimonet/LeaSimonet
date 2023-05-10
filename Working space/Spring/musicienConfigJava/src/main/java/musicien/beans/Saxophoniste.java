package musicien.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Saxophoniste implements Musicien {

	@Autowired
	@Qualifier("saxophone")
	private Instrument instrument;

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

//	@Override
//	public void performer() {
//		System.out.println("le saxophoniste joue de son de instrument");
//		instrument.jouer();
//	}

	@Override
	 public void performer() {
        System.out.println("Le saxophoniste commence à jouer.");
        instrument.jouer();
        System.out.println("Le saxophoniste a fini de jouer.");
    }

}
