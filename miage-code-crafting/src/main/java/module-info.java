module com.mcc.projet {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.mcc.projet to javafx.fxml, javafx.graphic;
    exports com.mcc.projet;
}


