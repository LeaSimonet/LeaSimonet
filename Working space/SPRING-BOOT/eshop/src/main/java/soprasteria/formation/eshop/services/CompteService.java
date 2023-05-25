package soprasteria.formation.eshop.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import soprasteria.formation.eshop.entities.Compte;
import soprasteria.formation.eshop.entities.Role;
import soprasteria.formation.eshop.exceptions.CompteException;
import soprasteria.formation.eshop.repositories.CompteRepository;

@Service
public class CompteService {

	@Autowired
	private CompteRepository compteRepo;
	@Autowired
	PasswordEncoder passwordEncoder;

	public Compte getByLogin(String username) throws UsernameNotFoundException {
		Optional<Compte> opt = compteRepo.findByLogin(username);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return compteRepo.findByLogin(username).orElseThrow(() -> {
				throw new UsernameNotFoundException("utilisateur inconnu");
			});
		}
	}

	private void checkCompte(Compte compte) {
		if (compte.getUsername() == null || compte.getUsername().isBlank()) {
			throw new CompteException();
		}
	}
	
	private void encodePassword(Compte compte) {
		compte.setPassword(passwordEncoder.encode(compte.getPassword()));
	}

	private Compte create(Compte compte) {
		checkCompte(compte);
		encodePassword(compte);
		return compteRepo.save(compte);
	}

	
	public Compte createAdmin(String username, String password) {
		return create(new Compte(username, password, Role.ROLE_ADMIN));
	}
	
	public Compte createClient(String username, String password) {
		return create(new Compte(username, password, Role.ROLE_CLIENT));
	}

}
