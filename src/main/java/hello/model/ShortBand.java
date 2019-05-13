package hello.model;

import java.util.Objects;

public class ShortBand {
    private String _id;
    private String name;

    public ShortBand(String _id, String name) {
        this._id = _id;
        this.name = name;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShortBand)) return false;
        ShortBand shortBand = (ShortBand) o;
        return Objects.equals(get_id(), shortBand.get_id()) &&
                Objects.equals(getName(), shortBand.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(get_id(), getName());
    }
}
