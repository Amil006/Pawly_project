package ikrah.io.springProject.service.abstracts;

import ikrah.io.springProject.model.dto.UserDto;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface UserService {

    List<UserDto> getAllUsers();

    Optional<UserDto> getUserByUsername(String username);

    UserDto saveUser(UserDto userDto);

    void deleteUser(String username, String password);

    Optional<UserDto> getUserBy(Predicate<UserDto> predicate);

    Optional<UserDto> authenticateUser(String username, String password);

//    UserDto addToFavorites(String email, String type, Object dto) throws FileNotFoundException;
//
//    UserDto removeFromFavorites(String email, String type, Object dto) throws FileNotFoundException;
}
