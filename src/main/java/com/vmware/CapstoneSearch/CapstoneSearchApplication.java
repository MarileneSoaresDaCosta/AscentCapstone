package com.vmware.CapstoneSearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CapstoneSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapstoneSearchApplication.class, args);
	}

	// adding sample data
	@Bean
	public CommandLineRunner demoData(PetsRepository petsRepository) {
		return args -> {
			List<Pet> pets;
			pets = new ArrayList<>();
			for (int i = 0; i < 5; i++) {
				pets.add(new Pet("dog", "puppy"+i, "9100" + i));
			}
			for (int i = 0; i < 5; i++) {
				pets.add(new Pet("cat", "kitty"+i, "9500" + i));
			}
			petsRepository.saveAll(pets);
		};
	}

}
