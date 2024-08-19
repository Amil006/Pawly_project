package ikrah.io.springProject.service.abstracts;

import ikrah.io.springProject.model.dto.VeterinarianDto;

import java.util.List;
import java.util.Optional;

public interface VeterinarianService {
    VeterinarianDto save(VeterinarianDto veterinarianDto);
    List<VeterinarianDto> getAll();
    Optional<VeterinarianDto> findByName(String name);
    void deleteByName(String name);
}
