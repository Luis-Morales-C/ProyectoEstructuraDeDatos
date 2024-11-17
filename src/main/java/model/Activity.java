package Model;

import Utils.ShowMessage;
import Utils.TaskQueue;

import Exception.TaskAlreadyExistException;

import java.util.Objects;

public class Activity {

    private String name;
    private String description;
    private Boolean obligatory;
    private int totalTime=0;
    private int minTime=0;

    private TaskQueue<Task> tasks= new TaskQueue<>();

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

        /**
         * Metodo que busca tareas por el nombre
         */
        public Task searchTaskByName(String name){
            for (Task task: tasks){
                if(task.getname().equals(name)){
                    return task;
                }
            }
            return null;
        }
    /**
     * Metodo que crea una tarea
     */

    public void createTask(String name, String description, Boolean obligatory, int time){

        try {
            Task task= new Task(name,description,obligatory,time);
            tasks.add(task);
        }catch (TaskAlreadyExistException e ){

            ShowMessage.mostrarMensaje("error","Error al crear la tarea","la tarea ya existe");
        }
        calculateTimes();
    }

    public void createTask(Task task){
        try {
            tasks.add(task);
        }catch (TaskAlreadyExistException e){
            ShowMessage.mostrarMensaje("Error","Error creando tarea","La tarea ya existe");
        }
        calculateTimes();
    }

    /**
     *Metodo que elimina una tarea
     */

    public void deleteTask(Task task){
        tasks.remove(tasks.searchIndex(task));
    }


    /**
     *Metodo que determina el tiempo total de la actividad y el otro el minimo
     * y se llama crea un metodo para llamar a ambos
     */

    public int calculateTotalTime() {
        int Totaltime = 0;
        for (Task task : tasks) {
            if (!task.getobligatory()) {
                Totaltime += task.gettime();
            }
        }
        return  Totaltime;
    }
    public int calculateMinTime() {
        int Mintime = 0;
        for (Task task : tasks) {
            if (!task.getobligatory()) {
                Mintime += task.gettime();
            }
        }
        return  Mintime;
    }

    public void calculateTimes(){
        totalTime= calculateTotalTime();
        minTime=calculateMinTime();

    }

    //------------------------------------------------------------------------------------------------------------
    //Getter y setter
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity actividad = (Activity) o;
        return Objects.equals(name, actividad.name) && Objects.equals(description, actividad.description) && Objects.equals(obligatory, actividad.obligatory);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, description, obligatory);
    }

    @Override
    public String toString() {
        return "Activity{"+
                "name='"+ name +'\'' +
                ", decription='"+ obligatory +
                '}';
    }
}