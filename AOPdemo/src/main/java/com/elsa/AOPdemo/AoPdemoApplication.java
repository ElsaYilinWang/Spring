package com.elsa.AOPdemo;

import com.elsa.AOPdemo.dao.AccountDAO;
import com.elsa.AOPdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AoPdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AoPdemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(
			AccountDAO theAccountDAO, MembershipDAO theMembershipDAO){
		
		return runner -> {
			
			demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		// call the business method
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.dowork();


		// call the business method again
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();

	}

}
