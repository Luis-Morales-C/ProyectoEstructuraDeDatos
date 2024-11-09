package Exception;

public class ProcessAlreadyExist extends Throwable{

    public ProcessAlreadyExist(){
        super("El proceso ya existe");
    }
}
