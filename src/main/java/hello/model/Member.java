package hello.model;

import java.util.List;

public class Member {
    private String id;
    private String name;
    private Boolean current;
    private List<String> instruments;

    public Member(String id, String name, Boolean current, List<String> instruments) {
        this.id = id;
        this.name = name;
        this.current = current;
        this.instruments = instruments;
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

    public Boolean getCurrent() {
        return current;
    }

    public void setCurrent(Boolean current) {
        this.current = current;
    }

    public List<String> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<String> instruments) {
        this.instruments = instruments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member)) return false;

        Member member = (Member) o;

        if (getId() != null ? !getId().equals(member.getId()) : member.getId() != null) return false;
        if (getName() != null ? !getName().equals(member.getName()) : member.getName() != null) return false;
        if (getCurrent() != null ? !getCurrent().equals(member.getCurrent()) : member.getCurrent() != null)
            return false;
        return getInstruments() != null ? getInstruments().equals(member.getInstruments()) : member.getInstruments() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getCurrent() != null ? getCurrent().hashCode() : 0);
        result = 31 * result + (getInstruments() != null ? getInstruments().hashCode() : 0);
        return result;
    }
}
