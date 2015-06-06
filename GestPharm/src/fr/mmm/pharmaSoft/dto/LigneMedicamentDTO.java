package fr.mmm.pharmaSoft.dto;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LigneMedicamentDTO {

	private SimpleStringProperty libelleMedicament;
	private IntegerProperty quantite;
	private IntegerProperty idMedicament;
	private DoubleProperty prixUnitaire;

	public LigneMedicamentDTO(String libelleMedicament, Integer quantite,
			Double prixUnitaire) {
		super();
		this.libelleMedicament = new SimpleStringProperty(libelleMedicament);
		this.quantite = new SimpleIntegerProperty(quantite);
		// this.idMedicament = idMedicament;
		this.prixUnitaire = new SimpleDoubleProperty(prixUnitaire);

	}

	public String getLibelleMedicament() {
		return libelleMedicament.get();
	}

	public void setLibelleMedicament(SimpleStringProperty libelleMedicament) {
		this.libelleMedicament = libelleMedicament;
	}
	
	 public StringProperty LibelleMedicamentProperty() {
	        return libelleMedicament;
	    }

	public int getQuantite() {
		return quantite.get();
	}

	public void setQuantite(IntegerProperty quantite) {
		this.quantite = quantite;
	}

	public double getPrixUnitaire() {
		return prixUnitaire.get();
	}

	public void setPrixUnitaire(DoubleProperty prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

}