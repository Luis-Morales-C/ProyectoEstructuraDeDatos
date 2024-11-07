package model;

import java.util.Objects;

public class Task1 {

    private String name;
    private String description;
    private Boolean isMandatory;
    private int durationTime;
    private Boolean isCompleted;

    public Task1(String name, String description, Boolean isMandatory, int durationTime, Boolean isCompleted) {
        this.name = name;
        this.description = description;
        this.isMandatory = isMandatory;
        this.durationTime = durationTime;
        this.isCompleted = isCompleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getMandatory() {
        return isMandatory;
    }

    public void setMandatory(Boolean mandatory) {
        isMandatory = mandatory;
    }

    public int getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(int durationTime) {
        this.durationTime = durationTime;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted() {
        isCompleted = true;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Task1 task1 = (Task1) o;
        return durationTime == task1.durationTime && Object.equals(description, task1.description) && Object.equals(isMandatory, task1.isMandatory);
    }

    @Override
    public int hashCode(){
        return Object.hash(description, isMandatory, durationTime);
    }

    @Override
    public String toString() {
        return "Task{" +
                "description = " + description + '\'' +
                ", isMandatory = " + isMandatory +
                ", durationTime = " + durationTime +
                '}';
    }
}
