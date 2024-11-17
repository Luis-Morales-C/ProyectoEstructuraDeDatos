package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class SettingsViewController {

    @FXML
    private ImageView backSettings;

    @FXML
    private Button btnSaveSettings;

    @FXML
    private ComboBox<?> comboBoxUserTypeSettings;

    @FXML
    private ComboBox<?> comoBoxNotificationTypeSettings;

    @FXML
    private TextField txtMailSettings;

    @FXML
    private TextField txtNameSettings;

    @FXML
    private TextField txtPasswordSettings;

    @FXML
    void clickedSaveSettings(ActionEvent event) {

    }

}

