package org.sid;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

import org.sid.Dao.CantactRepository;
import org.sid.entite.Cantactt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactsRepApplication implements CommandLineRunner {
	
    @Autowired
	private CantactRepository cantactRepository ;
	
	public static void main(String[] args) {
		SpringApplication.run(ContactsRepApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	     DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
		cantactRepository.save(new Cantactt("sofiene", "Lasmar", df.parse("11/09/1984"), 74896122l));
		cantactRepository.save(new Cantactt("Mouldi", "Lasmar", df.parse("11/09/1954"), 74896122l));
		cantactRepository.save(new Cantactt("Bahriya", "Lasmar", df.parse("11/09/1956"), 74896122l));
		cantactRepository.save(new Cantactt("Aida", "Lasmar", df.parse("11/09/1979"), 74896122l));
		cantactRepository.save(new Cantactt("hafedh", "Lasmar", df.parse("11/09/1979"), 74896122l));
		cantactRepository.save(new Cantactt("haikel", "Lasmar", df.parse("11/09/1979"), 74896122l));
		 
		LocalDate currentDate = LocalDate.now();
		LocalDate dt = LocalDate.of(1984,Month.SEPTEMBER,11); 
		Period p = Period.between(currentDate , dt);
		System.out.println("Age"+p);
	}
}
