package hello.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.Objects;

@Document(collection = "albums")
public class FullAlbum {

    @Id
    private String id;
    private ShortBand band;
    private String title;
    private String album_cover;
    private String type;
    @Field("release date")
    private String releaseDate;
    private String catalogId;
    private String label;
    private String format;
    private String reviews;
    private List<Song> songs;
    private Integer likes;

    public FullAlbum(String id,
                     ShortBand band,
                     String title,
                     String album_cover,
                     String type,
                     String releaseDate,
                     String catalogId,
                     String label,
                     String format,
                     String reviews,
                     List<Song> songs,
                     Integer likes) {
        this.id = id;
        this.band = band;
        this.title = title;
        this.album_cover = album_cover;
        this.type = type;
        this.releaseDate = releaseDate;
        this.catalogId = catalogId;
        this.label = label;
        this.format = format;
        this.reviews = reviews;
        this.songs = songs;
        this.likes = likes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ShortBand getBand() {
        return band;
    }

    public void setBand(ShortBand band) {
        this.band = band;
    }

    public List<Song> getSongs() {

        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public String getAlbum_cover() {
        return album_cover;

    }

    public void setAlbum_cover(String album_cover) {
        this.album_cover = album_cover;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
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
        likes--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FullAlbum)) return false;
        FullAlbum fullAlbum = (FullAlbum) o;
        return Objects.equals(getId(), fullAlbum.getId()) &&
                Objects.equals(getBand(), fullAlbum.getBand()) &&
                Objects.equals(getTitle(), fullAlbum.getTitle()) &&
                Objects.equals(getAlbum_cover(), fullAlbum.getAlbum_cover()) &&
                Objects.equals(getType(), fullAlbum.getType()) &&
                Objects.equals(getReleaseDate(), fullAlbum.getReleaseDate()) &&
                Objects.equals(getCatalogId(), fullAlbum.getCatalogId()) &&
                Objects.equals(getLabel(), fullAlbum.getLabel()) &&
                Objects.equals(getFormat(), fullAlbum.getFormat()) &&
                Objects.equals(getReviews(), fullAlbum.getReviews()) &&
                Objects.equals(getSongs(), fullAlbum.getSongs()) &&
                Objects.equals(getLikes(), fullAlbum.getLikes());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getBand(), getTitle(), getAlbum_cover(), getType(), getReleaseDate(), getCatalogId(), getLabel(), getFormat(), getReviews(), getSongs(), getLikes());
    }
}
