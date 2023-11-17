module com.mcc.projet {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mcc.projet to javafx.fxml;
    exports com.mcc.projet;
}
