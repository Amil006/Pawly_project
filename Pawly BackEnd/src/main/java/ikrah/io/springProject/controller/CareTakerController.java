package ikrah.io.springProject.controller;

import ikrah.io.springProject.model.dto.AnimalCareTakerDto;
import ikrah.io.springProject.service.abstracts.CareTakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/caretakers")
public class CareTakerController {

    private final CareTakerService careTakerService;

    @Autowired
    public CareTakerController(CareTakerService careTakerService) {
        this.careTakerService = careTakerService;
    }

    @PostMapping
    public ResponseEntity<AnimalCareTakerDto> saveCareTaker(@RequestBody AnimalCareTakerDto careTakerDto) {
        AnimalCareTakerDto savedCareTaker = careTakerService.save(careTakerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCareTaker);
    }

    @GetMapping
    public ResponseEntity<List<AnimalCareTakerDto>> getAllCareTakers() {
        List<AnimalCareTakerDto> careTakers = careTakerService.getAll();
        return ResponseEntity.ok(careTakers);
    }

    @GetMapping("/{name}")
    public ResponseEntity<AnimalCareTakerDto> getCareTakerByName(@PathVariable String name) {
        Optional<AnimalCareTakerDto> careTaker = careTakerService.findByName(name);
        return careTaker.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteCareTakerByName(@PathVariable String name) {
        careTakerService.deleteByName(name);
        return ResponseEntity.noContent().build();
    }
}
