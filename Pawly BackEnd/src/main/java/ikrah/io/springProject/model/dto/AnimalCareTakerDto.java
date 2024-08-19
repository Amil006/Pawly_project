package ikrah.io.springProject.model.dto;

import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class AnimalCareTakerDto {
    private String name;
    private String surname;
    private String location;
    private String phoneNumber;
    private String imgPath;
    private String description;
    private int payment;


    public AnimalCareTakerDto() {
    }

    public AnimalCareTakerDto(String name, String surname, String location, String phoneNumber, String imgPath, String description, int payment) {
        this.name = name;
        this.surname = surname;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.imgPath = imgPath;
        this.description = description;
        this.payment = payment;
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

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalCareTakerDto that = (AnimalCareTakerDto) o;
        return Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(imgPath, that.imgPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, imgPath);
    }

    @Override
    public String toString() {
        return "{name='%s', surname='%s', location='%s', phoneNumber='%s', imgPath='%s', description='%s', payment=%d}".formatted(name, surname, location, phoneNumber, imgPath, description, payment);
    }
}
