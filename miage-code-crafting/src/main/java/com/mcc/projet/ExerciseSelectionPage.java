package com.mcc.projet;

import javafx.scene.control.Hyperlink;

import java.io.InputStream;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
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
import javafx.stage.Stage;
//Difficultés : ajuster le header pour avoir des boutons bien placés à gauche et à droite
//Pour ça, on a utilisé des Spring, qui sont des régions qui prennent toute la place disponible
//et qui permettent de bien placer les boutons à gauche et à droite.
//On a eu un peu de mal à mettre les images dans les boutons de manière propre
//Mais on a finalement réussi à trouver une fitWidth et une fitHeight qui marche bien
//Au début, on voulait utiliser deux fenêtres, mais la navigation semblait plus
//fluide en une seule fenêtre. Pour ça, on joue avec les setCenter et setLeft de BorderPane
//On enlève des éléments pour le plein écran du codeArea, et on les remet quand on quitte le plein écran
//On a eu du mal à trouver comment faire pour que le codeArea soit bien cliquable lorsqu'il est dans
//une stackpane, mais on a finalement trouvé une solution en redimensionnant la HBox qui contient
//les boutons sur le codeArea pour qu'elle ne prenne pas le focus.
//Il y avait également un bug étrange qui faisait que le ScrollPane prenait le focus et dérangeait
//Tous nos Labels sur la page de séléction des exercices, et pour cela il a fallu override la méthode
//requestFocus() de notre instance de ScrollPane pour qu'elle ne fasse rien.

