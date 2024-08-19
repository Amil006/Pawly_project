package ikrah.io.springProject.model.dto;

import java.util.Objects;

public class VeterinarianDto {
    private String name;
    private String surname;
    private String phoneNumber;
    private int payment;
    private String location;
    private String description;
//    int countOfLike;
    private String imgPath;

    public VeterinarianDto() {
    }

    public VeterinarianDto(String name, String surname, String phoneNumber, int payment, String location, String description, String imgPath) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.payment = payment;
        this.location = location;
        this.description = description;
//        this.countOfLike = countOfLike;
        this.imgPath = imgPath;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
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

//    public int getCountOfLike() {
//        return countOfLike;
//    }
//
//    public void setCountOfLike(int countOfLike) {
//        this.countOfLike = countOfLike;
//    }

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
        VeterinarianDto that = (VeterinarianDto) o;
        return Objects.equals(name, that.name) && Objects.equals(imgPath, that.imgPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, imgPath);
    }

    @Override
    public String toString() {
        return "{name='%s', surname='%s', phoneNumber='%s', payment=%d, location='%s', description='%s', countOfLike=%d, imgPath='%s'}".formatted(name, surname, phoneNumber, payment, location, description,imgPath);
    }
}
