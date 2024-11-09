package Model;

import java.util.Objects;

public class Task {

    private String name;
    private String description;
    private Boolean obligatory;
    private Boolean status;
    private int time;

    public Task(String name, String description, Boolean obligatory, Boolean status, int time) {
        this.name = name;
        this.description = description;
        this.obligatory = obligatory;
        this.status = status;
        this.time = time;
    }

    public String getname() {
        return name;
    }

    public String getdescription() {
        return description;
    }

    public Boolean getobligatory() {
        return obligatory;
    }

    public Boolean getstatus() {
        return status;
    }

    public int gettime() {
        return time;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public void setobligatory(Boolean obligatory) {
        this.obligatory = obligatory;
    }

    public void setstatus(Boolean status) {
        this.status = status;
    }

    public void settime(int time) {
        this.time = time;
    }

}