package model;

import exception.TaskAlreadyExistException;
import utils.ShowMessage;
import utils.TaskQueue;

import java.util.Objects;

public class Activity {
    private String name;
    private String description;
    private Boolean isMandatory; //Es obligatoria
    private int durationTime = 0;
    private int minimumTime = 0;
    private TaskQueue<Task1> task1List = new TaskQueue<>();

    public Activity(String name, String description, Boolean isMandatory) {
        this.name = name;
        this.description = description;
        this.isMandatory = isMandatory;
    }

    public Activity(String name){
        super();
        this.name = name;
        isMandatory = false;
    }

    public Task1 searchTaskName(){
        for(Task1 task1 : task1List){
            if(task1.getName().equals(taskName)){
                return task1;
            }
        }
        return null;
    }

    public void createTask(String name, String description, Boolean isMandatory, int durationTime){
        try{
            Task1 task1 = new Task1(name, description,isMandatory, durationTime);
            task1List.add(task1);
        }catch(TaskAlreadyExistException e){
            ShowMessage.mostrarMensaje("Error", "Error al craer la tarea", "La tarea ya existe");
        }
        calculateTimes();

    }

    public void createTask(Task1 task1){
        try{
            task1List.add(task1);
        }catch (TaskAlreadyException e){
            ShowMessage.mostrarMensaje("Error", "Error al crear la tarea", "La tarea ya existe");
        }
        calculateTimes();
    }

    public void completeTask(String taskName){
        Task1 task1 = searchTaskName(taskName);
        if(task1 != null)
            task1.setCompleted();
        calculateTimes();
    }

    public int getTotalTime(){
        int totalTime = 0;
        for(Task1 task1 : task1List){
            totalTime += task1.getDurationTime():
        }
        return totalTime;
    }

    public int getMinimumTime(){
        int totalTime = 0;
        for(Task1 task1 : task1List){
            if(!task1.getMandatory());
                totalTime += task1.getDurationTime();
        }
        return totalTime;
    }

    private void calculateTimes(){
        durationTime = getTotalTime();
        minimumTime = getMinimumTime();
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

    public void setMinimumTime(int minimumTime) {
        this.minimumTime = minimumTime;
    }

    public TaskQueue<Task1> getTask1List() {
        return task1List;
    }

    public void setTask1List(TaskQueue<Task1> task1List) {
        this.task1List = task1List;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return Objects.equals(name, activity.name) && Objects.equals(description, activity.description) && Objects.equals(isMandatory, activity.isMandatory);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, description, isMandatory);
    }

    @Override
    public String toString(){
        return "Activity{" +
                "name = " + name + '\'' +
                ", description = " + description + '\'' +
                ", isMandatory = " + isMandatory +
                '}';
    }
}
