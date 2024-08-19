package ikrah.io.springProject.model.dto;

import java.util.Objects;

public class AnimalShelterDto {
    private String shelterName;
    private String location;
    private String phoneNumber;
    private String email;
    private String description;
    private int countOfLike;
    private String imgPath;

    public AnimalShelterDto() {
    }

    public AnimalShelterDto(String shelterName, String location, String phoneNumber, String email, String description, int countOfLike, String imgPath) {
        this.shelterName = shelterName;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.description = description;
        this.countOfLike = countOfLike;
        this.imgPath = imgPath;
    }

    public String getShelterName() {
        return shelterName;
    }

    public void setShelterName(String shelterName) {
        this.shelterName = shelterName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCountOfLike() {
        return countOfLike;
    }

    public void setCountOfLike(int countOfLike) {
        this.countOfLike = countOfLike;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalShelterDto that = (AnimalShelterDto) o;
        return Objects.equals(shelterName, that.shelterName) && Objects.equals(location, that.location) && Objects.equals(imgPath, that.imgPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shelterName, location, imgPath);
    }

    @Override
    public String toString() {
        return "{shelterName='%s', location='%s', phoneNumber='%s', email='%s', description='%s', countOfLike=%d, imgPath='%s'}".formatted(shelterName, location, phoneNumber, email, description, countOfLike, imgPath);
    }
}
