package ikrah.io.springProject.model.entity;

import ikrah.io.springProject.model.dto.AnimalCareTakerDto;
import ikrah.io.springProject.model.dto.AnimalShelterDto;

import java.util.List;

public class UserEntity {
    static long idCounter = 0;
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String password;
//    private List<PetEntity> favoritePets;
//    private List<AnimalShelterEntity> favoriteAnimalShelters;
//    private List<AnimalCareTakerEntity> favoriteAnimalCareTakers;

    public UserEntity() {
        this.id = ++idCounter;
    }

    public UserEntity(String name, String surname, String email, String phoneNumber, String password, List<PetEntity> favoritePets, List<AnimalShelterEntity> favoriteAnimalShelters, List<AnimalCareTakerEntity> favoriteAnimalCareTakers) {
        this.id = ++idCounter;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
//        this.favoritePets = favoritePets;
//        this.favoriteAnimalShelters = favoriteAnimalShelters;
//        this.favoriteAnimalCareTakers = favoriteAnimalCareTakers;
    }



    public Long getId() {
        return id;
    }




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

//    public List<PetEntity> getFavoritePets() {
//        return favoritePets;
//    }
//
//    public void setFavoritePets(List<PetEntity> favoritePets) {
//        this.favoritePets = favoritePets;
//    }
//
//    public List<AnimalShelterEntity> getFavoriteAnimalShelters() {
//        return favoriteAnimalShelters;
//    }
//
//    public void setFavoriteAnimalShelters(List<AnimalShelterEntity> favoriteAnimalShelters) {
//        this.favoriteAnimalShelters = favoriteAnimalShelters;
//    }
//
//    public List<AnimalCareTakerEntity> getFavoriteAnimalCareTakers() {
//        return favoriteAnimalCareTakers;
//    }
//
//    public void setFavoriteAnimalCareTakers(List<AnimalCareTakerEntity> favoriteAnimalCareTakers) {
//        this.favoriteAnimalCareTakers = favoriteAnimalCareTakers;
//    }

    @Override
    public String toString() {
        return "{id=%d, name='%s', surname='%s', email='%s', phoneNumber='%s', password='%s', favoritePets=%s, favoriteAnimalShelters=%s, favoriteAnimalCareTakers=%s}".formatted(id, name, surname, email, phoneNumber, password);
    }
}
