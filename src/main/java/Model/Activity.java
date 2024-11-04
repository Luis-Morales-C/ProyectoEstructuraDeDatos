package Model;

import java.util.Queue;

public class Activity {

    private String name;
    private String description;
    private Boolean obligatory;

    private Queue<Task> tasks;
    private Activity previous;
    private Activity next;

    public Activity(String name, String description, Boolean obligatory, Queue<Task> tasks, Activity previous, Activity next) {
        this.name = name;
        this.description = description;
        this.obligatory = obligatory;
        this.tasks = tasks;
        this.previous = previous;
        this.next = next;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getObligatory() {
        return obligatory;
    }

    public Queue<Task> getTasks() {
        return tasks;
    }

    public Activity getPrevious() {
        return previous;
    }

    public Activity getNext() {
        return next;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setObligatory(Boolean obligatory) {
        this.obligatory = obligatory;
    }

    public void setTasks(Queue<Task> tasks) {
        this.tasks = tasks;
    }

    public void setPrevious(Activity previous) {
        this.previous = previous;
    }

    public void setNext(Activity next) {
        this.next = next;
    }
}