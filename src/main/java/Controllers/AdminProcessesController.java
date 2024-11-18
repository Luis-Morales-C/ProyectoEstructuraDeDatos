package Controllers;

import App.AppPrincipal;
import Model.Process;
import Model.Tool;
import Model.User;
import Model.UserType;
import Utils.ShowMessage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import org.apache.poi.hpsf.Property;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import Exception.AccesDeniedException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

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
    private TableView<Process> tableProcess;

    @FXML
    private TextField txtNameProcess;

    @FXML
    void clickedCreateProcess(ActionEvent event) {
        try{
            if (checkPermission())
                tool.createProcess(txtNameProcess.getText(),
                    String.valueOf(tool.getProcessList().size()));
        }catch (AccesDeniedException e){
            ShowMessage.mostrarMensaje("Error", "Error al crear proceso", "No tiene permisos para crear procesos");
        }
        notifyEmail("Se ha creado el proceso.");
        rechargeTable();
    }

    @FXML
    void clickedEliminateProcess(ActionEvent event) {
        try{
            if (checkPermission())
                tool.deleteProcess(((Process)selectedProcess).getName());
            else
                tool.deleteProcess(txtNameProcess.getText());
        } catch (AccesDeniedException e){
            throw new RuntimeException(e);
        }
        notifyEmail("Se ha eliminado un proceso");
        rechargeTable();
    }

    @FXML
    void clickedExportProcess(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar como archvio Excel");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivo Excel (*.xlsx), ","*.xlsx"));
        File file = fileChooser.showSaveDialog(null);

        if(file != null){
            exportTableExcel(file);
        }
    }

    public Boolean checkPermission() throws AccesDeniedException {
        if (INSTANCE.getUsuarioActual().getUserType().equals(UserType.ADMINISTRATOR))
            return true;
        throw new AccesDeniedException();
    }

    private void exportTableExcel(File file){
        try(Workbook workbook = new XSSFWorkbook(); FileOutputStream fileOut = new FileOutputStream(file)){
            Sheet sheet = workbook.createSheet("Datos");

            //Encabezados de la columna
            Row headerRow = sheet.createRow(0);
            for(int i = 0; i < tableProcess.getColumns().size(); i++){
                headerRow.createCell(i).setCellValue(tableProcess.getColumns().get(i).getText());
            }

            //Datos de la table
            ObservableList<Process> items = tableProcess.getItems();
            for(int i = 0; i < items.size(); i++){
                Row row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue(items.get(i).getId());
                row.createCell(1).setCellValue(items.get(i).getName());
                row.createCell(2).setCellValue(items.get(i).getMinTime());
                row.createCell(3).setCellValue(items.get(i).getMaxTime());
            }
            workbook.write(fileOut);
            System.out.println("Exportación exitosa a Excel.");
        }catch (IOException e){
            ShowMessage.mostrarMensaje("Error" , "Error al exportar a Excel", "No se puede exportar la tabla a Excel");
        }
    }

    @FXML
    void clickedSingOutProcess(ActionEvent event) { appPrincipal.mostrarVentanaIniciarHerramienta(); }

    @FXML
    void clickedUpdateProcess(ActionEvent event) {
        if(selectedProcess != null){
            Process process = (Process) selectedProcess;
            if(!txtNameProcess.getText().isEmpty())
                process.setName(txtNameProcess.getText());
            rechargeTable();
        }
    }

    @FXML
    private Label userName;

    Object selectedProcess;
    ObservableList<Process> processListData = FXCollections.observableArrayList();

    @FXML
    void openActivitiesAction(MouseEvent event){
        if(selectedProcess != null){
        INSTANCE.setProcesoActual((Process) selectedProcess);
        appPrincipal.mostrarVentanaTareasAdmin();
        }
    }
     @FXML
     void initialize() {
        userName.setText(INSTANCE.getUsuarioActual().getUserName());
        loadTable();
        tableProcess.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if(newSelection != null){
                selectedProcess = newSelection;
            }
        });
         notifyEmail("Session has been logged in");
     }


    public void notifyEmail(String message){
        tool.notifyUser(message);
    }

    private void loadTable() {
        columIDProcess.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunmNameProcess.setCellValueFactory(new PropertyValueFactory<>("name"));
        colunmMiniumTimeProcess.setCellValueFactory(new PropertyValueFactory<>("minimumDurationTime"));
        colunmMaxiumTimeProcess.setCellValueFactory(new PropertyValueFactory<>("maxiumDurationTime"));

        processListData.clear();
        processListData.addAll(tool.getProcessList());
        tableProcess.setItems(processListData);

        System.out.println(tool.getProcessList().get(0).getMaxTime());
    }

    private void rechargeTable(){
        processListData.clear();
        processListData.addAll(tool.getProcessList());
        tableProcess.setItems(processListData);
    }

    public void setAppPrincipal(AppPrincipal appPrincipal){this.appPrincipal = appPrincipal;}
    public void setUser(User user){this.user = user;}
}

