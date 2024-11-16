package Controllers;
import Model.Tool;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

public class InicioController {

       //corregir cuando este el appController
       // Tool tool =  Instance.getTool;
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

        }

        @FXML
        void clickedManagerLogin(ActionEvent event) {

        }

        @FXML
        void clickedRegisterLogin(ActionEvent event) {

        }

        private boolean datosValidos(String userName, String password) {
                return !userName.isEmpty() && !password.isEmpty();
        }
}
