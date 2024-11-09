package Exception;

public class ActividadExistenteException extends Exception{

    public ActividadExistenteException(){
        super("La actividad ya existe");
    }
}
