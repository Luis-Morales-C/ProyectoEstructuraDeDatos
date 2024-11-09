package Model;

import java.util.ArrayList;
import java.util.List;
import Exception.ActivityAlreadyExistsException;
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

    }




    /**
     *Metodo que busca actividades por el nombre
     */

    public Activity searchActivityByName(String name)






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
}
