package Controllers;

import App.AppPrincipal;
import Model.Tool;
import Model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import static Controllers.AppController.INSTANCE;

public class AdminProcessesController {

    AppPrincipal appPrincipal;

    Tool tool = INSTANCE.getHerramienta();

    User user;

    @FXML
    private Button btnCreateProcess;

    @FXML
    private Button btnEliminateProcess;

    @FXML
    private Button btnExportPorcess;

    @FXML
    private Button btnSingOutProcess;

    @FXML
    private Button btnUpDateProcess;

    @FXML
    private TableColumn<Process, String> columIDProcess;

    @FXML
    private TableColumn<Process, Integer> colunmMaxiumTimeProcess;

    @FXML
    private TableColumn<Process, Integer> colunmMiniumTimeProcess;

    @FXML
    private TableColumn<Process, String> colunmNameProcess;

    @FXML
    private Label labelOpenActivitiesAdminProcesses;

    @FXML
    private TableView<?> tableProcess;

    @FXML
    private TextField txtNameProcess;

    @FXML
    void clickedCreateProcess(ActionEvent event) {

    }

    @FXML
    void clickedEliminateProcess(ActionEvent event) {

    }

    @FXML
    void clickedExportProcess(ActionEvent event) {

    }

    @FXML
    void clickedSingOutProcess(ActionEvent event) {

    }

    @FXML
    void clickedUpdateProcess(ActionEvent event) {

    }

    @FXML
    private Label userName;

    Object selectedProcess;
    ObservableList<Process> processListData = FXCollections.observableArrayList();

    @FXML
    void openActivitiesAction(MouseEvent event){
        if(selectedProcess != null){
        /**INSTANCE.setProcesoActual((Process) selectedProcess);**/
        appPrincipal.mostrarVentanaTareasAdmin();
        }
    }

   /** @FXML initialize() {
        userName.setText(INSTANCE.getUsuarioActual().getUserName());
        loadTable();
        tableProcess.getSelectionModel().selectedItemProperty().addListener(obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
            selectedProcess = newSelection;
            }
    });
    notifyEmail("Session has been logged in");

    }

    public void notifyEmail(String message){
        tool.notifyUser(message);
    }
   **/
}

