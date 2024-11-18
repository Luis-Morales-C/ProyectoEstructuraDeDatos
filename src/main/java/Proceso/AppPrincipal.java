package Proceso;
import Proceso.Controllers.RegisterController;
import Proceso.Controllers.TaskController;
import Proceso.Controllers.AppController;
import Proceso.Controllers.InicioController;
import javafx.application.Application;
import Proceso.Model.Tool;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AppPrincipal extends Application {
    private static Stage primaryStage; // Eliminar la inicialización directa aquí

    Tool tool = AppController.INSTANCE.getHerramienta();

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        AppPrincipal.primaryStage = primaryStage; // Inicializar primaryStage en el método start
        AppPrincipal.primaryStage.setTitle("Herramienta");

        mostrarVentanaIniciarHerramienta();
    }

    public void changeWindow(Scene newScene) {
        if (primaryStage != null) {
            primaryStage.setScene(newScene);
            primaryStage.show();
        } else {
            System.out.println("primaryStage es null");
        }
    }

    public void mostrarVentanaIniciarHerramienta() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AppPrincipal.class.getResource("InicioView.fxml"));

            AnchorPane rootLayout = loader.load();

            AppController.INSTANCE.setUsuarioActual(null);

            Scene scene = new Scene(rootLayout);
            changeWindow(scene);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarVentanaLoginAdmin() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AppPrincipal.class.getResource("InicioView.fxml"));

            AnchorPane rootLayout = loader.load();

            InicioController inicioController = loader.getController();
            inicioController.setAplicacion(this);

            Scene scene = new Scene(rootLayout);
            changeWindow(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarVentanaTareasAdmin() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AppPrincipal.class.getResource("TaskView.fxml"));

            AnchorPane rootLayout = loader.load();

            TaskController taskController = loader.getController();
            taskController.setAplicacion(this);

            Scene scene = new Scene(rootLayout);
            changeWindow(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarVentanaRegistrarse() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AppPrincipal.class.getResource("RegisterView.fxml"));

            AnchorPane rootLayout = loader.load();

            RegisterController registerController = loader.getController();
            registerController.setAplicacion(this);

            Scene scene = new Scene(rootLayout);
            changeWindow(scene);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void  mostrarVentanaProcesosAdmin(){
    }
}