public class ExerciseSelectionPage extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("MIAGE CODE CRAFTING");
		InputStream linkLogo = getClass().getResourceAsStream("/image/sorbonne.png");
		primaryStage.getIcons().add(new Image(linkLogo));
		primaryStage.setMaximized(true);

		BorderPane root = new BorderPane();

		// -----------------------------------------------------------------------------
		// Liste d'exercices à gauche

		Label[] labelsListeExos = new Label[8];

		VBox listeExos = new VBox(10);
		listeExos.setPadding(new Insets(100, 20, 150, 20));
		listeExos.setStyle("-fx-background-color: #0E336A;");

		for (int i = 0; i < labelsListeExos.length; i++) {
			labelsListeExos[i] = new Label();
			listeExos.getChildren().add(labelsListeExos[i]);

			if (i < labelsListeExos.length - 1) {
				Separator separator = new Separator();
				separator.setPadding(new Insets(5, 0, 5, 0));
				listeExos.getChildren().add(separator);
			}
			labelsListeExos[i].setTextFill(Color.WHITE);
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

		// ---------------------------------------------------------------------------
		// ENTETE

		HBox entete = new HBox();
		entete.setStyle("-fx-background-color: #C19233;");
		entete.setMaxWidth(Double.MAX_VALUE);

		// Les Spring servent à bien agencer l'entête.
		Region headerSpring1 = new Region();
		HBox.setHgrow(headerSpring1, Priority.ALWAYS);
		Region headerSpring2 = new Region();
		HBox.setHgrow(headerSpring2, Priority.ALWAYS);

		// Le Bouton Logo MiageCodeCrafting
		VBox logoBox = new VBox();
		logoBox.setStyle("-fx-background-color: #C19233;");
		Button logoButton = new Button();
		VBox.setMargin(logoButton, new Insets(15, 0, 0, 0));
		logoButton.setStyle("-fx-background-color: #C19233;");

		logoBox.getChildren().addAll(logoButton);

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
		entete.getChildren().addAll(titre, headerSpring2);

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

		// ------------Boutons------------\\

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

		for (int i1 = 0; i1 < hBoxExos.length; i1++) {
			hBoxExos[i1] = new HBox(10);
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
			Controller.addImageChangerToButton(boutonsFeedback[i1], imageViewSablier, imageViewSablierEnCours,
					imageViewBonhommeTriste, imageViewBonhommeNeutre, imageViewBonhommeContent);

			final int finalI1 = i1;
			Hyperlink lienURL = new Hyperlink("Voir le cours");
			lienURL.getStyleClass().add("hyperlink");
			// si on n'extends pas Application, on ne peut pas utiliser getHostServices()
			// et c'est plutôt compliqué et longde faire un workaround, même si ça reste
			// faisable, donc cette classe restera une Application et non pas une Vue
			lienURL.setOnAction(e -> getHostServices().showDocument(liensURL[finalI1]));

			for (int j = 0; j < 2; j++) { // Ajouter à la HBox [i1] les boutons Exo et Correction associés
				int index = i1 * 2 + j;
				boutonsExos[index] = new Button();
				boutonsExos[index].setPrefSize(120, 30);
				hBoxExos[i1].getChildren().add(boutonsExos[index]);
			}

			hBoxExos[i1].getChildren().addAll(boutonsFeedback[i1]);
			hBoxExos[i1].getChildren().addAll(lienURL);

		}

		for (int i = 0; i < boutonsExos.length; i++) {
			if (i % 2 == 0) {
				boutonsExos[i].setText("Exercice " + (i / 2 + 1));
			} else {
				boutonsExos[i].setText("Correction " + (i / 2 + 1));
			}
		}

		// --------------------------------------------------------------\\
		// Clic Exercice précis -> Page de l'exercice \\

		VBox exos = new VBox();
		TextArea codeArea = pageExo(exos, root, listeExos, entete);
		for (int i = 0; i < boutonsExos.length / 2; i++) {
			Controller.addEventHandler(boutonsExos[2 * i], i + 1, root, exos, codeArea);
			Controller.addEventHandler(boutonsExos[2 * i + 1], i + 1, root, exos, codeArea);
		}

		// --Central Page Selection Screen--\\

		VBox listeLiensExos = new VBox(9);
		listeLiensExos.setStyle("-fx-background-color: #0E336A;");
		listeLiensExos.setPadding(new Insets(50));
		listeLiensExos.getChildren().addAll(titrePage);
		addSeparatorLine(listeLiensExos);
		listeLiensExos.getChildren().addAll(sousTitre1, hBoxExos[0]);
		addSeparatorLine(listeLiensExos);
		listeLiensExos.getChildren().addAll(sousTitre2, hBoxExos[1], hBoxExos[2], hBoxExos[3]);
		addSeparatorLine(listeLiensExos);
		listeLiensExos.getChildren().addAll(sousTitre3, hBoxExos[4]);
		addSeparatorLine(listeLiensExos);
		listeLiensExos.getChildren().addAll(sousTitre4, hBoxExos[5]);
		addSeparatorLine(listeLiensExos);
		listeLiensExos.getChildren().addAll(sousTitre5, hBoxExos[6]);
		addSeparatorLine(listeLiensExos);
		listeLiensExos.getChildren().addAll(sousTitre6, hBoxExos[7]);
		addSeparatorLine(listeLiensExos);
		listeLiensExos.getChildren().addAll(sousTitre7, hBoxExos[8], hBoxExos[9]);
		addSeparatorLine(listeLiensExos);

		// ---------------------------------------------------------------\\
		// Stage & Scene + scrollbar

		ScrollPane spane = new ScrollPane() {
			public void requestFocus() {
			}
		};

		Controller.addHandlerToLogoButton(logoButton, root, spane);
		spane.setContent(listeLiensExos);
		spane.setFitToWidth(true);
		spane.setFitToHeight(true);
		root.setCenter(spane);
		root.setTop(entete);
		Controller.addPopupToButton(connexionButton);

		String cssFile = getClass().getResource("Application.css").toExternalForm();
		Scene scene = new Scene(root, 1000, 800);
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

	private TextArea pageExo(VBox pane11, BorderPane root, VBox exercices, HBox header) {
		TextArea codeArea = new TextArea();
		HBox middleBox = new HBox();
		Label executionSuccess = new Label();
		executionSuccess.setStyle("-fx-text-fill: black; -fx-font-size: 20px;");
		// Ce spring sert à bien mettre les boutons liés à la console tout à droite
		Region springMiddle = new Region();
		HBox.setHgrow(springMiddle, Priority.ALWAYS);
		middleBox.getChildren().addAll(executionSuccess, springMiddle);
		TextArea terminal = new TextArea();
		String terminalStyle = "-fx-control-inner-background:#000000; -fx-font-family: Consolas; -fx-highlight-fill: #00ff00; -fx-highlight-text-fill: #000000; -fx-text-fill: #00ff00;-fx-font-size:15px; ";
		String codeAreaStyle = "-fx-control-inner-background:#000000; -fx-font-family: Consolas; -fx-highlight-fill: #00ff00; -fx-highlight-text-fill: #000000; -fx-text-fill: white;  ";

		terminal.setStyle(terminalStyle);
		codeArea.setStyle(codeAreaStyle);
		codeArea.setPrefHeight(600);

		// Création des boutons

		StackPane codeAreaPane = new StackPane();
		String codeAreaPaneStyle = "-fx-control-inner-background:#000000; -fx-font-family: Consolas; -fx-highlight-fill: #00ff00; -fx-highlight-text-fill: #000000; -fx-text-fill: white; ";
		codeAreaPane.setStyle(codeAreaPaneStyle);
		HBox buttonsCodeArea = new HBox();

		StackPane.setMargin(buttonsCodeArea, new Insets(0));

		Menu listActionsWhiteMenu = new Menu();
		// un menu n'a pas d'héritage commun avec un bouton malheureusement
		// donc on va devoir l'initialiser à la main
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

		String style = "-fx-background-color: #000; -fx-text-fill: white;";
		Button playWhiteButton = new Button();
		input = getClass().getResourceAsStream("/image/play-blanc.png");
		initializeImageToNode(input, playWhiteButton, style);
		Button infoWhiteButton = new Button();
		input = getClass().getResourceAsStream("/image/i-blanc.png");
		initializeImageToNode(input, infoWhiteButton, style);
		Button reduceWhiteButton1 = new Button();
		input = getClass().getResourceAsStream("/image/retrecir-blanc.png");
		initializeImageToNode(input, reduceWhiteButton1, style);
		Controller.addQuitFullscreenHandler(reduceWhiteButton1, pane11, middleBox, terminal, codeArea, root, header,
				exercices);

		Button increaseWhiteButton1 = new Button();
		input = getClass().getResourceAsStream("/image/agrandir-lecran-blanc.png");
		initializeImageToNode(input, increaseWhiteButton1, style);
		Controller.addFullscreenHandler(increaseWhiteButton1, pane11, middleBox, terminal, codeArea, root, header,
				exercices);

		buttonsCodeArea.getChildren().addAll(listActionsWhiteMenuBar, playWhiteButton, infoWhiteButton,
				reduceWhiteButton1, increaseWhiteButton1);
		// Pour que la fenêtre de code puisse être clickable, il faut
		// bien redimensionner buttonsCodeArea.
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
		// On initialise tous les boutons associés au terminal
		// Avec leurs images et leurs handlers
		Button reduceWhiteButton2 = new Button();
		input = getClass().getResourceAsStream("/image/retrecir-blanc.png");
		initializeImageToNode(input, reduceWhiteButton2, style);
		Controller.addReduceFontTerminalHandler(reduceWhiteButton2, terminal);
		Button increaseWhiteButton2 = new Button();
		input = getClass().getResourceAsStream("/image/agrandir-lecran-blanc.png");
		initializeImageToNode(input, increaseWhiteButton2, style);
		Button closeWhiteButton = new Button();
		input = getClass().getResourceAsStream("/image/fermer-blanc.png");
		initializeImageToNode(input, closeWhiteButton, style);
		terminal.setPrefHeight(250);
		terminal.setMaxHeight(Double.MAX_VALUE);
		codeArea.setMaxHeight(Double.MAX_VALUE);
		codeAreaPane.setAlignment(Pos.TOP_RIGHT);
		buttonsTerminal.getChildren().addAll(reduceWhiteButton2, increaseWhiteButton2, closeWhiteButton);
		pane11.getChildren().addAll(codeAreaPane, middleBox, terminal);
		StackPane.setAlignment(buttonsCodeArea, Pos.TOP_RIGHT);
		// On ajoute tous les handlers nécéssaires au fonctionnement de la page
		Controller.addIncreaseFontTerminalHandler(increaseWhiteButton2, terminal);
		Controller.addExecuteHandler(playWhiteButton, codeArea, terminal, pane11, middleBox, executionSuccess);
		Controller.addCloseTerminalHandler(closeWhiteButton, codeArea, terminal, pane11, middleBox);
		return codeArea;
	}

	public static void main(String... args) {
		launch(args);
	}

	public static void initializeImageToNode(InputStream input, Labeled node, String style) {
		node.setStyle(style);
		ImageView view = new ImageView(new Image(input));
		view.setFitWidth(15);
		view.setFitHeight(15);
		node.setGraphic(view);
	}
}