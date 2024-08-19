package ikrah.io.springProject.service.abstracts;

import ikrah.io.springProject.model.dto.AnimalShelterDto;

import java.util.List;
import java.util.Optional;

public interface AnimalShelterService {
    AnimalShelterDto save(AnimalShelterDto animalShelterDto);
    List<AnimalShelterDto> getAll();
    Optional<AnimalShelterDto> findByShelterName(String shelterName);
    void deleteByShelterName(String shelterName);
}
