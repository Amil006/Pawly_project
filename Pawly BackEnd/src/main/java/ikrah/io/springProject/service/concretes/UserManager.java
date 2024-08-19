package ikrah.io.springProject.service.concretes;

import ikrah.io.springProject.dao.impl.UserStreamFileDao;
import ikrah.io.springProject.model.dto.UserDto;
import ikrah.io.springProject.model.entity.UserEntity;
import ikrah.io.springProject.service.abstracts.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class UserManager implements UserService {

    private final UserStreamFileDao userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserManager(UserStreamFileDao userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserDto> getAllUsers() {
        try {
            List<UserEntity> userEntities = userRepository.getAll();
            return userEntities.stream()
                    .map(userEntity -> modelMapper.map(userEntity, UserDto.class))
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Users could not be retrieved.", e);
        }
    }

    @Override
    public Optional<UserDto> getUserByUsername(String username) {
        Optional<UserEntity> userEntityOptional = userRepository.findBy(user -> user.getName().toLowerCase().equals(username));
        return userEntityOptional.map(userEntity -> modelMapper.map(userEntity, UserDto.class));
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
        try {
            userRepository.save(userEntity);
            return modelMapper.map(userEntity, UserDto.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("User could not be saved.", e);
        }
    }

    @Override
    public void deleteUser(String username, String password) {
        userRepository.deleteByUsernamePassword(username, password);
    }

    @Override
    public Optional<UserDto> getUserBy(Predicate<UserDto> predicate) {
        Optional<UserEntity> userEntityOptional = userRepository.findBy(userEntity -> predicate.test(modelMapper.map(userEntity, UserDto.class)));
        return userEntityOptional.map(userEntity -> modelMapper.map(userEntity, UserDto.class));
    }

    @Override
    public Optional<UserDto> authenticateUser(String username, String password) {
        List<UserEntity> users;
        try {
            users = userRepository.getAll();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Optional<UserDto> authenticatedUser = users.stream()
                .filter(user -> user.getName().toLowerCase().equals(username) && user.getPassword().toLowerCase().equals(password))
                .findFirst()
                .map(userEntity -> modelMapper.map(userEntity, UserDto.class));

        return authenticatedUser;
    }

//    @Override
//    public UserDto addToFavorites(String email, String type, Object dto) throws FileNotFoundException {
//        UserEntity userEntity = userRepository.addToFavorites(email, type, dto);
//        return convertToDto(userEntity);
//    }
//
//    @Override
//    public UserDto removeFromFavorites(String email, String type, Object dto) throws FileNotFoundException {
//        UserEntity userEntity = userRepository.removeFromFavorites(email, type, dto);
//        return convertToDto(userEntity);
//    }

    private UserDto convertToDto(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserDto.class);
    }

    private UserEntity convertToEntity(UserDto userDto) {
        return modelMapper.map(userDto, UserEntity.class);
    }

}
