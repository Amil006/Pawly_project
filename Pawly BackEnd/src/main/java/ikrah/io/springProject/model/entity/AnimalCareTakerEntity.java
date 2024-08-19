package ikrah.io.springProject.model.entity;

public class AnimalCareTakerEntity {
    private static long idCounter = 0;
    private long id;
    private String name;
    private String surname;
    private String location;
    private String phoneNumber;
    private String imgPath;
    private String description;
    private int payment;
    private int countOfLike;

    public AnimalCareTakerEntity() {
        this.id = ++idCounter;
    }

    public AnimalCareTakerEntity(String name, String surname, String location, String phoneNumber, String imgPath, String description, int payment, int countOfLike) {
        this.id = ++idCounter;
        this.name = name;
        this.surname = surname;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.imgPath = imgPath;
        this.description = description;
        this.payment = payment;
        this.countOfLike = countOfLike;
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

    public int getCountOfLike() {
        return countOfLike;
    }

    public void setCountOfLike(int countOfLike) {
        this.countOfLike = countOfLike;
    }

    @Override
    public String toString() {
        return "{id=%d, name='%s', surname='%s', location='%s', phoneNumber='%s', imgPath='%s', description='%s', payment=%d, countOfLike=%d}".formatted(id, name, surname, location, phoneNumber, imgPath, description, payment, countOfLike);
    }
}
