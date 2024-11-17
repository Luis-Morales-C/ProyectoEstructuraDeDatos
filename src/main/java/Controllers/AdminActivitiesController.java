package Controllers;

import Model.Activity;
import Utils.ShowMessage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import  static Controllers.AppController.INSTANCE;
import Model.Process;
import Exception.ActivityAlreadyExistsException;
import Exception.IncompleteDataException;
import App.AppPrincipal;


import java.awt.event.ActionEvent;

public class AdminActivitiesController {

    Process process = INSTANCE.getProcesoActual();


    @FXML
    private TableColumn<Activity, String> columnNameActivity;

    @FXML
    private TextField txtDescriptionActivity;

    @FXML
    private Button btnUpdateActivity;

    @FXML
    private Button btnExportActivity;

    @FXML
    private TextField txtSearchActivity;

    @FXML
    private Button btnEliminateActivity;

    @FXML
    private ComboBox<Boolean> comboBoxMandatoryActivity;

    @FXML
    private TableView<Activity> tableActivities;

    @FXML
    private TableColumn<Activity, Integer> columnMiniumTimeActivity;

    @FXML
    private Label labelOpenTaskAdminActivities;

    @FXML
    private TableColumn<Activity, Integer> columnTotalTimeActivity;

    @FXML
    private TableColumn<Activity, Boolean> columnMandatoryActivity;

    @FXML
    private Button btnCrateActivity;

    @FXML
    private Button btnSingOutActivity;

    @FXML
    private TableColumn<Integer, String> columnDescriptionActivity;

    @FXML
    private TextField txtNameActivity;

    Object activitySelection;



    @FXML
    void clickedExportActivity(ActionEvent event) {

    }

    @FXML
    void clickedSignOutActivity(ActionEvent event) {


    }

    @FXML
    void clickedCreateActivity(ActionEvent event) {

        if(process.getActivities().getSize()==0 || activitySelection==null ){
            try {
                if(!txtNameActivity.getText().isEmpty() && !txtDescriptionActivity.getText().isEmpty())
                    process.addActivity(new Activity(txtNameActivity.getText(), txtDescriptionActivity.getText(), comboBoxMandatoryActivity.getValue()));
                else
                    throw new IncompleteDataException();
                } catch (ActivityAlreadyExistsException e) {
                ShowMessage.mostrarMensaje("Error","Error agregando la actividad","la actividad ya existe");
                }catch (IncompleteDataException e){
                ShowMessage.mostrarMensaje("Error","Error agregando la actividad","actividad incompleta");
            }
        }else {
            createSequenceActivity();
        }

        //Recarga tabla

    }

    void createSequenceActivity() {
        if(!txtNameActivity.getText().isEmpty() && txtDescriptionActivity.getText().isEmpty())
            process.addActivity(new Activity(txtNameActivity.getText(), txtDescriptionActivity.getText(), comboBoxMandatoryActivity.getValue()), ((Activity) activitySelection).getName());
        else
            ShowMessage.mostrarMensaje("Error","Error agrengando actividad","incompleta");
    }


    @FXML
    void clickedEliminateActivity(ActionEvent event) {


    }

    @FXML
    void clickedUpdateActivity(ActionEvent event) {

    }

    @FXML
    void OpenTaskAdminActivitiesAction(ActionEvent event) {

    }



}
