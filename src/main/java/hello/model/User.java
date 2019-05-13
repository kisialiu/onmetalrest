package hello.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document(collection = "users")
public class User {

    @Id
    private String id;
    private String email;
    private String photoUrl;
    private List<String> likedBands = new ArrayList<>();
    private List<String> likedAlbums = new ArrayList<>();
    private String type;

    public User() {

    }

    public User(String id, String email, String photoUrl, List<String> likedBands, List<String> likedAlbums, String type) {
        this.id = id;
        this.email = email;
        this.photoUrl = photoUrl;
        this.likedBands = likedBands;
        this.likedAlbums = likedAlbums;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public List<String> getLikedBands() {
        return likedBands;
    }

    public void setLikedBands(List<String> likedBands) {
        this.likedBands = likedBands;
    }

    public List<String> getLikedAlbums() {
        return likedAlbums;
    }

    public void setLikedAlbums(List<String> likedAlbums) {
        this.likedAlbums = likedAlbums;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getPhotoUrl(), user.getPhotoUrl()) &&
                Objects.equals(getLikedBands(), user.getLikedBands()) &&
                Objects.equals(getLikedAlbums(), user.getLikedAlbums()) &&
                Objects.equals(getType(), user.getType());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getEmail(), getPhotoUrl(), getLikedBands(), getLikedAlbums(), getType());
    }
}
