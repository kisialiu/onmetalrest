package hello.model;

import org.springframework.data.annotation.Id;

public class Album {

    @Id
    private String id;
    private String name;
    private String type;
    private String year;

    public Album(String id, String name, String type, String year) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Album)) return false;

        Album disc = (Album) o;

        if (getId() != null ? !getId().equals(disc.getId()) : disc.getId() != null) return false;
        if (getName() != null ? !getName().equals(disc.getName()) : disc.getName() != null) return false;
        if (getType() != null ? !getType().equals(disc.getType()) : disc.getType() != null) return false;
        return getYear() != null ? getYear().equals(disc.getYear()) : disc.getYear() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getYear() != null ? getYear().hashCode() : 0);
        return result;
    }
}
