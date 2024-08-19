package ikrah.io.springProject.service.abstracts;

import ikrah.io.springProject.model.dto.PetDto;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface PetService {
    PetDto addPet(PetDto petDto);

    List<PetDto> getAllPets();

    Optional<PetDto> findPetById(Long id);

    List<PetDto> findPetsBy(Predicate<PetDto> predicate);

    void deletePetById(Long id);
    void deletePetByName(String name);
}
