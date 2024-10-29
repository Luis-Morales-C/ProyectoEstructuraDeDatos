module org.example.estructuradatospro {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.estructuradatospro to javafx.fxml;
    exports org.example.estructuradatospro;
}