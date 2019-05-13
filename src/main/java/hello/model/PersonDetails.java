package hello.model;

import java.util.List;
import java.util.Objects;

public class PersonDetails {
    private String bio;
    private String photo;
    private List<ShortBand> active;
    private List<ShortBand> past;
    private List<ShortBand> guest;
    private String realName;
    private String age;
    private String placeOfOrigin;
    private String gender;

    public PersonDetails(String bio, String photo, List<ShortBand> active, List<ShortBand> past, List<ShortBand> guest, String realName, String age, String placeOfOrigin, String gender) {
        this.bio = bio;
        this.photo = photo;
        this.active = active;
        this.past = past;
        this.guest = guest;
        this.realName = realName;
        this.age = age;
        this.placeOfOrigin = placeOfOrigin;
        this.gender = gender;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<ShortBand> getActive() {
        return active;
    }

    public void setActive(List<ShortBand> active) {
        this.active = active;
    }

    public List<ShortBand> getPast() {
        return past;
    }

    public void setPast(List<ShortBand> past) {
        this.past = past;
    }

    public List<ShortBand> getGuest() {
        return guest;
    }

    public void setGuest(List<ShortBand> guest) {
        this.guest = guest;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonDetails)) return false;
        PersonDetails that = (PersonDetails) o;
        return Objects.equals(getBio(), that.getBio()) &&
                Objects.equals(getPhoto(), that.getPhoto()) &&
                Objects.equals(getActive(), that.getActive()) &&
                Objects.equals(getPast(), that.getPast()) &&
                Objects.equals(getGuest(), that.getGuest()) &&
                Objects.equals(getRealName(), that.getRealName()) &&
                Objects.equals(getAge(), that.getAge()) &&
                Objects.equals(getPlaceOfOrigin(), that.getPlaceOfOrigin()) &&
                Objects.equals(getGender(), that.getGender());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getBio(), getPhoto(), getActive(), getPast(), getGuest(), getRealName(), getAge(), getPlaceOfOrigin(), getGender());
    }
}
