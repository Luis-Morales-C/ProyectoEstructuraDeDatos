package Controllers;

import App.AppPrincipal;
import Model.NotificationType;
import Model.User;
import Model.UserType;
import Utils.ShowMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import Exception.IncompleteDataException;
import Exception.IncorrectDataException;
import  static Controllers.AppController.INSTANCE;

public class SettingsViewController {

    User user= INSTANCE.getUsuarioActual();

    AppPrincipal appPrincipal;

    @FXML
    private ImageView backSettings;

    @FXML
    private Button btnSaveSettings;

    @FXML
    private ComboBox<UserType> comboBoxUserTypeSettings;

    @FXML
    private ComboBox<NotificationType> comoBoxNotificationTypeSettings;

    @FXML
    private TextField txtMailSettings;

    @FXML
    private TextField txtNameSettings;

    @FXML
    private TextField txtPasswordSettings;

    @FXML
    void clickedSaveSettings(ActionEvent event) {
        try{
            if(txtMailSettings.getText().isEmpty()|| txtPasswordSettings.getText().isEmpty()|| txtNameSettings.getText().isEmpty())
                throw new IncompleteDataException();
            if(comboBoxUserTypeSettings.getValue()==null|| comoBoxNotificationTypeSettings.getValue()==null)
                throw new IncompleteDataException();
            if(user.getPassword().equals(txtPasswordSettings.getText())){
                user.setUserName(txtNameSettings.getText());
                user.setMail(txtMailSettings.getText());
                user.setUserType(comboBoxUserTypeSettings.getValue());
                user.setNotificationType(comoBoxNotificationTypeSettings.getValue());
                appPrincipal.mostrarVentanaIniciarHerramienta();

            }else {
                throw new IncorrectDataException();
            }
        }catch (IncompleteDataException e){
            ShowMessage.mostrarMensaje("Error","Datos incorrectos","datos incompletos");
        }catch (IncorrectDataException e){
            ShowMessage.mostrarMensaje("Error", "Datos incorrectos", "La contraseña es incorrecta");
        }

    }
    @FXML
    void backSettingsAction(ActionEvent event) {
        appPrincipal.mostrarVentanaIniciarHerramienta();
    }

    @FXML
    void initialize(){
        comboBoxUserTypeSettings.getItems().addAll(UserType.values());
        comoBoxNotificationTypeSettings.getItems().addAll(NotificationType.values());
    }

    public void setAplicacion(AppPrincipal aplicacion){
        this.appPrincipal= aplicacion;
    }



}

