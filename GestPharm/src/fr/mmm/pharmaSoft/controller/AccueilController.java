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

public class AccueilController {

	@FXML
	private Button b_ventes;
	@FXML
	private Button b_stock;
	@FXML
	private Button b_compta;
	@FXML
	private Button b_employe;
	@FXML
	private Button b_quitter;
	
	public AccueilController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void afficherAccueil(Scene scene) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../frxml/Accueil.fxml"));
			scene.setRoot((Parent) loader.load());
			AccueilController controller = loader.<AccueilController> getController();
			controller.gestionBoutonAccueil(scene);
 		} catch (IOException ex) {
			Logger.getLogger(AccueilController.class.getName()).log(Level.ALL,null, ex);
		}
	}
	
	
	@FXML
	public void gestionBoutonAccueil(Scene scene){
		if (null != b_ventes) {
			VentesController ventesController = new VentesController();
			b_ventes.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					System.out.println("VENTES");
					ventesController.afficherVente(scene);
  				}
			});
		}
		
		if (null != b_compta) {
			ComptaController comptaController = new ComptaController();
			b_compta.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					System.out.println("COMPTA");
				}
			});
		}
		
		if (null != b_stock) {
			StockController stockController = new StockController();
			b_stock.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					System.out.println("STOCK");
				}
			});
		}
		
		if (null != b_employe) {
			EmployeController employeController = new EmployeController();
			b_employe.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					System.out.println("EMPLOYE");
					employeController.afficherEmploye(scene);
				}
			});
		}
		
		if (null != b_quitter) {
			LoginController loginController = new LoginController();
			b_quitter.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					System.out.println("QUITTER");
					loginController.afficherLogin(scene);
				}
			});
		}
	}
	
}
