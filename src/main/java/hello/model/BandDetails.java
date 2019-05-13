package hello.model;

public class BandDetails {

    private String country;
    private String location;
    private String status;
    private String formedIn;
    private String genre;
    private String lyricalThemes;
    private String currentLabel;
    private String yearsActive;

    public BandDetails(String country, String location, String status, String formedIn, String genre, String lyricalThemes, String currentLabel, String yearsActive) {
        this.country = country;
        this.location = location;
        this.status = status;
        this.formedIn = formedIn;
        this.genre = genre;
        this.lyricalThemes = lyricalThemes;
        this.currentLabel = currentLabel;
        this.yearsActive = yearsActive;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFormedIn() {
        return formedIn;
    }

    public void setFormedIn(String formedIn) {
        this.formedIn = formedIn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLyricalThemes() {
        return lyricalThemes;
    }

    public void setLyricalThemes(String lyricalThemes) {
        this.lyricalThemes = lyricalThemes;
    }

    public String getCurrentLabel() {
        return currentLabel;
    }

    public void setCurrentLabel(String currentLabel) {
        this.currentLabel = currentLabel;
    }

    public String getYearsActive() {
        return yearsActive;
    }

    public void setYearsActive(String yearsActive) {
        this.yearsActive = yearsActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BandDetails)) return false;

        BandDetails that = (BandDetails) o;

        if (getCountry() != null ? !getCountry().equals(that.getCountry()) : that.getCountry() != null) return false;
        if (getLocation() != null ? !getLocation().equals(that.getLocation()) : that.getLocation() != null)
            return false;
        if (getStatus() != null ? !getStatus().equals(that.getStatus()) : that.getStatus() != null) return false;
        if (getFormedIn() != null ? !getFormedIn().equals(that.getFormedIn()) : that.getFormedIn() != null)
            return false;
        if (getGenre() != null ? !getGenre().equals(that.getGenre()) : that.getGenre() != null) return false;
        if (getLyricalThemes() != null ? !getLyricalThemes().equals(that.getLyricalThemes()) : that.getLyricalThemes() != null)
            return false;
        if (getCurrentLabel() != null ? !getCurrentLabel().equals(that.getCurrentLabel()) : that.getCurrentLabel() != null)
            return false;
        return getYearsActive() != null ? getYearsActive().equals(that.getYearsActive()) : that.getYearsActive() == null;
    }

    @Override
    public int hashCode() {
        int result = getCountry() != null ? getCountry().hashCode() : 0;
        result = 31 * result + (getLocation() != null ? getLocation().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getFormedIn() != null ? getFormedIn().hashCode() : 0);
        result = 31 * result + (getGenre() != null ? getGenre().hashCode() : 0);
        result = 31 * result + (getLyricalThemes() != null ? getLyricalThemes().hashCode() : 0);
        result = 31 * result + (getCurrentLabel() != null ? getCurrentLabel().hashCode() : 0);
        result = 31 * result + (getYearsActive() != null ? getYearsActive().hashCode() : 0);
        return result;
    }
}
