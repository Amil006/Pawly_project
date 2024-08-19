package ikrah.io.springProject.controller;

import ikrah.io.springProject.model.dto.AnimalCareTakerDto;
import ikrah.io.springProject.model.dto.AnimalShelterDto;
import ikrah.io.springProject.model.dto.PetDto;
import ikrah.io.springProject.model.dto.UserDto;
import ikrah.io.springProject.model.entity.AnimalCareTakerEntity;
import ikrah.io.springProject.model.entity.AnimalShelterEntity;
import ikrah.io.springProject.service.abstracts.UserService;
import ikrah.io.springProject.service.concretes.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDto> getUserByUsername(@PathVariable String username) {
        Optional<UserDto> user = userService.getUserByUsername(username);
        return user.map(userDto -> new ResponseEntity<>(userDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/addUser")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto savedUser = userService.saveUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteUser(@RequestParam String username, @RequestParam String password) {
        userService.deleteUser(username, password);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/search")
    public ResponseEntity<UserDto> getUserBy(@RequestParam String criteria, @RequestParam String value) {
        Predicate<UserDto> predicate;
        String lowerCaseValue = value.toLowerCase();

        switch (criteria.toLowerCase()) {
            case "name":
                predicate = userDto -> userDto.getName().toLowerCase().equals(lowerCaseValue);
                break;
            case "surname":
                predicate = userDto -> userDto.getSurname().toLowerCase().equals(lowerCaseValue);
                break;
            case "email":
                predicate = userDto -> userDto.getEmail().toLowerCase().equals(lowerCaseValue);
                break;
            case "phonenumber":
                predicate = userDto -> userDto.getPhoneNumber().toLowerCase().equals(lowerCaseValue);
                break;
            default:
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Optional<UserDto> user = userService.getUserBy(predicate);
        return user.map(userDto -> new ResponseEntity<>(userDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> loginUser(@RequestParam String username, @RequestParam String password) {
        Optional<UserDto> user = userService.authenticateUser(username.toLowerCase(), password.toLowerCase());
        return user.map(userDto -> new ResponseEntity<>(userDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.UNAUTHORIZED));
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signUpUser(@RequestParam String name, @RequestParam String password, @RequestParam String email) {
        if (name == null || password == null || email == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (password.length() < 8) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Predicate<UserDto> predicateByEmail = userDto -> userDto.getEmail().toLowerCase().equals(email.toLowerCase());
        Optional<UserDto> existingUser = userService.getUserBy(predicateByEmail);
        if (existingUser.isPresent()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        UserDto userDto = new UserDto();
        userDto.setName(name);
        userDto.setPassword(password);
        userDto.setEmail(email);

        UserDto savedUser = userService.saveUser(userDto);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

//    @PostMapping("/{username}/addFavoritePet")
//    public ResponseEntity<UserDto> addFavoritePet(@PathVariable String username, @RequestBody PetDto petDto) {
//        return updateFavoriteList(username.toLowerCase(), petDto, "pet");
//    }
//
//    @PostMapping("/{username}/deleteFavoritePet")
//    public ResponseEntity<UserDto> deleteFavoritePet(@PathVariable String username, @RequestBody PetDto petDto) {
//        return deleteFromFavoriteList(username.toLowerCase(), petDto, "pet");
//    }
//
//    @PostMapping("/{username}/addFavoriteShelter")
//    public ResponseEntity<UserDto> addFavoriteShelter(@PathVariable String username, @RequestBody AnimalShelterDto shelterDto) {
//        return updateFavoriteList(username.toLowerCase(), shelterDto, "shelter");
//    }
//
//    @PostMapping("/{username}/deleteFavoriteShelter")
//    public ResponseEntity<UserDto> deleteFavoriteShelter(@PathVariable String username, @RequestBody AnimalShelterDto shelterDto) {
//        return deleteFromFavoriteList(username.toLowerCase(), shelterDto, "shelter");
//    }
//
//    @PostMapping("/{username}/addFavoriteCareTaker")
//    public ResponseEntity<UserDto> addFavoriteCareTaker(@PathVariable String username, @RequestBody AnimalCareTakerDto careTakerDto) {
//        return updateFavoriteList(username.toLowerCase(), careTakerDto, "careTaker");
//    }
//
//    @PostMapping("/{username}/deleteFavoriteCareTaker")
//    public ResponseEntity<UserDto> deleteFavoriteCareTaker(@PathVariable String username, @RequestBody AnimalCareTakerDto careTakerDto) {
//        return deleteFromFavoriteList(username.toLowerCase(), careTakerDto, "careTaker");
//    }

//    private ResponseEntity<UserDto> updateFavoriteList(String username, Object dto, String type) {
////        List<UserDto> users = userService.getAllUsers();
//        Optional<UserDto> userOptional = userService.getUserByUsername(username.toLowerCase());
//        if (userOptional.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        UserDto userDto = userOptional.get();
//        switch (type) {
//            case "pet":
//                if (userDto.getFavoritePets() == null) {
//                    userDto.setFavoritePets(new ArrayList<>());
//                }
//                List<UserDto> updatedUsers = userService.getAllUsers().stream()
//                        .filter(userDtos -> !userDtos.getName().equalsIgnoreCase(username))
//                        .collect(Collectors.toList());
//
//                userDto.getFavoritePets().add((PetDto) dto);
//                updatedUsers.add(userDto);
//                updatedUsers.forEach(userService::saveUser);
//                return new ResponseEntity<>(userDto, HttpStatus.OK);
//            case "shelter":
//                if (userDto.getFavoriteAnimalShelters() == null) {
//                    userDto.setFavoriteAnimalShelters(new ArrayList<>());
//                }
//                userDto.getFavoriteAnimalShelters().add((AnimalShelterDto) dto);
//                UserDto updatedUser = userService.saveUser(userDto);
//                return new ResponseEntity<>(updatedUser, HttpStatus.OK);
////            break;
//            case "careTaker":
//                if (userDto.getFavoriteAnimalCareTakers() == null) {
//                    userDto.setFavoriteAnimalCareTakers(new ArrayList<>());
//                }
//                userDto.getFavoriteAnimalCareTakers().add((AnimalCareTakerDto) dto);
//                updatedUser = userService.saveUser(userDto);
//                return new ResponseEntity<>(updatedUser, HttpStatus.OK);
////            break;
//
//        }
//
//        return null;
//    }
//
//    private ResponseEntity<UserDto> deleteFromFavoriteList(String username, Object dto, String type) {
//        Optional<UserDto> userOptional = userService.getUserByUsername(username.toLowerCase());
//        if (userOptional.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        UserDto userDto = userOptional.get();
//        switch (type) {
//            case "pet":
//                if (userDto.getFavoritePets() != null) {
//                    userDto.getFavoritePets().remove((PetDto) dto);
//                }
//                break;
//            case "shelter":
//                if (userDto.getFavoriteAnimalShelters() != null) {
//                    userDto.getFavoriteAnimalShelters().remove((AnimalShelterDto) dto);
//                }
//                break;
//            case "careTaker":
//                if (userDto.getFavoriteAnimalCareTakers() != null) {
//                    userDto.getFavoriteAnimalCareTakers().remove((AnimalCareTakerDto) dto);
//                }
//                break;
//        }
//
//        UserDto updatedUser = userService.saveUser(userDto);
//        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
//    }

}

