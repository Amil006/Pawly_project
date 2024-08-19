package ikrah.io.springProject.dao.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ikrah.io.springProject.dao.ShelterDao;
import ikrah.io.springProject.model.entity.AnimalShelterEntity;
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
public class ShelterFileDao extends ShelterDao {

    private String sheltersFilePath = Constants.SHELTER_STREAM_FILE;
    private List<AnimalShelterEntity> shelters = new ArrayList<>();
    private ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    private void init() {
        loadSheltersFromFile();
    }

    @Override
    public AnimalShelterEntity save(AnimalShelterEntity shelterEntity) {
        shelterEntity.setId(generateNextId());
        shelters.add(shelterEntity);
        saveSheltersToFile();
        return shelterEntity;
    }

    @Override
    public List<AnimalShelterEntity> getAll() {
        return shelters;
    }

    @Override
    public Optional<AnimalShelterEntity> findBy(Predicate<AnimalShelterEntity> predicate) {
        return shelters.stream()
                .filter(predicate)
                .findFirst();
    }

    public void deleteByName(String name) {
        shelters = shelters.stream()
                .filter(shelter -> !shelter.getShelterName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
        saveSheltersToFile();
    }

    private void loadSheltersFromFile() {
        try {
            File file = new File(sheltersFilePath);
            if (file.length() == 0) {
                shelters = new ArrayList<>(); // Dosya boşsa boş bir liste oluştur
            } else {
                shelters = objectMapper.readValue(file, new TypeReference<>() {});
            }
        } catch (IOException e) {
            shelters = new ArrayList<>();
            e.printStackTrace();
        }
    }

    private void saveSheltersToFile() {
        try {
            objectMapper.writeValue(new File(sheltersFilePath), shelters);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Long generateNextId() {
        return shelters.stream()
                .mapToLong(AnimalShelterEntity::getId)
                .max()
                .orElse(0L) + 1;
    }
}
