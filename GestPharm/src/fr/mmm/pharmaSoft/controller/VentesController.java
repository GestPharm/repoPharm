package fr.mmm.pharmaSoft.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import fr.mmm.pharmaSoft.commun.AutoCompleteComboBoxListener;
import fr.mmm.pharmaSoft.dto.ComboBoxDTO;
import fr.mmm.pharmaSoft.dto.LigneMedicamentDTO;

public class VentesController {

	@FXML
	private Button b_ajouterMedicament;
	@FXML
	private Button b_annulerAjoutMedicament;
	@FXML
	private Button b_payer;
	@FXML
	private Button b_supprimerLigneMedicament;
	@FXML
	private Button b_quitterVente;
	@FXML
	private Button b_accueil;
	@FXML
	private ComboBox<ComboBoxDTO> cb_medicament;// = new ComboBox<>(items);
	@FXML
	private TextField t_quantite;
	@FXML
	private TextField t_prixTotal;
	@FXML
	private TextField t_montantEncaisse;
	@FXML
	private TextField t_resteDu;
	@FXML
	private TextField t_employe;
	
	
	@FXML 
	private TableView<LigneMedicamentDTO> tableMedicament;
	@FXML 
	private TableColumn<LigneMedicamentDTO, String> tv_medicament;
	@FXML 
	private TableColumn<LigneMedicamentDTO, Double> tv_prixUnitaire;
	@FXML 
	private TableColumn<LigneMedicamentDTO, Integer> tv_quantite;
	@FXML 
	private TableColumn<Double, Double> tv_montant;
    @FXML 
    private TableColumn<LigneMedicamentDTO, Integer> idMedicament;
	
	ObservableList<ComboBoxDTO> list = FXCollections.observableArrayList();
	
	final ObservableList<LigneMedicamentDTO> ligneMedicamentDTOs = FXCollections.observableArrayList();

	public VentesController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void afficherVente(Scene scene) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../frxml/Ventes.fxml"));
			scene.setRoot((Parent) loader.load());
			VentesController controller = loader.<VentesController> getController();
  			controller.gestionActionBoutonVentes();
 		} catch (IOException ex) {
			Logger.getLogger(AccueilController.class.getName()).log(Level.ALL,null, ex);
		}
	}

	@FXML
	public void gestionActionBoutonVentes(){
		t_employe.setText("NIOKHOR FAYE");	 
		
		if (null != b_ajouterMedicament) {
 			b_ajouterMedicament.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					ComboBoxDTO comboBoxDTO = cb_medicament.getSelectionModel().getSelectedItem();
					
					LigneMedicamentDTO ligneMedicamentDTO = new LigneMedicamentDTO(
													comboBoxDTO.getLabel(),
													Integer.parseInt(t_quantite.getText()), 
 													12.3);
					ligneMedicamentDTOs.add(ligneMedicamentDTO);
				//	ligneMedicamentDTO.setLibelleMedicament(libelleMedicament);
 					
					// Set du tableau
					tv_medicament.setCellValueFactory(new PropertyValueFactory<LigneMedicamentDTO,String>("libelleMedicament")); // Valeur dans le pojo
					tv_quantite.setCellValueFactory(new PropertyValueFactory<LigneMedicamentDTO,Integer>("quantite"));
					tv_prixUnitaire.setCellValueFactory(new PropertyValueFactory<LigneMedicamentDTO,Double>("prixUnitaire"));
					//tv_montant.setCellValueFactory(new PropertyValueFactory<Double,Double>("tv_montant"));
					
//					x = Integer.parseInt(quantite.getText()) + x;
//					montantAPayer.setText(""+x);
					
					//nombreArticle.setText(""+produitUnit.size());

					tableMedicament.setItems(ligneMedicamentDTOs);
					System.out.println("AJOUT MEDOC");					
   				}
			});
		}
		
		if (null != b_annulerAjoutMedicament) {
			b_annulerAjoutMedicament.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					System.out.println("ANNULER MEDOC");
				}
			});
		}
		
		if (null != b_payer) {
			b_payer.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					System.out.println("PAYER");
				}
			});
		}
		
		if (null != b_supprimerLigneMedicament) {
			b_supprimerLigneMedicament.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					System.out.println("SUPPRIMER LIGNE MEDOC");
				}
			});
		}
		
		if (null != b_quitterVente) {
			b_quitterVente.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					System.out.println("RETOUR PAGE CONNEXION");
				}
			});
		}
		
		if (null != b_accueil) {
			b_accueil.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					System.out.println("ACCUEIL");
				}
			});
		}
	}
	
	@FXML
	public void initialize() {
		ObservableList<ComboBoxDTO> listeCombo = FXCollections.observableArrayList();
		listeCombo.add(new ComboBoxDTO("label", 1));
		listeCombo.add(new ComboBoxDTO("label 1", 2));
		listeCombo.add(new ComboBoxDTO("Sabel 1", 3));
		listeCombo.add(new ComboBoxDTO("Htrbj 1", 4));
		list = FXCollections.observableArrayList(listeCombo);
 		cb_medicament.setItems(listeCombo);
 		new AutoCompleteComboBoxListener<>(cb_medicament);
	}
}
