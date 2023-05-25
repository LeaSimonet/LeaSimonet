package eshopSpringMvcFinal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import eshop.configurations.JpaConfig;

@Configuration //cette annotation indique que cette classe est une classe de configuration pour une application Spring.
@EnableWebMvc //cette annotation active la configuration de Spring MVC dans l'application.
@ComponentScan("eshopSpringMvcFinal.controller") // cette annotation indique à Spring où chercher les classes de contrôleurs pour l'application.
@Import(JpaConfig.class) // cette annotation importe une autre classe de configuration, JpaConfig, qui définit les paramètres de configuration pour JPA (Java Persistence API) dans l'application.
public class WebConfig {
	
	@Bean
	public UrlBasedViewResolver viewResolver() {
		UrlBasedViewResolver viewResolver= new UrlBasedViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

}
 

// Ensuite, la méthode viewResolver() déclare et retourne un objet UrlBasedViewResolver qui permet de résoudre les noms 
// de vues en URL et de renvoyer les vues correspondantes. Les paramètres de la méthode setViewClass(), setPrefix() et setSuffix() sont utilisés 
// pour spécifier le moteur de template (JstlView), le préfixe du chemin d'accès aux vues (/WEB-INF/views/) et l'extension de fichier de vue (.jsp).