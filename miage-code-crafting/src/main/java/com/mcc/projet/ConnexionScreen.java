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
        connexionLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        connexionButton.setStyle("-fx-background-color:rgb(102, 128, 245);");
        Text errorText = new Text("Mauvais login ou mot de passe");
        errorText.setStyle("-fx-fill: red");
        errorText.setFont(javafx.scene.text.Font.font ("Consolas", 15));
        Text okText = new Text("Connexion réussie");
        okText.setStyle("-fx-fill: green");
        okText.setFont(javafx.scene.text.Font.font ("Consolas", 20));
        errorText.setVisible(false);
        okText.setVisible(false);
        VBox root = new VBox(5);
        root.setStyle("-fx-background-color: rgb(232, 204, 167); -fx-padding: 10px; -fx-alignment: center; -fx-spacing: 10px");
        root.getChildren().addAll(connexionLabel, loginField, passwordField, connexionButton);
        connexionButton.setOnAction(e -> {
            if (loginField.getText().equals("admin") && passwordField.getText().equals("admin")) {
                root.getChildren().remove(errorText);
                if (!root.getChildren().contains(okText))
                    root.getChildren().add(okText);
                errorText.setVisible(false);
                okText.setVisible(true);
                passwordField.clear();
                loginField.clear(); 
            }else {
                root.getChildren().remove(okText);
                if (!root.getChildren().contains(errorText))
                    root.getChildren().add(errorText);
                errorText.setVisible(true);
                okText.setVisible(false);
                passwordField.clear();
                
            }
        });
        Scene scene = new Scene(root, 300, 250);
        String cssFile = getClass().getResource("Application.css").toExternalForm();
		scene.getStylesheets().add(cssFile);
        arg0.setScene(scene);
        arg0.setTitle("Connexion");
        arg0.setResizable(false);
        arg0.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
