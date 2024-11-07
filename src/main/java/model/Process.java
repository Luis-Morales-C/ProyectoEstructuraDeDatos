package model;

import java.util.Objects;

public class Process {

    private String name;
    private String id;
    private int miniumTime;
    private int maximumTime;

    private ActivityList<Activity> activitysList;

    public Process(String name, String id){
        super();
        this.name = name;
        this.id = id;
        activitysList = new ActivityList<>();
    }

    //Metodos de la Lista de actividades---------
    public void addActivity(Activity activity) throws ActivityAlreadyExistException{
        if(!activitysList.contains(activity)){
            activitysList.add(activity);
        }else{
            try{
                throw new ActivityAlreadyExistException();
            } catch (ActivityAlreadyExistException e){
                ShowMessage.mostrarMensaje("Error", "Error al agregar la actividad", "La actividad ya existe");
            }
        }
        calculateTimes();
    }

    public void addActivity(Activity activity, String namePreviousActivity){
        if (!activitysList.contains(activity)) {
            try{
                activitysList.add(activity, searchActivityName(namePreviousActivity));
            } catch (ActivityDontExistException e){
                ShowMessage.mostrarMensaje("Error", "Error al agregar la actividad", "La actividad anterior");
            } catch (ActivityAlreadyExistException e){
                ShowMessage.mostrarMensaje("Error",  "Error al agregar la actividad", "La actividad ya existe");
            }
        }else{
            try {
                throw new ActivityAlreadyExistException();
            } catch (ActivityAlreadyExistException e) {
                ShowMessage.mostrarMensaje("Error", "Error al agregar la actividad", "La actividad ya existe");
            }
        }
        calculateTimes();
    }

    public Activity searchActivityName(String namePreviusActivity){
        for(Activity activity : activitysList){
            if(activity.getName().equals(namePreviusActivity)){
                return activity;
            }
        }
        return null;
    }

    public void deleteActivity(Activity activity) throws ActivityDontExistException{
        activitysList.remove(searchActivityName(activityName));
        calculateTimes();
    }

    public void deleteActivity(String activityName) throws ActivityDontExistException{
        activitysList.remove(searchActivityName(activityName));
        calculateTimes();
    }

    public int calculateMiniumTime(){
        int totalTime = 0;
        for (Activity activity : activitysList){
            totalTime += activity.getMinimumTime();
        }
        return totalTime;
    }

    public void updateActitvity(String name, String description){
        Activity activity = searchActivityName(name);
        if(activity != null){
            activity.setDescription((description));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMiniumTime() {
        return miniumTime;
    }

    public void setMiniumTime(int miniumTime) {
        this.miniumTime = miniumTime;
    }

    public int getMaximumTime() {
        return maximumTime;
    }

    public void setMaximumTime(int maximumTime) {
        this.maximumTime = maximumTime;
    }

    public ActivityList<Activity> getActivitysList() {
        return activitysList;
    }

    public void setActivitysList(ActivityList<Activity> activitysList) {
        this.activitysList = activitysList;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Process process = (Process) o;
        return miniumTime == process.miniumTime && maximumTime == process.maximumTime && Objects.equals(name, process.name) && Objects.equals(id, process.id);
    }

    @Override
    public  int hashCode(){
        return  Objects.hash(name, id, miniumTime, maximumTime);
    }

    @Override
    public String toString(){
        return "Process{" +
                "name = " + name +'\'' +
                ", id = " + '\'' +
                ", miniumTime = " + miniumTime +
                ", maxiumTime = " + maximumTime +
                "}";
    }
}
