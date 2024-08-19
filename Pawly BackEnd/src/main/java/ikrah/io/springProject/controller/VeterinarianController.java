package ikrah.io.springProject.controller;

import ikrah.io.springProject.model.dto.VeterinarianDto;
import ikrah.io.springProject.service.abstracts.VeterinarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/veterinarians")
public class VeterinarianController {

    private final VeterinarianService veterinarianService;

    @Autowired
    public VeterinarianController(VeterinarianService veterinarianService) {
        this.veterinarianService = veterinarianService;
    }

    @PostMapping
    public ResponseEntity<VeterinarianDto> saveVeterinarian(@RequestBody VeterinarianDto veterinarianDto) {
        VeterinarianDto savedVeterinarian = veterinarianService.save(veterinarianDto);
        return ResponseEntity.ok(savedVeterinarian);
    }

    @GetMapping
    public ResponseEntity<List<VeterinarianDto>> getAllVeterinarians() {
        List<VeterinarianDto> veterinarians = veterinarianService.getAll();
        return ResponseEntity.ok(veterinarians);
    }

    @GetMapping("/{name}")
    public ResponseEntity<VeterinarianDto> getVeterinarianByName(@PathVariable String name) {
        Optional<VeterinarianDto> veterinarian = veterinarianService.findByName(name);
        return veterinarian.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteVeterinarianByName(@PathVariable String name) {
        veterinarianService.deleteByName(name);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<VeterinarianDto>> searchVeterinariansByCriteria(@RequestParam String criteria, @RequestParam String value) {
        Predicate<VeterinarianDto> predicate;
        String lowerCaseValue = value.toLowerCase();

        switch (criteria.toLowerCase()) {
            case "name":
                predicate = veterinarianDto -> veterinarianDto.getName().toLowerCase().equals(lowerCaseValue);
                break;
            case "surname":
                predicate = veterinarianDto -> veterinarianDto.getSurname().toLowerCase().equals(lowerCaseValue);
                break;
            case "location":
                predicate = veterinarianDto -> veterinarianDto.getLocation().toLowerCase().equals(lowerCaseValue);
                break;
            case "phonenumber":
                predicate = veterinarianDto -> veterinarianDto.getPhoneNumber().toLowerCase().equals(lowerCaseValue);
                break;
            default:
                return ResponseEntity.badRequest().build();
        }

        List<VeterinarianDto> veterinarians = veterinarianService.getAll().stream()
                .filter(predicate)
                .collect(Collectors.toList());
        if (veterinarians.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(veterinarians);
        }
    }
}

