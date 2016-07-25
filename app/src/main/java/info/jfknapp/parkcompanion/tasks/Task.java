package info.jfknapp.parkcompanion.tasks;

public class Task {
    private String name;
    private String description;
    private String park;

    public Task(String name, String description, String park) {
        this.name = name;
        this.description = description;
        this.park = park;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPark(String park) {
        this.park = park;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPark() {
        return park;
    }
}
