package fr.mmm.pharmaSoft.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {

	@FXML
	private TextField t_utilisateur;
	@FXML
	private TextField t_motDePasse;
	@FXML
	private Button b_connexion;
	@FXML
	private Button b_annuler;

	public LoginController() {
		super();
	}

	public void afficherLogin(Scene scene) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../frxml/Login.fxml"));
			scene.setRoot((Parent) loader.load());
			LoginController controller = loader.<LoginController> getController();
			controller.connexion(scene);
 		} catch (IOException ex) {
			Logger.getLogger(LoginController.class.getName()).log(Level.ALL,null, ex);
		}
	}

	/**
	 * Méthode pour l'authentification et reset champs texts
	 */
	@FXML
	public void connexion(Scene scene) {
		if (null != b_connexion) {
			AccueilController accueilController = new AccueilController();
			b_connexion.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					if ("test".equals(t_utilisateur.getText()) && "test".equals(t_motDePasse.getText())) {
						System.out.println("Apple DAO pour la connexion");
						// SI OK appel Afficher accueil
						accueilController.afficherAccueil(scene);
 					}
 				}
			});
		}
		
		if (null != b_annuler) {
			b_annuler.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					t_utilisateur.setText("");
					t_motDePasse.setText("");
				}
			});
		}
	}

}
