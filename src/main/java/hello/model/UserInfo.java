package hello.model;

import java.util.List;
import java.util.Objects;

public class UserInfo {

    private List<FullAlbum> albums;
    private List<Band> bands;

    public UserInfo(List<FullAlbum> albums, List<Band> bands) {
        this.albums = albums;
        this.bands = bands;
    }

    public List<FullAlbum> getAlbums() {
        return albums;
    }

    public void setAlbums(List<FullAlbum> albums) {
        this.albums = albums;
    }

    public List<Band> getBands() {
        return bands;
    }

    public void setBands(List<Band> bands) {
        this.bands = bands;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserInfo)) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(getAlbums(), userInfo.getAlbums()) &&
                Objects.equals(getBands(), userInfo.getBands());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getAlbums(), getBands());
    }
}
