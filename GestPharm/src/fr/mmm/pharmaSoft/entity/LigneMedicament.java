package fr.mmm.pharmaSoft.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
@Entity
@Table(name="ligne_medicament")
public class LigneMedicament implements Serializable {
	
	public LigneMedicament(Medicament medicament, Integer nombre) {
		super();
		this.medicament = medicament;
		this.nombre = nombre;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer idLigneMedic;
	
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private Medicament medicament ;
	
	/**
	 * @return the medicament
	 */
	public Medicament getMedicament() {
		return medicament;
	}

	/**
	 * @param medicament the medicament to set
	 */
	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return idLigneMedic;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.idLigneMedic = id;
	}


	/**
	 * @return the nombre
	 */
	public Integer getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(Integer nombre) {
		this.nombre = nombre;
	}
	
	@Column(name="nombre")
	private Integer nombre;

}
