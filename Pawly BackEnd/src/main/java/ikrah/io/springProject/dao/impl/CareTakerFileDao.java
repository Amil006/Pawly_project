package ikrah.io.springProject.dao.impl;

import ikrah.io.springProject.dao.CareTakerDao;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ikrah.io.springProject.dao.CareTakerDao;
import ikrah.io.springProject.model.entity.AnimalCareTakerEntity;
import ikrah.io.springProject.util.Constants;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
public class CareTakerFileDao extends CareTakerDao {
    private String careTakersFilePath = Constants.CARE_TAKER_STREAM_FILE;
    private List<AnimalCareTakerEntity> careTakers = new ArrayList<>();
    private ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    private void init() {
        loadCareTakersFromFile();
    }

    @Override
    public AnimalCareTakerEntity save(AnimalCareTakerEntity careTakerEntity) {
        careTakerEntity.setId(generateNextId());
        careTakers.add(careTakerEntity);
        saveCareTakersToFile();
        return careTakerEntity;
    }

    @Override
    public List<AnimalCareTakerEntity> getAll() {
        return careTakers;
    }

    @Override
    public Optional<AnimalCareTakerEntity> findBy(Predicate<AnimalCareTakerEntity> predicate) {
        return careTakers.stream()
                .filter(predicate)
                .findFirst();
    }

    public void deleteByName(String name) {
        careTakers = careTakers.stream()
                .filter(careTaker -> !careTaker.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
        saveCareTakersToFile();
    }

    private void loadCareTakersFromFile() {
        try {
            File file = new File(careTakersFilePath);
            if (file.length() == 0) {
                careTakers = new ArrayList<>();
            } else {
                careTakers = objectMapper.readValue(file, new TypeReference<>() {});
            }
        } catch (IOException e) {
            careTakers = new ArrayList<>();
            e.printStackTrace();
        }
    }

    private void saveCareTakersToFile() {
        try {
            objectMapper.writeValue(new File(careTakersFilePath), careTakers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Long generateNextId() {
        return careTakers.stream()
                .mapToLong(AnimalCareTakerEntity::getId)
                .max()
                .orElse(0L) + 1;
    }

}
