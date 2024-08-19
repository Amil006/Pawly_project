package ikrah.io.springProject.model.dto;

import java.util.Objects;

public class PetDto {
    private String name;
    private String species; //it,pisik
    private String breed; //cinsi
    private String type; //buldok,tabby,pawly
    private int age;
    private String healthStatus;
    private String imgPath;
    private String location;
    private String description;
    private String phoneNumber;
    private int countOfLike;


    public PetDto() {
    }

    public PetDto(String name, String species, String breed, String type, int age, String healthStatus, String imgPath, String location, String description, String phoneNumber, int countOfLike) {
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.type = type;
        this.age = age;
        this.healthStatus = healthStatus;
        this.imgPath = imgPath;
        this.location = location;
        this.description = description;
        this.phoneNumber = phoneNumber;
        this.countOfLike = countOfLike;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getCountOfLike() {
        return countOfLike;
    }

    public void setCountOfLike(int countOfLike) {
        this.countOfLike = countOfLike;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetDto petDto = (PetDto) o;
        return age == petDto.age && Objects.equals(name, petDto.name) && Objects.equals(imgPath, petDto.imgPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, imgPath);
    }

    @Override
    public String toString() {
        return "{name='%s', species='%s', breed='%s', type='%s', age=%d, healthStatus='%s', imgPath='%s', location='%s', description='%s', phoneNumber='%s', countOfLike=%d}".formatted(name, species, breed, type, age, healthStatus, imgPath, location, description, phoneNumber, countOfLike);
    }
}
