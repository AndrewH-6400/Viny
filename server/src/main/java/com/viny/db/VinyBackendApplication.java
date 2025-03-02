package com.viny.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import com.viny.db.Models.MyCollection;
import com.viny.db.Models.MyUser;
import com.viny.db.Service.CollectionService;
import com.viny.db.Service.UserService;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class VinyBackendApplication implements CommandLineRunner{

	private final UserService userService;
	private final CollectionService collectionService;

	

	public VinyBackendApplication(UserService userService, CollectionService collectionService){
		this.userService = userService;
		this.collectionService = collectionService;
	}

	public static void main(String[] args) {
		SpringApplication.run(VinyBackendApplication.class, args);
	}

	@Override
	public void run(String...args) throws Exception{
		userService.saveUser(new MyUser("Andrew", "H","andrewh@email.com","Dweeb0","password"));
		userService.saveUser(new MyUser("Delilah","D","delTh3D0g@k9.com","D3lilah","password"));	
		collectionService.saveCollection(new MyCollection(0,1,"mCollection",new String[] {"3o5EnVZNJXtfPV8tCoagjI","27ygqCfb4dXQ3jyXnC58FU"}));		
	}
}
