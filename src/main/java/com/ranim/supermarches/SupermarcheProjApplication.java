package com.ranim.supermarches;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ranim.supermarches.entities.Role;
import com.ranim.supermarches.entities.Supermarche;
import com.ranim.supermarches.entities.User;
import com.ranim.supermarches.service.SupermarcheService;
import com.ranim.supermarches.service.UserService;

import jakarta.annotation.PostConstruct;


@SpringBootApplication
public class SupermarcheProjApplication implements CommandLineRunner{
	
	@Autowired
	SupermarcheService supermarcheService ;
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(SupermarcheProjApplication.class, args);
	}
	
	/*@PostConstruct
	void init_users() {
	//ajouter les rôles
	userService.addRole(new Role(null,"ADMIN"));
	userService.addRole(new Role(null,"AGENT"));
	userService.addRole(new Role(null,"USER"));
	//ajouter les users
	userService.saveUser(new User(null,"admin","123",true,null));
	userService.saveUser(new User(null,"ranim","123",true,null));
	userService.saveUser(new User(null,"user1","123",true,null));
	//ajouter les rôles aux users
	userService.addRoleToUser("admin", "ADMIN");
	userService.addRoleToUser("ranim", "USER");
	userService.addRoleToUser("ranim", "AGENT");
	userService.addRoleToUser("user1", "USER");
	}*/

	@Override
	public void run(String... args) throws Exception {
		
		/*System.out.println("Password Encoded BCRYPT :******************** ");
		System.out.println(passwordEncoder.encode("123"));*/
		
		/*supermarcheService.saveSupermarche(new Supermarche("Monoprix Express nabeul", 26, new Date()));
		supermarcheService.saveSupermarche(new Supermarche("carrefour Bizerte", 50, new Date()));
		supermarcheService.saveSupermarche(new Supermarche("mg express ", 19, new Date()));*/
		//repositoryRestConfiguration.exposeIdsFor(Supermarche.class);	
	}
	
	

}
