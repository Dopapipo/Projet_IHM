package com.mcc.projet;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ConnexionScreen extends Application {

    @Override
    public void start(Stage arg0) throws Exception {
        Label connexionLabel = new Label("Connexion");
        TextField loginField = new TextField();
        PasswordField passwordField = new PasswordField();
        Button connexionButton = new Button("Connexion");
        Text errorText = new Text("Mauvais login ou mot de passe");
        errorText.setStyle("-fx-fill: red");
        errorText.setFont(javafx.scene.text.Font.font ("Verdana", 15));
        Text okText = new Text("Connexion réussie");
        okText.setStyle("-fx-fill: green");
        okText.setFont(javafx.scene.text.Font.font ("Verdana", 20));
        errorText.setVisible(false);
        okText.setVisible(false);
        VBox root = new VBox(5);
        root.getChildren().addAll(connexionLabel, loginField, passwordField, connexionButton);
        connexionButton.setOnAction(e -> {
            if (loginField.getText().equals("admin") && passwordField.getText().equals("admin")) {
                root.getChildren().remove(errorText);
                root.getChildren().add(okText);
                errorText.setVisible(false);
                okText.setVisible(true);
                passwordField.clear();
                loginField.clear(); 
            }else {
                root.getChildren().remove(okText);
                root.getChildren().add(errorText);
                errorText.setVisible(true);
                okText.setVisible(false);
                passwordField.clear();
                
            }
        });
        Scene scene = new Scene(root, 300, 250);
        arg0.setScene(scene);
        arg0.setTitle("Connexion");
        arg0.setResizable(false);
        arg0.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
