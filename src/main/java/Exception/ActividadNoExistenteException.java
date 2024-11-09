package Exception;

public class ActividadNoExistenteException extends Throwable {

    public ActividadNoExistenteException(){

        super("La actividad no existe");

    }
}
