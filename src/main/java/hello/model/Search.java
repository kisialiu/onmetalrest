package hello.model;

public class Search {

    private String name;
    private String id;
    private String genre;
    private String country;

    public Search(String name, String id, String genre, String country) {
        this.name = name;
        this.id = id;
        this.genre = genre;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Search)) return false;

        Search search = (Search) o;

        if (getName() != null ? !getName().equals(search.getName()) : search.getName() != null) return false;
        if (getId() != null ? !getId().equals(search.getId()) : search.getId() != null) return false;
        if (getGenre() != null ? !getGenre().equals(search.getGenre()) : search.getGenre() != null) return false;
        return getCountry() != null ? getCountry().equals(search.getCountry()) : search.getCountry() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getGenre() != null ? getGenre().hashCode() : 0);
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        return result;
    }
}
