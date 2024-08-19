package ikrah.io.springProject.dao.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ikrah.io.springProject.dao.VeterinarianDao;
import ikrah.io.springProject.model.entity.VeterinarianEntity;
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
public class VeterinarianFileDao extends VeterinarianDao {
    private String veterinariansFilePath = Constants.VETERINARIAN_STREAM_FILE;
    private List<VeterinarianEntity> veterinarians = new ArrayList<>();
    private ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    private void init() {
        loadVeterinariansFromFile();
    }

    @Override
    public VeterinarianEntity save(VeterinarianEntity veterinarianEntity) {
        veterinarianEntity.setId(generateNextId());
        veterinarians.add(veterinarianEntity);
        saveVeterinariansToFile();
        return veterinarianEntity;
    }

    @Override
    public List<VeterinarianEntity> getAll() {
        return veterinarians;
    }

    @Override
    public Optional<VeterinarianEntity> findBy(Predicate<VeterinarianEntity> predicate) {
        return veterinarians.stream()
                .filter(predicate)
                .findFirst();
    }

    public void deleteByName(String name) {
        veterinarians = veterinarians.stream()
                .filter(veterinarian -> !veterinarian.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
        saveVeterinariansToFile();
    }

    private void loadVeterinariansFromFile() {
        try {
            File file = new File(veterinariansFilePath);
            if (file.length() == 0) {
                veterinarians = new ArrayList<>();
            } else {
                veterinarians = objectMapper.readValue(file, new TypeReference<>() {});
            }
        } catch (IOException e) {
            veterinarians = new ArrayList<>();
            e.printStackTrace();
        }
    }

    private void saveVeterinariansToFile() {
        try {
            objectMapper.writeValue(new File(veterinariansFilePath), veterinarians);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Long generateNextId() {
        return veterinarians.stream()
                .mapToLong(VeterinarianEntity::getId)
                .max()
                .orElse(0L) + 1;
    }
}
