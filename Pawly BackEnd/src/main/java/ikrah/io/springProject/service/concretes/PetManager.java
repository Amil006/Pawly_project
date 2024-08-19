package ikrah.io.springProject.service.concretes;

import ikrah.io.springProject.dao.impl.PetStreamFileDao;
import ikrah.io.springProject.model.dto.PetDto;
import ikrah.io.springProject.model.entity.PetEntity;
import ikrah.io.springProject.service.abstracts.PetService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class PetManager implements PetService {

    private final PetStreamFileDao petStreamFileDao;
    private final ModelMapper modelMapper;

    @Autowired
    public PetManager(PetStreamFileDao petStreamFileDao, ModelMapper modelMapper) {
        this.petStreamFileDao = petStreamFileDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public PetDto addPet(PetDto petDto) {
        PetEntity petEntity = modelMapper.map(petDto, PetEntity.class);
        PetEntity savedPetEntity = petStreamFileDao.save(petEntity);
        return modelMapper.map(savedPetEntity, PetDto.class);
    }

    @Override
    public List<PetDto> getAllPets() {
        List<PetEntity> petEntities = petStreamFileDao.getAll();
        return petEntities.stream()
                .map(petEntity -> modelMapper.map(petEntity, PetDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PetDto> findPetById(Long id) {
        Optional<PetEntity> petEntityOptional = petStreamFileDao.findById(id);
        return petEntityOptional.map(petEntity -> modelMapper.map(petEntity, PetDto.class));
    }

    @Override
    public List<PetDto> findPetsBy(Predicate<PetDto> predicate) {
        return petStreamFileDao.getAll().stream()
                .map(petEntity -> modelMapper.map(petEntity, PetDto.class))
                .filter(predicate)
                .collect(Collectors.toList());
    }

    @Override
    public void deletePetById(Long id) {
        petStreamFileDao.deleteById(id);
    }

    @Override
    public void deletePetByName(String name) {
        petStreamFileDao.getAll().stream()
                .filter(petEntity -> petEntity.getName().toLowerCase().equalsIgnoreCase(name.toLowerCase()))
                .map(PetEntity::getId)
                .forEach(petStreamFileDao::deleteById);
    }
}
