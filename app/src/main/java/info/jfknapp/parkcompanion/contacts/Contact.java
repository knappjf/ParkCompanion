package info.jfknapp.parkcompanion.contacts;

public class Contact {
    private String name, fullName, park, phone, title;

    public Contact(String name, String fullName, String park, String phone, String title) {
        this.name = name;
        this.fullName = fullName;
        this.park = park;
        this.phone = phone;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPark() {
        return park;
    }

    public void setPark(String park) {
        this.park = park;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
