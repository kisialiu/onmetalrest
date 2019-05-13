package hello.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document(collection = "bands")
public class Band {

    @Id
    private String id;
    private BandDetails details;
    private String bandName;
    private String logo;
    private String photo;
    private String bio;
    private List<Album> discography;
    private List<Member> currentLineup;
    private Integer likes;

    public Band(String id, BandDetails details, String bandName, String logo, String photo, String bio, List<Album> discography, List<Member> currentLineup, Integer likes) {
        this.id = id;
        this.details = details;
        this.bandName = bandName;
        this.logo = logo;
        this.photo = photo;
        this.bio = bio;
        this.discography = discography;
        this.currentLineup = currentLineup;
        this.likes = likes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BandDetails getDetails() {
        return details;
    }

    public void setDetails(BandDetails details) {
        this.details = details;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<Album> getDiscography() {
        return discography;
    }

    public void setDiscography(List<Album> discography) {
        this.discography = discography;
    }

    public List<Member> getCurrentLineup() {
        return currentLineup;
    }

    public void setCurrentLineup(List<Member> currentLineup) {
        this.currentLineup = currentLineup;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public void addLike() {
        if (likes == null) {
            likes = 1;
        } else {
            likes++;
        }
    }

    public void removeLike() {
        if (likes == null) {
            likes = 0;
        } else {
            likes--;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Band)) return false;
        Band band = (Band) o;
        return Objects.equals(getId(), band.getId()) &&
                Objects.equals(getDetails(), band.getDetails()) &&
                Objects.equals(getBandName(), band.getBandName()) &&
                Objects.equals(getLogo(), band.getLogo()) &&
                Objects.equals(getPhoto(), band.getPhoto()) &&
                Objects.equals(getBio(), band.getBio()) &&
                Objects.equals(getDiscography(), band.getDiscography()) &&
                Objects.equals(getCurrentLineup(), band.getCurrentLineup()) &&
                Objects.equals(getLikes(), band.getLikes());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getDetails(), getBandName(), getLogo(), getPhoto(), getBio(), getDiscography(), getCurrentLineup(), getLikes());
    }
}
