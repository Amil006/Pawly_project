package ikrah.io.springProject.model.entity;

public class AnimalShelterEntity {
    private static long idCounter = 0;
    private long id;
    private String shelterName;
    private String location;
    private String phoneNumber;
    private String email;
    private String description;
    private int countOfLike;
    private String imgPath;

    public AnimalShelterEntity() {
        this.id = ++idCounter;
    }

    public AnimalShelterEntity(String shelterName, String location, String phoneNumber, String email, String description, int countOfLike, String imgPath) {
        this.id = ++idCounter;
        this.shelterName = shelterName;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.description = description;
        this.countOfLike = countOfLike;
        this.imgPath = imgPath;
    }

    public long getId() {
        return id;
    }
    public void setId(long id ){
        this.id = id;
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
    public String toString() {
        return "{id=%d, shelterName='%s', location='%s', phoneNumber='%s', email='%s', description='%s', countOfLike=%d, imgPath='%s'}".formatted(id, shelterName, location, phoneNumber, email, description, countOfLike, imgPath);
    }
}
