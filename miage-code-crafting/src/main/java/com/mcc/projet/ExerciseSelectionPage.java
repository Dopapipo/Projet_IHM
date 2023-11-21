package com.mcc.projet;
import javafx.scene.control.Hyperlink;
//import javafx.scene.layout.StackPane;

import java.io.InputStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
//import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
//import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
//import javafx.stage.Popup;
import javafx.stage.Stage;

public class ExerciseSelectionPage extends Application {
	int numeroExo;

	public ExerciseSelectionPage(int numeroExo) {
		super();
		this.numeroExo = numeroExo;
	}

	public ExerciseSelectionPage() {
		super();
		this.numeroExo = 1;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setMaximized(true);
		primaryStage.setResizable(false);

		BorderPane root = new BorderPane();

		// -----------------------------------------------------------------------------
		// Liste d'exercices à gauche

		VBox exercices = new VBox(30);
		exercices.setPadding(new Insets(100, 20, 150, 20));
		exercices.setStyle("-fx-background-color: #0E336A;");

		Label[] labelsListeExos = new Label[8];

		VBox listeExos = new VBox(10);
		listeExos.setPadding(new Insets(100, 20, 150, 20));
		listeExos.setStyle("-fx-background-color: #0E336A;");

		for (int i = 0; i < labelsListeExos.length; i++) {
			labelsListeExos[i] = new Label();
			labelsListeExos[i].setFont(Font.font("Verdana", 13));
			listeExos.getChildren().add(labelsListeExos[i]);

			if (i < labelsListeExos.length - 1) {
				Separator separator = new Separator();
				separator.setPadding(new Insets(5, 0, 5, 0));
				listeExos.getChildren().add(separator);
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

		root.setLeft(listeExos);

		for (Label label : labelsListeExos) {
			label.setTextFill(Color.WHITE);
		}

		// ---------------------------------------------------------------------------
		// ENTETE

		HBox entete = new HBox();
		entete.setStyle("-fx-background-color: #C19233;");
		entete.setMaxWidth(Double.MAX_VALUE);

		// Le Bouton Logo MiageCodeCrafting
		VBox logoBox = new VBox();
		Button logoButton = new Button();
		VBox.setMargin(logoButton, new Insets(15,0,0,0));
		logoBox.setStyle("-fx-background-color: #C19233;");
		logoButton.setStyle("-fx-background-color: #C19233;");
		logoBox.getChildren().addAll(logoButton);
		Region headerSpring1 = new Region();
		HBox.setHgrow(headerSpring1, Priority.ALWAYS);
		Region headerSpring2 = new Region();
		HBox.setHgrow(headerSpring2, Priority.ALWAYS);
		InputStream input = getClass().getResourceAsStream("/image/logo-craft-fonce.png");
		ImageView imageViewLogo = new ImageView(new Image(input));
		imageViewLogo.setFitWidth(300);
		imageViewLogo.setFitHeight(100);
		logoButton.setGraphic(imageViewLogo);
		entete.getChildren().addAll(logoBox, headerSpring1);

		// Titre de la page (En haut au centre)
		TextFlow titre = new TextFlow();
		titre.setTextAlignment(TextAlignment.CENTER);
		titre.setPadding(new Insets(20, 150, 20, 150));

		Text poo = new Text("INF2 - Programmation Orientée Objet \n");
		poo.setFont(Font.font("Arial Narrow", FontWeight.BOLD, 30));
		poo.setFill(Color.BLACK);

		Text miage = new Text("L3 - MIAGE Classique \n");
		miage.setFont(Font.font("Arial Narrow", FontWeight.BOLD, FontPosture.ITALIC, 20));
		miage.setFill(Color.BLACK);

		Text universite = new Text("Université Paris 1 Panthéon-Sorbonne");
		universite.setFont(Font.font("Arial", 10));
		universite.setFill(Color.BLACK);

		titre.getChildren().addAll(poo, miage, universite);
		entete.getChildren().addAll(titre,headerSpring2); // Utilisez la deuxième colonne

		// Le Bouton Connexion Discord
	
		Label connexionText = new Label("Connexion");
		connexionText.setTextAlignment(TextAlignment.CENTER);
		connexionText.setFont(Font.font("Arial Narrow", FontWeight.NORMAL, 20));
		connexionText.setTextFill(Color.BLACK);

		Button connexionButton = new Button();
		connexionButton.setStyle("-fx-background-color: #C19233;");
		connexionButton.setMaxHeight(100);
		connexionButton.setMaxWidth(100);

		input = getClass().getResourceAsStream("/image/discord-noir.png");
		ImageView imageViewDiscord = new ImageView(new Image(input));
		imageViewDiscord.setFitWidth(100);
		imageViewDiscord.setFitHeight(100);
		connexionButton.setGraphic(imageViewDiscord);

		VBox connexion = new VBox();
		connexion.getChildren().addAll(connexionButton, connexionText);

		entete.getChildren().add(connexion);

		Separator ligneSeparator = new Separator();
		ligneSeparator.setPrefWidth(Double.MAX_VALUE);
		ligneSeparator.setStyle("-fx-background-color: #C19233;");

		// -----------------------------------------------------------------
				// Page Centrale

		Label titrePage = new Label("Exercices d'application");
		Label sousTitre1 = new Label("STRUCTURE FONDAMENTALE DU LANGAGE");
		Label sousTitre2 = new Label("DEMARRAGE");
		Label sousTitre3 = new Label("ALGORITHME DE CESAR");
		Label sousTitre4 = new Label("RECONNAISSANCE DE MAINS DANS UN JEU DE POKER");
		Label sousTitre5 = new Label("POKER FERME");
		Label sousTitre6 = new Label("LES METHODES");
		Label sousTitre7 = new Label("LAMBDA");
		titrePage.setFont(Font.font("Arial Narrow", FontWeight.BOLD, 25));
		sousTitre1.setFont(Font.font("Arial Narrow", FontWeight.BOLD, 18));
		sousTitre7.setFont(Font.font("Arial Narrow", FontWeight.BOLD, 18));
		sousTitre6.setFont(Font.font("Arial Narrow", FontWeight.BOLD, 18));
		sousTitre5.setFont(Font.font("Arial Narrow", FontWeight.BOLD, 18));
		sousTitre4.setFont(Font.font("Arial Narrow", FontWeight.BOLD, 18));
		sousTitre3.setFont(Font.font("Arial Narrow", FontWeight.BOLD, 18));
		sousTitre2.setFont(Font.font("Arial Narrow", FontWeight.BOLD, 18));

		VBox pane = new VBox(9);
		pane.setStyle("-fx-background-color: #0E336A;");
		pane.setPadding(new Insets(50));
		pane.getChildren().addAll(titrePage, sousTitre1);
		addSeparatorLine(pane);
		pane.getChildren().addAll(sousTitre2);
		addSeparatorLine(pane);
		pane.getChildren().addAll(sousTitre3);
		addSeparatorLine(pane);
		pane.getChildren().addAll(sousTitre4);
		addSeparatorLine(pane);
		pane.getChildren().addAll(sousTitre5);
		addSeparatorLine(pane);
		pane.getChildren().addAll(sousTitre6);
		addSeparatorLine(pane);
		pane.getChildren().addAll(sousTitre7);

		titrePage.setTextFill(Color.WHITE);
		sousTitre1.setTextFill(Color.WHITE);
		sousTitre2.setTextFill(Color.WHITE);
		sousTitre3.setTextFill(Color.WHITE);
		sousTitre4.setTextFill(Color.WHITE);
		sousTitre5.setTextFill(Color.WHITE);
		sousTitre6.setTextFill(Color.WHITE);
		sousTitre7.setTextFill(Color.WHITE);
		
		//------------Boutons------------\\

		
        Button[] boutonsExos = new Button[20];
        HBox[] hBoxExos = new HBox[10];
        Button[] boutonsFeedback = new Button[hBoxExos.length];

        String[] liensURL = {
            "https://java.l3.miage.dev/langage_java/structure_fondamentale.html",
            "https://java.l3.miage.dev/langage_java/premiere_classe.html",
            "https://java.l3.miage.dev/langage_java/premiere_classe.html",
            "https://java.l3.miage.dev/langage_java/types_primitifs.html",
			"https://java.l3.miage.dev/langage_java/structures_de_controle.html",
            "https://java.l3.miage.dev/index.html",
            "https://java.l3.miage.dev/index.html",
			"https://java.l3.miage.dev/langage_java/generiques.html",
            "https://java.l3.miage.dev/langage_java/les_lambdas.html",
			"https://java.l3.miage.dev/langage_java/les_lambdas.html"
        };

        
		for (int i1 = 0; i1 < hBoxExos.length ; i1++) {
            hBoxExos[i1] = new HBox(); // ligne pour initialiser les HBox
            hBoxExos[i1].setSpacing(10);
            boutonsFeedback[i1] = new Button();
            input = getClass().getResourceAsStream("/image/sablier-1-noir.png");
            ImageView imageViewSablier = new ImageView(new Image(input));
            input = getClass().getResourceAsStream("/image/sablier-2-noir.png");
            ImageView imageViewSablierEnCours = new ImageView(new Image(input));
            input = getClass().getResourceAsStream("/image/emoticone-neutre-noir.png");
            ImageView imageViewBonhommeNeutre = new ImageView(new Image(input));
            input = getClass().getResourceAsStream("/image/emoticone-triste-noir.png");
            ImageView imageViewBonhommeTriste = new ImageView(new Image(input));
            input = getClass().getResourceAsStream("/image/emoticone-joyeux-noir.png");
            ImageView imageViewBonhommeContent = new ImageView(new Image(input));
            imageViewSablier.setFitWidth(20);
            imageViewSablier.setFitHeight(20);
            imageViewSablierEnCours.setFitWidth(20);
            imageViewSablierEnCours.setFitHeight(20);
            imageViewBonhommeNeutre.setFitWidth(20);
            imageViewBonhommeNeutre.setFitHeight(20);
            imageViewBonhommeTriste.setFitWidth(20);
            imageViewBonhommeTriste.setFitHeight(20);
            imageViewBonhommeContent.setFitWidth(20);
            imageViewBonhommeContent.setFitHeight(20);
            boutonsFeedback[i1].setGraphic(imageViewSablier);
            addImageChangerToButton(boutonsFeedback[i1], imageViewSablier, imageViewSablierEnCours, imageViewBonhommeTriste, imageViewBonhommeNeutre, imageViewBonhommeContent);

			
			final int finalI1 = i1;
			Hyperlink lienURL = new Hyperlink("Voir le cours");
			lienURL.getStyleClass().add("hyperlink");  // Ajoute la classe de style
			lienURL.setOnAction(e -> getHostServices().showDocument(liensURL[finalI1]));

            for (int j = 0; j < 2; j++) {
                int index = i1 * 2 + j;
                boutonsExos[index] = new Button();
                boutonsExos[index].setPrefSize(120, 30);
                hBoxExos[i1].getChildren().add(boutonsExos[index]);
            }

            hBoxExos[i1].getChildren().addAll(boutonsFeedback[i1]); 
			hBoxExos[i1].getChildren().addAll(lienURL);

			
        }

        boutonsExos[0].setText("Exercice 1");
        boutonsExos[1].setText("Correction 1");
        boutonsExos[2].setText("Exercice 2");
        boutonsExos[3].setText("Correction 2");
        boutonsExos[4].setText("Exercice 3");
        boutonsExos[5].setText("Correction 3");
        boutonsExos[6].setText("Exercice 4");
        boutonsExos[7].setText("Correction 4");
        boutonsExos[8].setText("Exercice 5");
        boutonsExos[9].setText("Correction 5");
        boutonsExos[10].setText("Exercice 6");
        boutonsExos[11].setText("Correction 6");
        boutonsExos[12].setText("Exercice 7");
        boutonsExos[13].setText("Correction 7");
        boutonsExos[14].setText("Exercice 8");
        boutonsExos[15].setText("Correction 8");
        boutonsExos[16].setText("Exercice 9");
        boutonsExos[17].setText("Correction 9");
        boutonsExos[18].setText("Exercice 10");
        boutonsExos[19].setText("Correction 10");
        
        
    	

		//--------------------------------------------------------------\\
						//Individual exercise display\\

		VBox exos = new VBox();
		TextArea codeArea = pageExo(exos, numeroExo, root, listeExos, entete);
		for (int i = 0; i < boutonsExos.length / 2; i++) {
			this.addEventHandler(boutonsExos[2 * i], i + 1, root, exos, codeArea);
			this.addEventHandler(boutonsExos[2 * i + 1], i + 1, root, exos, codeArea);
		}
		for (Button bouton : boutonsExos) {
			bouton.setTextFill(Color.web("#F4E1B9"));
		}


		// --Central Page Selection Screen--\\

		VBox pane11 = new VBox(9);
		pane11.setStyle("-fx-background-color: #0E336A;");
		pane11.setPadding(new Insets(50));
		pane11.getChildren().addAll(titrePage);
		addSeparatorLine(pane11);
		pane11.getChildren().addAll(sousTitre1, hBoxExos[0]);
		addSeparatorLine(pane11);
		pane11.getChildren().addAll(sousTitre2, hBoxExos[1], hBoxExos[2], hBoxExos[3]);
		addSeparatorLine(pane11);
		pane11.getChildren().addAll(sousTitre3, hBoxExos[4]);
		addSeparatorLine(pane11);
		pane11.getChildren().addAll(sousTitre4, hBoxExos[5]);
		addSeparatorLine(pane11);
		pane11.getChildren().addAll(sousTitre5, hBoxExos[6]);
		addSeparatorLine(pane11);
		pane11.getChildren().addAll(sousTitre6, hBoxExos[7]);
		addSeparatorLine(pane11);
		pane11.getChildren().addAll(sousTitre7, hBoxExos[8], hBoxExos[9]);
		addSeparatorLine(pane11);

		// ---------------------------------------------------------------\\
		// Stage & Scene + scrollbar
		

		root.setLeft(listeExos);

		ScrollPane spane = new ScrollPane();
		addHandlerToLogoButton(logoButton, root, spane);
		spane.setContent(pane11);
		spane.setFitToWidth(true);
		spane.setFitToHeight(true);
		root.setCenter(spane);
		root.setTop(entete);
		addPopupToButton(connexionButton);
		Scene scene = new Scene(root, 1000, 800);
		String cssFile = getClass().getResource("Application.css").toExternalForm();
		scene.getStylesheets().add(cssFile);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private static void addSeparatorLine(VBox container) {
		Separator separator = new Separator();
		separator.setPrefWidth(1300);
		separator.setPrefHeight(1);
		separator.setStyle("-fx-background-color: #C19233;");
		container.getChildren().add(separator);
	}

	private void addEventHandler(Button button, int numeroExo, BorderPane root, VBox exos, TextArea codeArea) {
		button.setOnAction(event -> {
			try {
				this.numeroExo = numeroExo;
				codeArea.setText(ExerciseCodeContainer.lireExercice(this.numeroExo));

				root.setCenter(exos);

			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	private void addHandlerToLogoButton(Button logoButton, BorderPane root, ScrollPane pane) {
		logoButton.setOnAction(event -> {
			try {
				root.setCenter(pane);

			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public static void main(String... args) {
		launch(args);
	}

	private static void addPopupToButton(Button button) {
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

	private static void addImageChangerToButton(Button button, ImageView imageViewSablier,
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
	private TextArea pageExo(VBox pane11, int numeroExo, BorderPane root, VBox exercices, HBox header) {
		TextArea codeArea = new TextArea();
		HBox middleBox = new HBox();
		Label executionSuccess = new Label("");
		executionSuccess.setStyle("-fx-text-fill: black; -fx-font-size: 20px;");
		Region springMiddle = new Region();
		HBox.setHgrow(springMiddle, Priority.ALWAYS);
		middleBox.getChildren().addAll(executionSuccess,springMiddle);
		TextArea terminal = new TextArea();
		String terminalStyle = "-fx-control-inner-background:#000000; -fx-font-family: Consolas; -fx-highlight-fill: #00ff00; -fx-highlight-text-fill: #000000; -fx-text-fill: #00ff00;-fx-font-size:15px; ";
		String codeAreaStyle = "-fx-control-inner-background:#000000; -fx-font-family: Consolas; -fx-highlight-fill: #00ff00; -fx-highlight-text-fill: #000000; -fx-text-fill: white;  ";

		terminal.setStyle(terminalStyle);
		codeArea.setStyle(codeAreaStyle);
		codeArea.setText(ExerciseCodeContainer.lireExercice(this.numeroExo));
		codeArea.setPrefHeight(450);

		// Création des boutons

		StackPane codeAreaPane = new StackPane();
		String codeAreaPaneStyle = "-fx-control-inner-background:#000000; -fx-font-family: Consolas; -fx-highlight-fill: #00ff00; -fx-highlight-text-fill: #000000; -fx-text-fill: white; ";
		codeAreaPane.setStyle(codeAreaPaneStyle);
		HBox buttonsCodeArea = new HBox();

		StackPane.setMargin(buttonsCodeArea, new Insets(0));

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
				if (!pane11.getChildren().contains(middleBox)) pane11.getChildren().add(middleBox);
				if (!pane11.getChildren().contains(terminal)) pane11.getChildren().add(terminal);
				if (!root.getChildren().contains(header)) root.setTop(header);
				if (!root.getChildren().contains(exercices)) root.setLeft(exercices);
				codeArea.setPrefHeight(450);
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
				pane11.getChildren().remove(middleBox);
				pane11.getChildren().remove(terminal);
				root.getChildren().remove(header);
				root.getChildren().remove(exercices);
				codeArea.setPrefSize(root.getWidth(), root.getHeight());
			}
		};
		increaseWhiteButton1.addEventHandler(ActionEvent.ACTION, eventHandlerIncrease1);

		buttonsCodeArea.getChildren().addAll(listActionsWhiteMenuBar, playWhiteButton, infoWhiteButton,
				reduceWhiteButton1, increaseWhiteButton1);
		buttonsCodeArea.setSpacing(0);
		codeAreaPane.getChildren().addAll(codeArea, buttonsCodeArea);
		buttonsCodeArea.setAlignment(Pos.TOP_RIGHT);
		buttonsCodeArea.setMaxHeight(15);
		buttonsCodeArea.setMaxWidth(150);
		buttonsCodeArea.setStyle("-fx-background-color:black");
		HBox buttonsTerminal = new HBox();
		buttonsTerminal.setMaxWidth(75);
		middleBox.getChildren().add(buttonsTerminal);
		middleBox.setAlignment(Pos.TOP_RIGHT);
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
				
			}
		};
		increaseWhiteButton2.addEventHandler(ActionEvent.ACTION, eventHandlerIncrease2);
		terminal.setPrefHeight(250);
		terminal.setMaxHeight(Double.MAX_VALUE);
		codeArea.setMaxHeight(Double.MAX_VALUE);
		Button closeWhiteButton = new Button();
		closeWhiteButton.setStyle("-fx-background-color: #000; -fx-text-fill: white;");
		input = getClass().getResourceAsStream("/image/fermer-blanc.png");
		ImageView closeWhiteImageView = new ImageView(new Image(input));
		closeWhiteImageView.setFitWidth(15);
		closeWhiteImageView.setFitHeight(15);
		closeWhiteButton.setGraphic(closeWhiteImageView);
		buttonsTerminal.getChildren().addAll(reduceWhiteButton2, increaseWhiteButton2, closeWhiteButton);
		pane11.getChildren().addAll(codeAreaPane, middleBox,terminal);

		EventHandler<ActionEvent> eventHandlerOpenTerminal = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (!pane11.getChildren().contains(middleBox)) {
					pane11.getChildren().add(middleBox);
				}
				if (!pane11.getChildren().contains(terminal)) {
					pane11.getChildren().add(terminal);
				}
				middleBox.setStyle("-fx-background-color: green;");
				executionSuccess.setText("Execution Success!");
				codeArea.setPrefHeight(450);
				terminal.setText("Hello world!");
			}
		};
		playWhiteButton.addEventHandler(ActionEvent.ACTION, eventHandlerOpenTerminal);

		EventHandler<ActionEvent> eventHandlerCloseTerminal = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				pane11.getChildren().remove(terminal);
				pane11.getChildren().remove(middleBox);
				codeArea.setPrefHeight(1000);
				terminal.setText("");
				}
		};
		closeWhiteButton.addEventHandler(ActionEvent.ACTION, eventHandlerCloseTerminal);
		codeAreaPane.setAlignment(Pos.TOP_RIGHT);
		StackPane.setAlignment(buttonsCodeArea, Pos.TOP_RIGHT);
		return codeArea;
	}
}