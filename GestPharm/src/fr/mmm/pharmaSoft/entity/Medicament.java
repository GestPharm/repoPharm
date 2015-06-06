package fr.mmm.pharmaSoft.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



/**
 * medicament
 * @version 1.0
 * @created 29-oct.-2013 17:27:56
 */
@Entity
@Table(name="medicament")
public class Medicament {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "no_medicament")
	private Integer noMedicament;
	@Column(name="dci")
	private String dci;
	
	@Column(name="reference")
	private String reference;
	
	@Column(name="forme")
	private String forme;
	
	@Column(name="prix")
	private Double prix;
	
	@Column(name="dosage")
	private String dosage;
	
	/**
	 * type de medicament
	 */
	
	
	public Medicament(){
		
	}

	/**
	 * 
	 * @exception Throwable Throwable
	 */
	public void finalize()
	  throws Throwable{

	}

	public Integer getNoMedicament(){
		return noMedicament;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNoMedicament(Integer newVal){
		noMedicament = newVal;
	}

	public String getDci(){
		return dci;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDci(String newVal){
		dci = newVal;
	}

	public String getReference(){
		return reference;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReference(String newVal){
		reference = newVal;
	}

	public String getForme(){
		return forme;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setForme(String newVal){
		forme = newVal;
	}

	public Double getPrix(){
		return prix;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPrix(Double newVal){
		prix = newVal;
	}

	

	/**
	 * @return the dosage
	 */
	public String getDosage() {
		return dosage;
	}

	/**
	 * @param dosage the dosage to set
	 */
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	@Override
	public String toString() {
		return "Medicament [noMedicament=" + noMedicament + ", dci="
				+ dci + ", reference=" + reference + ", forme=" + forme
				+ ", prix=" + prix + "]";
	}

	
	
}