package Exception;

public class TareaExistenteException extends Throwable {

    public TareaExistenteException(){
        super("La tarea ya existe");
    }
}
