package App;
import Controllers.RegisterController;
import Controllers.TaskController;
import javafx.application.Application;
import Controllers.InicioController;
import Model.Tool;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import  static Controllers.AppController.INSTANCE;

import java.io.IOException;

public class AppPrincipal extends Application{
    private static Stage primaryStage = new Stage();

    Tool tool = INSTANCE.getHerramienta();

    public static void main(String[] args) {launch();}

    public void start(Stage primaryStage) {
        AppPrincipal.primaryStage = primaryStage;
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

            INSTANCE.setUsuarioActual(null);

            Scene scene = new Scene(rootLayout);
            changeWindow(scene);

        } catch (IOException e) {
            // TODO Auto-generated catch block
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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void  mostrarVentanaProcesosAdmin(){


    }

    public void mostrarVentanaTareasAdmin(){
        try{
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(AppPrincipal.class.getResource("TaskView.fxml"));

            AnchorPane rootLayout = loader.load();

            TaskController taskController = loader.getController();
            taskController.setAplicacion(this);

            Scene scene= new Scene(rootLayout);
            changeWindow(scene);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void mostrarVentanaRegistrarse(){
        try{
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(AppPrincipal.class.getResource("RegisterView.fxml"));

            AnchorPane rootLayout = loader.load();

            RegisterController registerController= loader.getController();
            registerController.setAplicacion(this);

            Scene scene= new Scene(rootLayout);
            changeWindow(scene);

        }catch (IOException e){
            e.printStackTrace();
        }
    }




}
