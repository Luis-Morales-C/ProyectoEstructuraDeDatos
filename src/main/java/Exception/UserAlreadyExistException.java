package Exception;

public class UserAlreadyExistException extends Throwable{

    public UserAlreadyExistException(){
        super("El usuario ya existe");
    }

}
