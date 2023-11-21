package com.mcc.projet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/*
 * TODO: Ajouter les boutons feedback,le bouton mode nuit, tous les boutons sur la console
 * et sur la zone de code. Pour afficher les boutons sur la console et sur la zone de code, il faut
 * surement utiliser un StackPane, et empiler la textArea et les boutons, avec les boutons au dessus.
 * Ensuite, il faut mettre la bonne position pour les boutons.
 * Pas besoin des fonctionnalités pour l'instant, on s'en chargera plus tard.
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class ExercisePage extends Application {
	int numeroExo;

	public ExercisePage(int numeroExo) {
		super();
		this.numeroExo = numeroExo;
	}

	public ExercisePage() {
		super();
		this.numeroExo = 1;
	}

	public boolean closeTerminal = true;

	@Override
	public void start(Stage arg0) throws FileNotFoundException {
		// TODO Auto-generated method stub
		BorderPane root = new BorderPane();
		VBox exercices = new VBox(30);
		exercices.setPadding(new Insets(100, 20, 150, 20));
		exercices.setStyle("-fx-background-color: #0E336A;");
		Label[] labelsListeExos = new Label[8];
		// --------------------Labels liste exos-------------------\\

		/*
		 * VBox exercices1 = new VBox(10); // 10 est l'espace vertical entre les
		 * éléments
		 * exercices1.setPadding(new Insets(100, 20, 150, 20));
		 * exercices1.setStyle("-fx-background-color: #0E336A;");
		 * 
		 * 
		 * for (int i = 0; i < labelsListeExos.length; i++) {
		 * labelsListeExos[i] = new Label();
		 * labelsListeExos[i].setFont(Font.font("Verdana", 13));
		 * exercices1.getChildren().add(labelsListeExos[i]);
		 * labelsListeExos[i].setTextAlignment(TextAlignment.JUSTIFY);
		 * labelsListeExos[i].setWrapText(true);
		 * labelsListeExos[i].setPrefWidth(170);
		 * }
		 * 
		 * labelsListeExos[0].setText("Sujets d'exercices :");
		 * labelsListeExos[1].setText("Structure fondamentale du langage");
		 * labelsListeExos[2].setText("Démarrage");
		 * labelsListeExos[3].setText("Algorithme de César");
		 * labelsListeExos[4].setText("Reconnaissance de mains dans un jeu de poker");
		 * labelsListeExos[5].setText("Poker Fermé");
		 * labelsListeExos[6].setText("Les Méthodes");
		 * labelsListeExos[7].setText("Lambda");
		 * 
		 * root.setLeft(exercices1);
		 * 
		 * for (Label label : labelsListeExos) {
		 * label.setTextFill(Color.WHITE);
		 * }
		 */
		/*
		 * Line verticalLine = new Line();
		 * verticalLine.setStyle("-fx-stroke: #C19233;"); // Couleur de la ligne
		 * exercices1.getChildren().add(verticalLine);
		 */ // ca marche pas

		// =======
		// --------------------Labels liste exos-------------------\\

		// >>>>>>> 692c042a542a0ae355db07f59a61fb5a428c691f
		VBox exercices1 = new VBox(10); // 10 est l'espace vertical entre les éléments
		exercices1.setPadding(new Insets(100, 20, 150, 20));
		exercices1.setStyle("-fx-background-color: #0E336A;");

		for (int i = 0; i < labelsListeExos.length; i++) {
			labelsListeExos[i] = new Label();
			labelsListeExos[i].setFont(Font.font("Verdana", 13));
			exercices1.getChildren().add(labelsListeExos[i]);

			// Ajoutez une ligne Separator après chaque Label, sauf après le dernier
			if (i < labelsListeExos.length - 1) {
				Separator separator = new Separator();
				separator.setPadding(new Insets(5, 0, 5, 0)); // Ajustez l'espacement comme vous le souhaitez
				exercices1.getChildren().add(separator);
			}

			labelsListeExos[i].setTextAlignment(TextAlignment.JUSTIFY);
			labelsListeExos[i].setWrapText(true);
			labelsListeExos[i].setPrefWidth(170);
		}

		labelsListeExos[0].setText("Sujets d'exercices :");
		labelsListeExos[1].setText("Structure fondamentale du langage");
		labelsListeExos[2].setText("Démarrage");
		labelsListeExos[3].setText("Algorithme de César");
		labelsListeExos[4].setText("Reconnaissance de mains dans un jeu de poker");
		labelsListeExos[5].setText("Poker Fermé");
		labelsListeExos[6].setText("Les Méthodes");
		labelsListeExos[7].setText("Lambda");

		root.setLeft(exercices1);

		// for (Label label : labelsListeExos) {
		for (int i = 0; i < labelsListeExos.length; i++) {
			labelsListeExos[i].setTextFill(Color.WHITE);
			// =======
			labelsListeExos[i] = new Label();
			labelsListeExos[i].setFont(Font.font("Verdana", 13));
			exercices1.getChildren().add(labelsListeExos[i]);

			// Ajoutez une ligne Separator après chaque Label, sauf après le dernier
			if (i < labelsListeExos.length - 1) {
				Separator separator = new Separator();
				separator.setPadding(new Insets(5, 0, 5, 0)); // Ajustez l'espacement comme vous le souhaitez
				exercices1.getChildren().add(separator);
			}

			labelsListeExos[i].setTextAlignment(TextAlignment.JUSTIFY);
			labelsListeExos[i].setWrapText(true);
			labelsListeExos[i].setPrefWidth(170);
			// >>>>>>> 692c042a542a0ae355db07f59a61fb5a428c691f
		}

		// ---------------------------------------------------------------------------
		// ENTETE

		GridPane structure = new GridPane();

		GridPane entete = new GridPane();
		entete.setStyle("-fx-background-color: #C19233;");
		structure.add(entete, 0, 0, 3, 1); // Utilisez trois colonnes

		HBox logo = new HBox();
		Label logoText = new Label("Miage Code Crafting");
		logo.getChildren().addAll(logoText);
		logo.setPadding(new Insets(20, 20, 20, 20));
		entete.add(logo, 0, 0);

		TextFlow titre = new TextFlow();
		titre.setTextAlignment(TextAlignment.CENTER);
		titre.setPadding(new Insets(20, 150, 20, 150));

		Text poo = new Text("INF2 - Programmation Orientée Objet \n");
		poo.setFont(Font.font("Arial Narrow", FontWeight.BOLD, 30));
		poo.setFill(Color.WHITE);

		Text miage = new Text("L3 - MIAGE Classique \n");
		miage.setFont(Font.font("Arial Narrow", FontWeight.BOLD, FontPosture.ITALIC, 20));
		miage.setFill(Color.WHITE);

		Text universite = new Text("Université Paris 1 Panthéon-Sorbonne");
		universite.setFont(Font.font("Arial", 10));
		universite.setFill(Color.WHITE);

		titre.getChildren().addAll(poo, miage, universite);

		entete.add(titre, 1, 0); // Utilisez la deuxième colonne

		VBox connexion = new VBox();
		Label connexionText = new Label("Connexion");
		connexion.getChildren().addAll(connexionText);
		connexion.setPadding(new Insets(20));
		entete.add(connexion, 2, 0);
		GridPane corps = new GridPane();
		structure.add(corps, 0, 1, 5, 5); // Ajoutez le corps sous l'en-tête dans la grille

		logoText.setTextFill(Color.BLACK);
		poo.setFill(Color.BLACK);
		miage.setFill(Color.BLACK);
		universite.setFill(Color.BLACK);
		connexionText.setTextFill(Color.BLACK);

		Separator ligneSeparator = new Separator();
		ligneSeparator.setPrefWidth(1300);
		ligneSeparator.setPrefHeight(1);
		ligneSeparator.setStyle("-fx-background-color: #C19233;");
		entete.add(ligneSeparator, 0, 1, 5, 1);

		// -----------------------------------------------------------------
		// Page Centrale
		VBox pane11 = new VBox(5);
		TextArea codeArea = new TextArea();
		Label executionSuccess = new Label();
		TextArea terminal = new TextArea();
		//String terminalStyle = "-fx-control-inner-background:#000000; -fx-font-family: Consolas; -fx-highlight-fill: #00ff00; -fx-highlight-text-fill: #000000; -fx-text-fill: #00ff00; ";
		//String codeAreaStyle = "-fx-control-inner-background:#000000; -fx-font-family: Consolas; -fx-highlight-fill: #00ff00; -fx-highlight-text-fill: #000000; -fx-text-fill: white; ";

		//terminal.setStyle(terminalStyle);
		//codeArea.setStyle(codeAreaStyle);
		codeArea.setText(ExerciseCodeContainer.lireExercice(this.numeroExo));
		codeArea.setPrefHeight(450);

		// Création des boutons

		StackPane codeAreaPane = new StackPane();
		String codeAreaPaneStyle = "-fx-control-inner-background:#000000; -fx-font-family: Consolas; -fx-highlight-fill: #00ff00; -fx-highlight-text-fill: #000000; -fx-text-fill: white; ";
		codeAreaPane.setStyle(codeAreaPaneStyle);
		HBox buttonsCodeArea = new HBox();
		StackPane.setMargin(buttonsCodeArea, new Insets(10));

		Menu listActionsWhiteMenu = new Menu();
		listActionsWhiteMenu.setStyle("-fx-background-color: #000; -fx-text-fill: white;");
		InputStream input = getClass().getResourceAsStream("/image/liste-blanc.png");
		ImageView listActionsWhiteImageView = new ImageView(new Image(input));
		listActionsWhiteImageView.setFitWidth(15);
		listActionsWhiteImageView.setFitHeight(15);
		listActionsWhiteMenu.setGraphic(listActionsWhiteImageView);
		listActionsWhiteMenu.getItems().addAll(new MenuItem("Open in new Tab"),
				new MenuItem("Open in new Tab"),
				new MenuItem("Save as new Snip"),
				new MenuItem("My Snips"),
				new SeparatorMenuItem(),
				new MenuItem("Download as Maven"),
				new MenuItem("Request Help with this code"));
		MenuBar listActionsWhiteMenuBar = new MenuBar();
		listActionsWhiteMenuBar.getMenus().add(listActionsWhiteMenu);
		listActionsWhiteMenuBar.setStyle("-fx-background-color: #000; -fx-text-fill: white;");


		Button playWhiteButton = new Button();
		playWhiteButton.setStyle("-fx-background-color: #000; -fx-text-fill: white;");
		input = getClass().getResourceAsStream("/image/play-blanc.png");
		ImageView playWhiteImageView = new ImageView(new Image(input));
		playWhiteImageView.setFitWidth(15);
		playWhiteImageView.setFitHeight(15);
		playWhiteButton.setGraphic(playWhiteImageView);

		Button infoWhiteButton = new Button();
		infoWhiteButton.setStyle("-fx-background-color: #000; -fx-text-fill: white;");
		input = getClass().getResourceAsStream("/image/i-blanc.png");
		ImageView infoWhiteImageView = new ImageView(new Image(input));
		infoWhiteImageView.setFitWidth(15);
		infoWhiteImageView.setFitHeight(15);
		infoWhiteButton.setGraphic(infoWhiteImageView);

		Button reduceWhiteButton1 = new Button();
		reduceWhiteButton1.setStyle("-fx-background-color: #000; -fx-text-fill: white;");
		input = getClass().getResourceAsStream("/image/retrecir-blanc.png");
		ImageView reduceWhiteImageView1 = new ImageView(new Image(input));
		reduceWhiteImageView1.setFitWidth(15);
		reduceWhiteImageView1.setFitHeight(15);
		reduceWhiteButton1.setGraphic(reduceWhiteImageView1);
		EventHandler<ActionEvent> eventHandlerReduce1 = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				double currentSize = codeArea.getFont().getSize();
				if (currentSize >= 8) { // taille minimale est 8
					codeArea.setStyle("-fx-font-size: " + (currentSize - 1));
				}
			}
		};
		reduceWhiteButton1.addEventHandler(ActionEvent.ACTION, eventHandlerReduce1);

		Button increaseWhiteButton1 = new Button();
		increaseWhiteButton1.setStyle("-fx-background-color: #000; -fx-text-fill: white;");
		input = getClass().getResourceAsStream("/image/agrandir-lecran-blanc.png");
		ImageView increaseWhiteImageView1 = new ImageView(new Image(input));
		increaseWhiteImageView1.setFitWidth(15);
		increaseWhiteImageView1.setFitHeight(15);
		increaseWhiteButton1.setGraphic(increaseWhiteImageView1);
		EventHandler<ActionEvent> eventHandlerIncrease1 = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				double currentSize = codeArea.getFont().getSize();
				if (currentSize < 30) { // taille max est 30
					codeArea.setStyle("-fx-font-size: " + (currentSize + 1));
				}
			}
		};
		increaseWhiteButton1.addEventHandler(ActionEvent.ACTION, eventHandlerIncrease1);

		buttonsCodeArea.getChildren().addAll(listActionsWhiteMenuBar, playWhiteButton, infoWhiteButton,
				reduceWhiteButton1, increaseWhiteButton1);

		codeAreaPane.getChildren().addAll(codeArea, buttonsCodeArea);
		StackPane.setAlignment(codeArea, Pos.TOP_RIGHT); // ne marche pas

		StackPane terminalPane = new StackPane();
		String terminalPaneStyle = "-fx-control-inner-background:#000000; -fx-font-family: Consolas; -fx-highlight-fill: #00ff00; -fx-highlight-text-fill: #000000; -fx-text-fill: #00ff00; ";
		terminalPane.setStyle(terminalPaneStyle);
		HBox buttonsTerminal = new HBox();
		StackPane.setMargin(buttonsTerminal, new Insets(10));

		Button reduceWhiteButton2 = new Button();
		reduceWhiteButton2.setStyle("-fx-background-color: #000; -fx-text-fill: white;");
		input = getClass().getResourceAsStream("/image/retrecir-blanc.png");
		ImageView reduceWhiteImageView2 = new ImageView(new Image(input));
		reduceWhiteImageView2.setFitWidth(15);
		reduceWhiteImageView2.setFitHeight(15);
		reduceWhiteButton2.setGraphic(reduceWhiteImageView2);
		EventHandler<ActionEvent> eventHandlerReduce2 = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				double currentSize = terminal.getFont().getSize();
				if (currentSize >= 8) { // taille minimale est 8
					terminal.setStyle("-fx-font-size: " + (currentSize - 1));
				}
			}
		};
		reduceWhiteButton2.addEventHandler(ActionEvent.ACTION, eventHandlerReduce2);

		Button increaseWhiteButton2 = new Button();
		increaseWhiteButton2.setStyle("-fx-background-color: #000; -fx-text-fill: white;");
		input = getClass().getResourceAsStream("/image/agrandir-lecran-blanc.png");
		ImageView increaseWhiteImageView2 = new ImageView(new Image(input));
		increaseWhiteImageView2.setFitWidth(15);
		increaseWhiteImageView2.setFitHeight(15);
		increaseWhiteButton2.setGraphic(increaseWhiteImageView2);
		EventHandler<ActionEvent> eventHandlerIncrease2 = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				double currentSize = terminal.getFont().getSize();
				if (currentSize < 30) { // taille max est 30
					terminal.setStyle("-fx-font-size: " + (currentSize + 1));
				}
			}
		};
		increaseWhiteButton2.addEventHandler(ActionEvent.ACTION, eventHandlerIncrease2);

		Button closeWhiteButton = new Button();
		closeWhiteButton.setStyle("-fx-background-color: #000; -fx-text-fill: white;");
		input = getClass().getResourceAsStream("/image/fermer-blanc.png");
		ImageView closeWhiteImageView = new ImageView(new Image(input));
		closeWhiteImageView.setFitWidth(15);
		closeWhiteImageView.setFitHeight(15);
		closeWhiteButton.setGraphic(closeWhiteImageView);

		buttonsTerminal.getChildren().addAll(reduceWhiteButton2, increaseWhiteButton2, closeWhiteButton);
		terminalPane.getChildren().addAll(terminal,buttonsTerminal);
		pane11.getChildren().addAll(codeAreaPane, executionSuccess);

		EventHandler<ActionEvent> eventHandlerOpenTerminal = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (closeTerminal) {
					pane11.getChildren().add(terminalPane);
				}
				closeTerminal=false;
			}
		};
		playWhiteButton.addEventHandler(ActionEvent.ACTION, eventHandlerOpenTerminal);

		EventHandler<ActionEvent> eventHandlerCloseTerminal = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				pane11.getChildren().remove(terminalPane);
				closeTerminal = true;
				terminalPane.setPrefSize(pane11.getMaxWidth(),pane11.getHeight());
			}
		};
		closeWhiteButton.addEventHandler(ActionEvent.ACTION, eventHandlerCloseTerminal);

		// ---------------------------------------------------------------\\
		// Stage & Scene
		root.setLeft(exercices1);
		root.setCenter(pane11);
		root.setTop(structure);
		Scene scene = new Scene(root, 1000, 800);
		/*
		 * Button justForFocus = new Button();
		 * justForFocus.setPrefHeight(0);
		 * justForFocus.setPrefWidth(0);
		 * justForFocus.setStyle("-fx-background-color: white;");
		 * pane.getChildren().add(justForFocus);
		 * justForFocus.requestFocus();
		 */
		arg0.setScene(scene);
		arg0.show();
	}

	public static void main(String... args) {
		launch(args);
	}

}
