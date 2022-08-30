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
}
