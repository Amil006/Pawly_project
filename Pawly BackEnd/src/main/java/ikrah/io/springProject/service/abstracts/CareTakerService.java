package ikrah.io.springProject.service.abstracts;

import ikrah.io.springProject.model.dto.AnimalCareTakerDto;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface CareTakerService {

    AnimalCareTakerDto save(AnimalCareTakerDto careTakerDto);

    List<AnimalCareTakerDto> getAll();

    Optional<AnimalCareTakerDto> findByName(String name);

    void deleteByName(String name);
}
