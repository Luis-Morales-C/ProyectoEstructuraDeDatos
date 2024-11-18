package Controllers;

import Model.Activity;
import Model.Tool;
import Model.User;
import Model.Process;
public enum AppController {

    INSTANCE();
    private final Tool herramienta;
    private User usuario;
    private Process process;
    private Activity actividad;

    AppController() {
        this.actividad = null;
        this.process = null;
        this.usuario = null;
        herramienta = new Tool("ADAN");
    }

    public Tool getHerramienta() {
        return herramienta;
    }
    public void setProcesoActual(Process process){
        this.process = process;
    }
    public Process getProcesoActual(){
        return process;
    }
    public void setActividadActual(Activity actividad){
        this.actividad = actividad;
    }
    public Activity getActividadActual(){
        return actividad;
    }
    public void setUsuarioActual(User usuario){
        this.usuario = usuario;
    }
    public User getUsuarioActual(){
        return usuario;
    }
}
