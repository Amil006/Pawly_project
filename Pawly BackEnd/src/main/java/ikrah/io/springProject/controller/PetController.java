package ikrah.io.springProject.controller;

import ikrah.io.springProject.model.dto.PetDto;
import ikrah.io.springProject.service.concretes.PetManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    private final PetManager petManager;

    @Autowired
    public PetController(PetManager petManager) {
        this.petManager = petManager;
    }

    @PostMapping("/add")
    public ResponseEntity<PetDto> addPet(@RequestBody PetDto petDto) {
        PetDto addedPet = petManager.addPet(petDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedPet);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PetDto>> getAllPets() {
        List<PetDto> pets = petManager.getAllPets();
        return ResponseEntity.ok(pets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetDto> getPetById(@PathVariable Long id) {
        Optional<PetDto> petDtoOptional = petManager.findPetById(id);
        return petDtoOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePetById(@PathVariable Long id) {
        petManager.deletePetById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deleteByName")
    public ResponseEntity<Void> deletePetByName(@RequestParam String name) {
        petManager.deletePetByName(name.toLowerCase());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<PetDto>> searchPetsByCriteria(@RequestParam String criteria, @RequestParam String value) {
        Predicate<PetDto> predicate;
        String lowerCaseValue = value.toLowerCase();

        switch (criteria.toLowerCase()) {
            case "name":
                predicate = petDto -> petDto.getName().toLowerCase().equals(lowerCaseValue);
                break;
            case "species":
                predicate = petDto -> petDto.getSpecies().toLowerCase().equals(lowerCaseValue);
                break;
            case "breed":
                predicate = petDto -> petDto.getBreed().toLowerCase().equals(lowerCaseValue);
                break;
            case "type":
                predicate = petDto -> petDto.getType().toLowerCase().equals(lowerCaseValue);
                break;
            default:
                return ResponseEntity.badRequest().build();
        }

        List<PetDto> pets = petManager.findPetsBy(predicate);
        if (pets.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(pets);
        }
    }

    // You can add more methods as needed, such as updatePet()

}
