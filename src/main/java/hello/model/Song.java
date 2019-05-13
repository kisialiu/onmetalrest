package hello.model;

import java.util.Objects;

public class Song {
    private String title;
    private String length;

    public Song(String title, String length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song)) return false;
        Song song = (Song) o;
        return Objects.equals(getTitle(), song.getTitle()) &&
                Objects.equals(getLength(), song.getLength());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getTitle(), getLength());
    }
}
