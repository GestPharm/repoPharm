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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class EmployeController {

	@FXML
	private Button b_enregistrerEmploye;
	@FXML
	private Button b_annulerEnregistrementEmploye;
 	@FXML
	private TextField t_nomEmploye;
	@FXML
	private TextField t_prenomEmploye;
	@FXML
	private DatePicker d_naissanceEmploye;
	@FXML
	private TextField t_adresseEmploye;
	@FXML
	private TextField t_telephoneEmploye;
	@FXML
	private ComboBox<String> t_roleEmploye;
	
	public EmployeController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public void afficherEmploye(Scene scene) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../frxml/Employe.fxml"));
			scene.setRoot((Parent) loader.load());
			EmployeController controller = loader.<EmployeController> getController();
			controller.gestionActionBoutonEmploye();
 		} catch (IOException ex) {
			Logger.getLogger(AccueilController.class.getName()).log(Level.ALL,null, ex);
		}
	}

	@FXML
	private void gestionActionBoutonEmploye() {
		if (null != b_enregistrerEmploye) {
			b_enregistrerEmploye.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					System.out.println("Nom :"+t_nomEmploye.getText());
					System.out.println("ENREGISTRER EMPLOYE");
  				}
			});
		}
		
		if (null != b_annulerEnregistrementEmploye) {
			b_annulerEnregistrementEmploye.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					System.out.println("ANNULER ENREGISTRER EMPLOYE");
				}
			});
		}
	}
	
}
