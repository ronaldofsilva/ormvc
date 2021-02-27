package br.ueg.br.si.p4.reflection.fw.conf;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.ueg.br.si.p4.reflection.fw.controllers.ContaController;
import br.ueg.br.si.p4.reflection.fw.controllers.HomeController;

@EnableWebMvc
@ComponentScan(basePackageClasses = {HomeController.class, ContaController.class})
public class AppWebConfiguration {
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	
	
	/*
	@Bean
	public EntityManager getEntityManager() {
		final EntityManagerFactory emFactory;
		emFactory = Persistence.createEntityManagerFactory("financeiro");
		return emFactory.createEntityManager();
	}*/

	
}
