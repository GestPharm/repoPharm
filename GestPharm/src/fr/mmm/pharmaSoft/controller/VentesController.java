package fr.mmm.pharmaSoft.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import antlr.StringUtils;
import fr.mmm.pharmaSoft.commun.AutoCompleteComboBoxListener;
import fr.mmm.pharmaSoft.dao.Daos;
import fr.mmm.pharmaSoft.dto.ComboBoxDTO;
import fr.mmm.pharmaSoft.dto.LigneMedicamentDTO;
import fr.mmm.pharmaSoft.dto.MedicamentDTO;
import fr.mmm.pharmaSoft.entity.Commande;
import fr.mmm.pharmaSoft.entity.LigneMedicament;
import fr.mmm.pharmaSoft.entity.Medicament;

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
	private TableColumn<LigneMedicamentDTO, Double> tv_montant;
    @FXML 
    private TableColumn<LigneMedicamentDTO, Integer> idMedicament;
    
    private Daos daos;
    
    private Commande commande;
    
    private Double montantTotal;
	
	/**
	 * @return the daos
	 */
	public Daos getDaos() {
		return daos;
	}

	/**
	 * @param daos the daos to set
	 */
	public void setDaos(Daos daos) {
		this.daos = daos;
	}

	ObservableList<ComboBoxDTO> list = FXCollections.observableArrayList();
	
	final ObservableList<LigneMedicamentDTO> ligneMedicamentDTOs = FXCollections.observableArrayList();

	public VentesController() {
		super();
		// TODO Auto-generated constructor stub
		daos=new Daos();
		commande = new Commande();
		montantTotal=0.0;
		
		
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
		t_montantEncaisse.setText("0.0");
		if (null != b_ajouterMedicament) {
 			b_ajouterMedicament.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
//				if(t_montantEncaisse==null){
//					t_montantEncaisse=new TextField();
//					t_montantEncaisse.setText("0.0");
//				}
					int quantite=Integer.parseInt(t_quantite.getText());
					ComboBoxDTO comboBoxDTO = cb_medicament.getSelectionModel().getSelectedItem();
					Medicament med=daos.getMedicamentDao().findByPk(comboBoxDTO.getValue());
					if(med != null) {
						LigneMedicamentDTO ligneMedicamentDTO = new LigneMedicamentDTO(
								med.getDci()+" "+med.getDosage()+" "+med.getForme(),
								quantite, med.getPrix());
						ligneMedicamentDTOs.add(ligneMedicamentDTO);
						// Set du tableau
						tv_medicament.setCellValueFactory(new PropertyValueFactory<LigneMedicamentDTO,String>("libelleMedicament")); // Valeur dans le pojo
						tv_quantite.setCellValueFactory(new PropertyValueFactory<LigneMedicamentDTO,Integer>("quantite"));
						tv_prixUnitaire.setCellValueFactory(new PropertyValueFactory<LigneMedicamentDTO,Double>("prixUnitaire"));
						tv_montant.setCellValueFactory(new PropertyValueFactory<LigneMedicamentDTO,Double>("montant"));
						
						tableMedicament.setItems(ligneMedicamentDTOs);
						
						montantTotal=getMontantTotal()+med.getPrix()*quantite;
						t_prixTotal.setText(Double.toString(montantTotal));
						//t_montantEncaisse.setText(t_montantEncaisse.getText());
						//System.out.println("fffffffffffffffff  "+Double.parseDouble(t_montantEncaisse.getText()));
						//t_resteDu.setText(Double.toString(montantTotal-Double.parseDouble(t_montantEncaisse.getText())));
						commande.getMedicaments().add(new LigneMedicament(med, quantite ));
					}
									
   				}
			});
		}
		
		t_montantEncaisse.textProperty().addListener(new ChangeListener<String>()
				{
				    @Override
				    public void changed(ObservableValue<? extends String> arg0, String oldPropertyValue, String newPropertyValue)
				    {
				        if (newPropertyValue != null && !newPropertyValue.isEmpty())
				        {
							t_resteDu.setText(Double.toString(montantTotal-Double.parseDouble(t_montantEncaisse.getText())));

				        }
				       
				    }
				});
		
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
					System.out.println(commande.getMedicaments());
					
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
		
		
		//t_montantEncaisse.clear();
		//ObservableList<ComboBoxDTO> listeCombo = FXCollections.observableArrayList();
		List<ComboBoxDTO> listeCombo = new ArrayList<ComboBoxDTO>();
		for (MedicamentDTO med : daos.getMedicamentDao().findAll()) {
			listeCombo.add(new ComboBoxDTO(med.getDci()+" "+med.getDosage()+" "+med.getForme(), med.getNoMedicament()));
		}
		
//		listeCombo.add(new ComboBoxDTO("label 1", 2));
//		listeCombo.add(new ComboBoxDTO("Sabel 1", 3));
//		listeCombo.add(new ComboBoxDTO("Htrbj 1", 4));
		//list = FXCollections.observableArrayList(listeCombo);
 		cb_medicament.setItems(FXCollections.observableArrayList(listeCombo));
 		//cb_medicament.setEditable(false);
 		new AutoCompleteComboBoxListener<>(cb_medicament);
	}

	/**
	 * @return the montantTotal
	 */
	public Double getMontantTotal() {
		return montantTotal;
	}

	/**
	 * @param montantTotal the montantTotal to set
	 */
	public void setMontantTotal(Double montantTotal) {
		this.montantTotal = montantTotal;
	}
}
