package ikrah.io.springProject.service.concretes;

import ikrah.io.springProject.dao.impl.ShelterFileDao;
import ikrah.io.springProject.model.dto.AnimalShelterDto;
import ikrah.io.springProject.model.entity.AnimalShelterEntity;
import ikrah.io.springProject.service.abstracts.AnimalShelterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnimalShelterManager implements AnimalShelterService {

    private final ShelterFileDao shelterFileDao;
    private final ModelMapper modelMapper;

    @Autowired
    public AnimalShelterManager(ShelterFileDao shelterFileDao, ModelMapper modelMapper) {
        this.shelterFileDao = shelterFileDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public AnimalShelterDto save(AnimalShelterDto animalShelterDto) {
        AnimalShelterEntity entity = modelMapper.map(animalShelterDto, AnimalShelterEntity.class);
        AnimalShelterEntity savedEntity = shelterFileDao.save(entity);
        return modelMapper.map(savedEntity, AnimalShelterDto.class);
    }

    @Override
    public List<AnimalShelterDto> getAll() {
        List<AnimalShelterEntity> entities = shelterFileDao.getAll();
        return entities.stream()
                .map(entity -> modelMapper.map(entity, AnimalShelterDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AnimalShelterDto> findByShelterName(String shelterName) {
        Optional<AnimalShelterEntity> entityOptional = shelterFileDao.findBy(shelter -> shelter.getShelterName().toLowerCase().equalsIgnoreCase(shelterName));
        return entityOptional.map(entity -> modelMapper.map(entity, AnimalShelterDto.class));
    }

    @Override
    public void deleteByShelterName(String shelterName) {
        shelterFileDao.deleteByName(shelterName);
    }
}
