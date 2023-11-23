package com.mcc.projet;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Controller{
    
    public static void addImageChangerToButton(Button button, ImageView imageViewSablier,
			ImageView imageViewSablierEnCours, ImageView imageViewBonhommeTriste, ImageView imageViewBonhommeNeutre,
			ImageView imageViewBonhommeContent) {
		button.setOnAction(event -> {
			if (button.getGraphic().equals(imageViewSablier)) {
				button.setGraphic(imageViewSablierEnCours);
			} else if (button.getGraphic().equals(imageViewSablierEnCours)) {
				button.setGraphic(imageViewBonhommeTriste);
			} else if (button.getGraphic().equals(imageViewBonhommeTriste)) {
				button.setGraphic(imageViewBonhommeNeutre);
				;
			} else if (button.getGraphic().equals(imageViewBonhommeNeutre)) {
				button.setGraphic(imageViewBonhommeContent);
				;
			} else if (button.getGraphic().equals(imageViewBonhommeContent)) {
				button.setGraphic(imageViewSablier);
				;
			}
		});
	}
    public static void addEventHandler(Button button, int numeroExo, BorderPane root, VBox exos, TextArea codeArea) {
		button.setOnAction(event -> {
			try {
				
				codeArea.setText(Model.lireExercice(numeroExo));

				root.setCenter(exos);

			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
    public static void addHandlerToLogoButton(Button logoButton, BorderPane root, ScrollPane pane) {
		logoButton.setOnAction(event -> {
			try {
				root.setCenter(pane);

			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public static void addPopupToButton(Button button) {
		button.setOnAction(event -> {
			ConnexionScreen popup = new ConnexionScreen();
			try {
				popup.start(new Stage());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
    public static void addCloseTerminalHandler(Button button, TextArea codeArea, TextArea terminal,VBox pane11,HBox middleBox) {
        button.setOnAction(event -> {
            pane11.getChildren().remove(terminal);
            pane11.getChildren().remove(middleBox);
            codeArea.setPrefHeight(1000);
            terminal.setText("");
        });
    }
    public static void addExecuteHandler(Button button, TextArea codeArea, TextArea terminal,VBox pane11,HBox middleBox,Label executionSuccess) {
        button.setOnAction(event -> {
            if (!pane11.getChildren().contains(middleBox)) {
                pane11.getChildren().add(middleBox);
            }
            if (!pane11.getChildren().contains(terminal)) {
                pane11.getChildren().add(terminal);
            }
            middleBox.setStyle("-fx-background-color: green;");
            executionSuccess.setText("Execution Success!");
            codeArea.setPrefHeight(600);
            terminal.setText("Hello world!");
        });
    }
    public static void addIncreaseFontTerminalHandler(Button button, TextArea terminal) {
        button.setOnAction(event -> {
            double currentSize = terminal.getFont().getSize();
            if (currentSize < 30) { // taille max est 30
                terminal.setStyle(
                        "-fx-control-inner-background:#000000; -fx-font-family: Consolas; -fx-highlight-fill: #00ff00; -fx-highlight-text-fill: #000000; -fx-text-fill: #00ff00;"
                                + "-fx-font-size: " + (currentSize + 1) + "px");
            }
        });
    }
    public static void addReduceFontTerminalHandler(Button button, TextArea terminal) {
        button.setOnAction(event -> {
            double currentSize = terminal.getFont().getSize();
				if (currentSize >= 8) { // taille minimale est 8
					terminal.setStyle(
							"-fx-control-inner-background:#000000; -fx-font-family: Consolas; -fx-highlight-fill: #00ff00; -fx-highlight-text-fill: #000000; -fx-text-fill: #00ff00;"
									+ "-fx-font-size: " + (currentSize - 1) + "px");
				}
        });
    }
    public static void addQuitFullscreenHandler(Button button,VBox pane11,HBox middleBox,TextArea terminal,TextArea codeArea,BorderPane root,HBox header,VBox exercices) {
        button.setOnAction(e->{
            if (!pane11.getChildren().contains(middleBox))
					pane11.getChildren().add(middleBox);
				if (!pane11.getChildren().contains(terminal))
					pane11.getChildren().add(terminal);
				if (!root.getChildren().contains(header))
					root.setTop(header);
				if (!root.getChildren().contains(exercices))
					root.setLeft(exercices);
				codeArea.setPrefHeight(600);
        });
    }
    public static void addFullscreenHandler(Button button,VBox pane11,HBox middleBox,TextArea terminal,TextArea codeArea,BorderPane root,HBox header,VBox exercices) {
        button.setOnAction(e->{
            if (pane11.getChildren().contains(middleBox))
            pane11.getChildren().remove(middleBox);
            pane11.getChildren().remove(terminal);
            root.getChildren().remove(header);
            root.getChildren().remove(exercices);
            codeArea.setPrefSize(root.getWidth(), root.getHeight());});
    }

}
