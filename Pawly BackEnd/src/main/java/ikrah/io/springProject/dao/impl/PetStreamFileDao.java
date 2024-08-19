package ikrah.io.springProject.dao.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ikrah.io.springProject.dao.PetDao;
import ikrah.io.springProject.model.entity.PetEntity;
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
public class PetStreamFileDao extends PetDao {

    private String petsFilePath = Constants.PET_STREAM_FILE;
    private List<PetEntity> pets = new ArrayList<>();
    private ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    private void init() {
        loadPetsFromFile();
    }

    @Override
    public PetEntity save(PetEntity petEntity) {
        petEntity.setId(generateNextId());
        pets.add(petEntity);
        savePetsToFile();
        return petEntity;
    }

    @Override
    public List<PetEntity> getAll() {
        return pets;
    }

    @Override
    public Optional<PetEntity> findBy(Predicate<PetEntity> predicate) {
        return pets.stream()
                .filter(predicate)
                .findFirst();
    }


    public Optional<PetEntity> findById(Long id) {
        return pets.stream()
                .filter(pet -> pet.getId().equals(id))
                .findFirst();
    }


    public void deleteById(Long id) {
        pets = pets.stream()
                .filter(pet -> !pet.getId().equals(id))
                .collect(Collectors.toList());
        savePetsToFile();
    }

    private void loadPetsFromFile() {
        try {
            File file = new File(petsFilePath);
            if (file.length() == 0) {
                pets = new ArrayList<>(); // Dosya boşsa boş bir liste oluştur
            } else {
                pets = objectMapper.readValue(file, new TypeReference<>() {});
            }
        } catch (IOException e) {
            pets = new ArrayList<>();
            e.printStackTrace();
        }
    }

    private void savePetsToFile() {
        try {
            objectMapper.writeValue(new File(petsFilePath), pets);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Long generateNextId() {
        return pets.stream()
                .mapToLong(PetEntity::getId)
                .max()
                .orElse(0L) + 1;
    }
}
