package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import Exception.ActivityAlreadyExistsException;
import Exception.ActivityDoesntExistException;
import Utils.ShowMessage;

public class Process {

    private String name;
    private String id;
    private int minTime;
    private int maxTime;
    private List<Activity>activities;

    public Process(String name, String id){
        super();
        this.name= name;
        this.id= id;
        activities= new ArrayList<>();

    }
    //Metodos-----------------------------------------------------------------------------------


    /**
     *Metodo que agrega actividades al proceso
     */
    public void addActivity(Activity activity)throws ActivityAlreadyExistsException {
        if(!activities.contains(activity)){
            activities.add(activity);
        }else {
            try {
                throw new ActivityAlreadyExistsException();
            }catch (ActivityAlreadyExistsException e){
                ShowMessage.mostrarMensaje("error","error al agregar una actividad", "la actividad ya existe");
            }
        }
        calculateTimes();
    }

    /**
     *Metodo que busca actividades por el nombre
     */

    public Activity searchActivityByName(String name){
        for (Activity activity: activities){
            if(activity.getName().equals(name)){
                return activity;
            }
        }
        return null;
    }
    /**
     * Calcular los tiempos
     */

    public int calculateMinTime(){
        int time=0;
        for (Activity activity: activities){
            time+= activity.calculateTotalTime();
        }
        return time;
    }
    public int calculateTotalTime(){
        int time=0;
        for (Activity activity: activities){
            time+=activity.calculateTotalTime();
        }
        return time;
    }
    public void calculateTimes(){
        minTime= calculateMinTime();
        maxTime= calculateTotalTime();
    }

    /**
     *Metodo que elimina una actividad
     */

    public void deleteActivity(Activity activity) throws ActivityDoesntExistException{
        activities.remove(activity);
        calculateTimes();
    }
    public void deleteActivity(String name) throws ActivityDoesntExistException{
        activities.remove(searchActivityByName(name));
        calculateTimes();
    }
    /**
     *Metodo que calcula los timepos de una actividad
     */

    public int calcularTiempoMin(){
        int tiempoTotal = 0;
        for (Activity actividad : activities) {
            tiempoTotal += actividad.calculateMinTime();
        }
        return tiempoTotal;
    }
    public int calcularTiempoTotal(){
        int tiempoTotal = 0;
        for (Activity actividad : activities) {
            tiempoTotal += actividad.calculateTotalTime();
        }
        return tiempoTotal;
    }

    /**
     *Metodo que actualiza una actividad
     */

    public void actualizarActividad(String nombre, String descripcion) {
        Activity actividad = searchActivityByName(nombre);
        if(actividad != null){
            actividad.setDescription(descripcion);
        }
    }

    //-------------------------------------------------------------------------------------------
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getMinTime() {
        return minTime;
    }

    public int getMaxTime() {
        return maxTime;
    }

    public List<Activity> getActivities() {
        return activities;
    }



    public void calculeTime(){
        minTime = calcularTiempoMin();
        maxTime = calcularTiempoTotal();
    }



    @Override
    public int hashCode() {
        return Objects.hash(name, id, minTime, maxTime, activities);
    }

    @Override
    public String toString() {
        return "Process{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", minTime=" + minTime +
                ", maxTime=" + maxTime +
                ", activities=" + activities +
                '}';
    }
}
