package musicien.beans;

import org.springframework.stereotype.Component;

@Component
public class Saxophone implements Instrument {

	@Override
	public void jouer() {
		System.out.println("Le saxophone joue !");
	}

}
