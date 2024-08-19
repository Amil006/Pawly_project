package ikrah.io.springProject.model.entity;

import java.util.Objects;

public class VeterinarianEntity {
    private static long idCounter = 0;
    private long id;
    private String name;
    private String surname;
    private String phoneNumber;
    private int payment;
    private String location;
    private String description;
//    int countOfLike;
    private String imgPath;

    public VeterinarianEntity(long id) {
        this.id = ++idCounter;
    }

    public VeterinarianEntity( String name, String surname, String phoneNumber, int payment, String location, String description, String imgPath) {
        this.id = ++idCounter;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.payment = payment;
        this.location = location;
        this.description = description;
//        this.countOfLike = countOfLike;
        this.imgPath = imgPath;
    }

    public long getId() {
        return id;
    }
    public void setId(long id){
        this.id = id;
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
        VeterinarianEntity that = (VeterinarianEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{id=%d, name='%s', surname='%s', phoneNumber='%s', payment=%d, location='%s', description='%s', countOfLike=%d, imgPath='%s'}".formatted(id, name, surname, phoneNumber, payment, location, description, imgPath);
    }
}
