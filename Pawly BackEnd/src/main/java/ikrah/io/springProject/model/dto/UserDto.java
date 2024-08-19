package ikrah.io.springProject.model.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserDto {

    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String password;
//    private List<PetDto> favoritePets;
//    private List<AnimalShelterDto> favoriteAnimalShelters;
//    private List<AnimalCareTakerDto> favoriteAnimalCareTakers;


    public UserDto() {
//        this.favoritePets = new ArrayList<>();
//        this.favoriteAnimalShelters = new ArrayList<>();
//        this.favoriteAnimalCareTakers = new ArrayList<>();
    }

    public UserDto(String name, String surname, String email, String phoneNumber, String password, List<PetDto> favoritePets, List<AnimalShelterDto> favoriteAnimalShelters, List<AnimalCareTakerDto> favoriteAnimalCareTakers) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
//        this.favoritePets = favoritePets != null ? favoritePets : new ArrayList<>();
//        this.favoriteAnimalShelters = favoriteAnimalShelters != null ? favoriteAnimalShelters : new ArrayList<>();
//        this.favoriteAnimalCareTakers = favoriteAnimalCareTakers != null ? favoriteAnimalCareTakers : new ArrayList<>();
    }

    //getters and setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public List<PetDto> getFavoritePets() {
//        return favoritePets;
//    }
//
//    public void setFavoritePets(List<PetDto> favoritePets) {
//        this.favoritePets = favoritePets;
//    }
//
//    public List<AnimalShelterDto> getFavoriteAnimalShelters() {
//        return favoriteAnimalShelters;
//    }
//
//    public void setFavoriteAnimalShelters(List<AnimalShelterDto> favoriteAnimalShelters) {
//        this.favoriteAnimalShelters = favoriteAnimalShelters;
//    }
//
//    public List<AnimalCareTakerDto> getFavoriteAnimalCareTakers() {
//        return favoriteAnimalCareTakers;
//    }
//
//    public void setFavoriteAnimalCareTakers(List<AnimalCareTakerDto> favoriteAnimalCareTakers) {
//        this.favoriteAnimalCareTakers = favoriteAnimalCareTakers;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(name, userDto.name) && Objects.equals(surname, userDto.surname) && Objects.equals(email, userDto.email) && Objects.equals(password, userDto.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, email, password);
    }

    @Override
    public String toString() {
        return "{name='%s', surname='%s', email='%s', phoneNumber='%s', password='%s', favoritePets=%s, favoriteAnimalShelters=%s, favoriteAnimalCareTakers=%s}".formatted(name, surname, email, phoneNumber, password);
    }
}
