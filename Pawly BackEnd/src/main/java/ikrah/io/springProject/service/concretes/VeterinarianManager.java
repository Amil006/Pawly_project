package ikrah.io.springProject.service.concretes;

import ikrah.io.springProject.dao.impl.VeterinarianFileDao;
import ikrah.io.springProject.model.dto.VeterinarianDto;
import ikrah.io.springProject.model.entity.VeterinarianEntity;
import ikrah.io.springProject.service.abstracts.VeterinarianService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VeterinarianManager implements VeterinarianService {

    private final VeterinarianFileDao veterinarianDao;
    private final ModelMapper modelMapper;

    @Autowired
    public VeterinarianManager(VeterinarianFileDao veterinarianDao, ModelMapper modelMapper) {
        this.veterinarianDao = veterinarianDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public VeterinarianDto save(VeterinarianDto veterinarianDto) {
        VeterinarianEntity veterinarianEntity = modelMapper.map(veterinarianDto, VeterinarianEntity.class);
        VeterinarianEntity savedEntity = null;
        savedEntity = veterinarianDao.save(veterinarianEntity);
        return modelMapper.map(savedEntity, VeterinarianDto.class);
    }

    @Override
    public List<VeterinarianDto> getAll() {
        List<VeterinarianEntity> entities = veterinarianDao.getAll();
        return entities.stream()
                .map(entity -> modelMapper.map(entity, VeterinarianDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<VeterinarianDto> findByName(String name) {
        Optional<VeterinarianEntity> entityOptional = veterinarianDao.findBy(vet -> vet.getName().toLowerCase().equalsIgnoreCase(name));
        return entityOptional.map(entity -> modelMapper.map(entity, VeterinarianDto.class));
    }

    @Override
    public void deleteByName(String name) {
        veterinarianDao.deleteByName(name);
    }
}
