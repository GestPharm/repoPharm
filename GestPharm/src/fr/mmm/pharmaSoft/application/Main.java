package fr.mmm.pharmaSoft.application;
	
import java.awt.Dimension;

import fr.mmm.pharmaSoft.controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("../frxml/Login.fxml"));
			
			Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
			int hauteur = (int)tailleEcran.getHeight();
			int largeur = (int)tailleEcran.getWidth();
			
			Scene scene = new Scene(root,largeur,hauteur);
			scene.getStylesheets().add(getClass().getResource("../css/login.css").toExternalForm());
			
			primaryStage.setResizable(false);
			primaryStage.setTitle("GESTPharm : Logiciel de Gestion de pharmacie");
			primaryStage.setScene(scene);
			primaryStage.show();
			
			//
			LoginController loginController = new LoginController();
			loginController.afficherLogin(scene);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
