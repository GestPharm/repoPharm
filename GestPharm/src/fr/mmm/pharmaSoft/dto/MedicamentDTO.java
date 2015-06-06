package fr.mmm.pharmaSoft.dto;




public class MedicamentDTO {

	
	private Integer noMedicament;

	private String dci;
	
	
	private String reference;
	
	private String forme;
	
	private String dosage;

	private Double prix;
	

	public MedicamentDTO(){

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

	

		
	
}