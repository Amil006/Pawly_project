package ikrah.io.springProject.dao.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ikrah.io.springProject.dao.UserDao;
import ikrah.io.springProject.model.entity.AnimalCareTakerEntity;
import ikrah.io.springProject.model.entity.AnimalShelterEntity;
import ikrah.io.springProject.model.entity.PetEntity;
import ikrah.io.springProject.model.entity.UserEntity;
import ikrah.io.springProject.util.Constants;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
public class UserStreamFileDao extends UserDao {

    private String usersFilePath = Constants.USER_STREAM_FILE;
    private List<UserEntity> users = new ArrayList<>();
    private ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    private void init() {
        loadUsersFromFile();
    }


    @Override
    public UserEntity save(UserEntity userEntity) throws FileNotFoundException {
        users.add(userEntity);
        saveUsersToFile();
        return userEntity;
    }

    @Override
    public List<UserEntity> getAll() throws FileNotFoundException {
        return users;
    }

    @Override
    public Optional<UserEntity> findBy(Predicate<UserEntity> predicate) {
        return users.stream()
                .filter(predicate)
                .findFirst();
    }

    public void deleteByUsernamePassword(String username, String password) {
        users = users.stream()
                .filter(user -> !(user.getName().equals(username) && user.getPassword().equals(password)))
                .collect(Collectors.toList());
        saveUsersToFile();
    }


    private void loadUsersFromFile() {
        try {
            File file = new File(usersFilePath);
            if (!file.exists() || file.length() == 0) {
                users = new ArrayList<>();
            } else {
                users = objectMapper.readValue(file, new TypeReference<>() {});
            }
        } catch (IOException e) {
            users = new ArrayList<>();
            e.printStackTrace();
        }
    }

    private void saveUsersToFile() {
        try {
            objectMapper.writeValue(new File(usersFilePath), users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public UserEntity addToFavorites(String email, String type, Object dto) throws FileNotFoundException {
//        Optional<UserEntity> userOptional = findBy(user -> user.getEmail().equals(email));
//
//        if (userOptional.isPresent()) {
//            UserEntity userEntity = userOptional.get();
//            switch (type) {
//                case "pet":
//                    if (userEntity.getFavoritePets() == null) {
//                        userEntity.setFavoritePets(new ArrayList<>());
//                    }
//                    userEntity.getFavoritePets().add((PetEntity) dto);
//                    break;
//                case "shelter":
//                    if (userEntity.getFavoriteAnimalShelters() == null) {
//                        userEntity.setFavoriteAnimalShelters(new ArrayList<>());
//                    }
//                    userEntity.getFavoriteAnimalShelters().add((AnimalShelterEntity) dto);
//                    break;
//                case "careTaker":
//                    if (userEntity.getFavoriteAnimalCareTakers() == null) {
//                        userEntity.setFavoriteAnimalCareTakers(new ArrayList<>());
//                    }
//                    userEntity.getFavoriteAnimalCareTakers().add((AnimalCareTakerEntity) dto);
//                    break;
//                default:
//                    throw new IllegalArgumentException("Unknown type: " + type);
//            }
//            saveUsersToFile();  // Update the file with the new list
//            return userEntity;
//        } else {
//            throw new FileNotFoundException("User not found");
//        }
//    }

//    public UserEntity removeFromFavorites(String email, String type, Object dto) throws FileNotFoundException {
//        Optional<UserEntity> userOptional = findBy(user -> user.getEmail().equals(email));
//
//        if (userOptional.isPresent()) {
//            UserEntity userEntity = userOptional.get();
//            switch (type) {
//                case "pet":
//                    if (userEntity.getFavoritePets() != null) {
//                        userEntity.getFavoritePets().remove(dto);
//                    }
//                    break;
//                case "shelter":
//                    if (userEntity.getFavoriteAnimalShelters() != null) {
//                        userEntity.getFavoriteAnimalShelters().remove(dto);
//                    }
//                    break;
//                case "careTaker":
//                    if (userEntity.getFavoriteAnimalCareTakers() != null) {
//                        userEntity.getFavoriteAnimalCareTakers().remove(dto);
//                    }
//                    break;
//                default:
//                    throw new IllegalArgumentException("Unknown type: " + type);
//            }
//            saveUsersToFile();  // Update the file with the new list
//            return userEntity;
//        } else {
//            throw new FileNotFoundException("User not found");
//        }
//    }

}
