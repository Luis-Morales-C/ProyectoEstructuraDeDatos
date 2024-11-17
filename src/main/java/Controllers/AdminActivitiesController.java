package Controllers;

import Model.Activity;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;

public class AdminActivitiesController {

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



    @FXML
    void clickedExportActivity(ActionEvent event) {

    }

    @FXML
    void clickedSignOutActivity(ActionEvent event) {

    }

    @FXML
    void clickedCreateActivity(ActionEvent event) {

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
