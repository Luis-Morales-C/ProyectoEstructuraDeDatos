package Proceso.Controllers;
import Proceso.AppPrincipal;
import Proceso.Model.Tool;
import Proceso.Exception.IncompleteDataException;
import Proceso.Exception.UserDoesntExistException;
import Proceso.Utils.ShowMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

public class InicioController {


    Tool tool = AppController.INSTANCE.getHerramienta();
    AppPrincipal appPrincipal;
    @FXML
    private Button btnGetIntoLogin;

    @FXML
    private Hyperlink hyperlinkManagerLogin;

    @FXML
    private Hyperlink hyperlinkRegisterLogin;

    @FXML
    private TextField txtIdLogin;

    @FXML
    private TextField txtPasswordLogin;

    @FXML
    void clickedGetIntoLogin(ActionEvent event) {
        String email = "";
        String password = "";

        email = txtIdLogin.getText();
        password = txtPasswordLogin.getText();
        try {
            if (datosValidos(email, password)) {
                if (tool.searchUser(email).getPassword().equals(password)) {
                    AppController.INSTANCE.setUsuarioActual(tool.searchUser(email));

                    AppPrincipal.mostrarVentanaProcesosAdmin();
                } else {
                    throw new UserDoesntExistException();
                }
            } else {
                throw new IncompleteDataException();
            }
        } catch (IncompleteDataException e) {
            ShowMessage.mostrarMensaje("Notificacion Inicio sesion", "Datos Incompletos", "Debe ingresar los datos correctamente, despues de 3 intentos se bloqueara el usuario");
        } catch (UserDoesntExistException e) {
            ShowMessage.mostrarMensaje("Notificacion Inicio sesion", "Usuario no existe", "El usuario no existe o la contrasenia es incorrecta");
        }
    }


    @FXML
    void clickedManagerLogin(ActionEvent event) {
        appPrincipal.mostrarVentanaLoginAdmin();
    }

    @FXML
    void clickedRegisterLogin(ActionEvent event) {
        appPrincipal.mostrarVentanaRegistrarse();

    }

    public void setAplicacion(AppPrincipal principal) {
        this.appPrincipal = principal;
    }

    private boolean datosValidos(String userName, String password) {
        return !userName.isEmpty() && !password.isEmpty();
    }


    /**
     * falta el initialize
     */



}