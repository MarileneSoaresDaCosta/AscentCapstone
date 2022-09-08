package com.vmware.CapstoneSearch;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//allowing frontend in from port 3000
@CrossOrigin(origins="http://localhost:3000")
@RestController

public class SearchController {
    SearchService searchService;


    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

//    @GetMapping("/api/petSearch")
//    public ResponseEntity<PetsList> getPets(@RequestParam(required = false) String zip, @RequestParam(required = false) String type, @RequestParam(required = false) String breed, @RequestParam(required = false) String age, @RequestParam(required = false) String gender) {
//        PetsList petsList;
//        petsList = searchService.getPets(zip, type, breed, age, gender);
//        return petsList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(petsList);
//    }

    @GetMapping("/products")
    @ResponseBody
    public List<Pet> fetchByNameOrDesc(@RequestParam(value = "q", required = false) String query) {
        List<Pet> products = searchService.processSearch(query) ;
        return products;
    }

    @PostMapping("/api/petSearch")
    public Pet addPet(@RequestBody Pet pet) { return searchService.addPet(pet); }


}
