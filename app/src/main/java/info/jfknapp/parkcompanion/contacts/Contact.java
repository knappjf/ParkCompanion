package info.jfknapp.parkcompanion.contacts;

public class Contact {
    private String name, park, phone, title;

    public Contact(String name, String park, String phone, String title) {
        if(name == null){
            this.name = "";
        }
        else{
            this.name = name;
        }

        if(park == null){
            this.park = "";
        }
        else{
            this.park = park;
        }

        if(phone == null){
            this.phone = "";
        }
        else{
            this.phone = phone;
        }

        if(title == null){
            this.title = "";
        }
        else{
            this.title = title;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
