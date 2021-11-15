module com.monopoly.cop3252monopoly {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.monopoly.cop3252monopoly to javafx.fxml;
    exports com.monopoly.cop3252monopoly;
}