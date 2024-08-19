package ikrah.io.springProject.service.concretes;

import ikrah.io.springProject.dao.impl.CareTakerFileDao;
import ikrah.io.springProject.model.dto.AnimalCareTakerDto;
import ikrah.io.springProject.model.entity.AnimalCareTakerEntity;
import ikrah.io.springProject.service.abstracts.CareTakerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CareTakerManager implements CareTakerService {

    private final CareTakerFileDao careTakerDao;
    private final ModelMapper modelMapper;

    @Autowired
    public CareTakerManager(CareTakerFileDao careTakerDao, ModelMapper modelMapper) {
        this.careTakerDao = careTakerDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public AnimalCareTakerDto save(AnimalCareTakerDto careTakerDto) {
        AnimalCareTakerEntity careTakerEntity = modelMapper.map(careTakerDto, AnimalCareTakerEntity.class);
        AnimalCareTakerEntity savedEntity = careTakerDao.save(careTakerEntity);
        return modelMapper.map(savedEntity, AnimalCareTakerDto.class);
    }

    @Override
    public List<AnimalCareTakerDto> getAll() {
        List<AnimalCareTakerEntity> entities = careTakerDao.getAll();
        return entities.stream()
                .map(entity -> modelMapper.map(entity, AnimalCareTakerDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AnimalCareTakerDto> findByName(String name) {
        Optional<AnimalCareTakerEntity> entityOptional = careTakerDao.findBy(careTaker -> careTaker.getName().equalsIgnoreCase(name));
        return entityOptional.map(entity -> modelMapper.map(entity, AnimalCareTakerDto.class));
    }

    @Override
    public void deleteByName(String name) {
        careTakerDao.deleteByName(name);
    }
}
