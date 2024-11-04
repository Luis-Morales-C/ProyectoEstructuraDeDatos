package Model;

import Utils.TaskQueue;

import java.util.Queue;

public class Activity {

    private String name;
    private String description;
    private Boolean obligatory;

    private TaskQueue<Task> tasks;

    public Activity(String name, String description, Boolean obligatory) {
        this.name = name;
        this.description = description;
        this.obligatory = obligatory;

    }
    public Activity(String name){
        super();
        this.name=name;
        obligatory=false;
    }

    //metodos ----------------------------------------------------------------------------------------------------




    //------------------------------------------------------------------------------------------------------------
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getObligatory() {
        return obligatory;
    }

    public TaskQueue<Task> getTasks() {
        return tasks;
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

    public void setTasks(TaskQueue<Task> tasks) {
        this.tasks = tasks;
    }
}