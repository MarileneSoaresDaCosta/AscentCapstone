package com.vmware.CapstoneSearch;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.properties")

class CapstoneSearchApplicationTests {

	@Autowired
	TestRestTemplate restTemplate;

	@Autowired
	PetsRepository petsRepository;

	List<Pet> pets;
	@BeforeEach
	void setUp() {
		this.pets = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			this.pets.add(new Pet("lucky", "9000" + i, "dog", "husky", "young", "female"));
		}
		for (int i = 0; i < 5; i++) {
			this.pets.add(new Pet("jingles", "9500" + i, "cat", "shorthair", "adult", "female"));
		}
		petsRepository.saveAll(this.pets);
	}

	@AfterEach
	void tearDown() {petsRepository.deleteAll();}

	@Test
	void contextLoads() {
	}

	@Test
	void getPets_exists_returnsPetsList() {
		ResponseEntity<PetsList> response = restTemplate.getForEntity("/api/petSearch", PetsList.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().isEmpty()).isFalse();
		for(Pet pet : response.getBody().getPets()) {
			System.out.println(pet);
		}
	}

	@Test
	void getPetsNearZip_exists_returnsPetsList() {
		ResponseEntity<PetsList> response = restTemplate.getForEntity("/api/petSearch?zip=90001", PetsList.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().isEmpty()).isFalse();
		assertThat(response.getBody().petsSize()).isEqualTo(4);
		for(Pet pet : response.getBody().getPets()) {
			System.out.println(pet);
		}
	}

	@Test
	void getPetsByType_exists_returnsPetsList() {
		ResponseEntity<PetsList> response = restTemplate.getForEntity("/api/petSearch?type=dog", PetsList.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().isEmpty()).isFalse();
		assertThat(response.getBody().petsSize()).isEqualTo(5);
		for(Pet pet : response.getBody().getPets()) {
			System.out.println(pet);
		}
	}

	@Test
	void getPetsByBreed_exists_returnsPetsList() {
		ResponseEntity<PetsList> response = restTemplate.getForEntity("/api/petSearch?breed=shorthair", PetsList.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().isEmpty()).isFalse();
		assertThat(response.getBody().petsSize()).isEqualTo(5);
		for(Pet pet : response.getBody().getPets()) {
			System.out.println(pet);
		}
	}

	@Test
	void getPetsByAge_exists_returnsPetsList() {
		ResponseEntity<PetsList> response = restTemplate.getForEntity("/api/petSearch?age=adult", PetsList.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().isEmpty()).isFalse();
		assertThat(response.getBody().petsSize()).isEqualTo(5);
		for(Pet pet : response.getBody().getPets()) {
			System.out.println(pet);
		}
	}

	@Test
	void getPetsByGender_exists_returnsPetsList() {
		ResponseEntity<PetsList> response = restTemplate.getForEntity("/api/petSearch?gender=female", PetsList.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().isEmpty()).isFalse();
		assertThat(response.getBody().petsSize()).isEqualTo(10);
		for(Pet pet : response.getBody().getPets()) {
			System.out.println(pet);
		}
	}

	@Test
	void getPetsNearZipAndByType_exists_returnsPetsList() {
		ResponseEntity<PetsList> response = restTemplate.getForEntity("/api/petSearch?zip=90001&type=dog", PetsList.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().isEmpty()).isFalse();
		assertThat(response.getBody().petsSize()).isEqualTo(4);
		for(Pet pet : response.getBody().getPets()) {
			System.out.println(pet);
		}
	}

	@Test
	void getPetsNearZipAndByTypeBreedAgeGender_exists_returnsPetsList() {
		ResponseEntity<PetsList> response = restTemplate.getForEntity("/api/petSearch?zip=90001&type=dog&breed=husky&age=young&gender=female", PetsList.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().isEmpty()).isFalse();
		assertThat(response.getBody().petsSize()).isEqualTo(4);
		for(Pet pet : response.getBody().getPets()) {
			System.out.println(pet);
		}
	}
}
