package ikrah.io.springProject.controller;

import ikrah.io.springProject.model.dto.AnimalShelterDto;
import ikrah.io.springProject.service.abstracts.AnimalShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/animal-shelters")
public class AnimalShelterController {

    private final AnimalShelterService animalShelterService;

    @Autowired
    public AnimalShelterController(AnimalShelterService animalShelterService) {
        this.animalShelterService = animalShelterService;
    }

    @PostMapping
    public ResponseEntity<AnimalShelterDto> createAnimalShelter(@RequestBody AnimalShelterDto animalShelterDto) {
        AnimalShelterDto savedShelter = animalShelterService.save(animalShelterDto);
        return ResponseEntity.ok(savedShelter);
    }

    @GetMapping
    public ResponseEntity<List<AnimalShelterDto>> getAllAnimalShelters() {
        List<AnimalShelterDto> shelters = animalShelterService.getAll();
        return ResponseEntity.ok(shelters);
    }



    @GetMapping("/search-by-name")
    public ResponseEntity<List<AnimalShelterDto>> searchSheltersByName(@RequestParam String name) {
        Optional<AnimalShelterDto> shelterByName = animalShelterService.findByShelterName(name);
        return shelterByName.map(dto -> ResponseEntity.ok(List.of(dto))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{shelterName}")
    public ResponseEntity<Void> deleteAnimalShelter(@PathVariable String shelterName) {
        animalShelterService.deleteByShelterName(shelterName);
        return ResponseEntity.noContent().build();
    }
}
