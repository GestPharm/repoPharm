package application.test;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import fr.mmm.pharmaSoft.dao.Daos;
import fr.mmm.pharmaSoft.entity.Commande;
import fr.mmm.pharmaSoft.entity.LigneMedicament;
import fr.mmm.pharmaSoft.entity.Medicament;

public class TestCommande {
	private static Integer numCommande;
	@Test
	public void test() {
		//fail("Not yet implemented");
		Daos daos = new Daos();
		
		
		Medicament medic = new Medicament();
		medic.setDci("medic1");
		medic.setForme("form1");
		medic.setPrix(12.6);
		medic.setDosage("1g");
		medic.setReference("ref1");
		
		Medicament medic1 = new Medicament();
		medic1.setDci("medic2");
		medic1.setForme("form1");
		medic1.setPrix(5.0);
		medic1.setDosage("7g");
		medic1.setReference("ref2");
		
		Medicament medic2 = new Medicament();
		medic2.setDci("medic3");
		medic2.setForme("form2");
		medic2.setPrix(18.0);
		medic2.setDosage("2g");
		medic2.setReference("ref1");
		
		medic=daos.getMedicamentDao().create(medic);
		medic1=daos.getMedicamentDao().create(medic1);
		medic2=daos.getMedicamentDao().create(medic2);
		assertNotNull(medic);
		assertNotNull(medic.getNoMedicament());
		
		assertNotNull(medic1);
		assertNotNull(medic1.getNoMedicament());
		
		assertNotNull(medic2);
		assertNotNull(medic2.getNoMedicament());
		
		//Set<LigneMedicament> listMedic=new HashSet<LigneMedicament>();
		
		
		Commande commande=new Commande();
		commande.setDateCommande(new Date());
//		commande.setMedicaments(listMedic);
		commande.setMontantTotal(66.2);
		
		commande.addMedicament(toLigne(medic,2));
		commande.addMedicament(toLigne(medic1,1));
		commande.addMedicament(toLigne(medic2, 2));
		commande=daos.getCommandeDao().create(commande);
		this.numCommande = commande.getNoCommande();
		assertNotNull(commande);
		assertNotNull(commande.getNoCommande());
		assertNotNull(numCommande);
		Assert.assertTrue(commande.getMedicaments().size()>0);
		
	}
	
//	@Test
//	public void testUpdate() {
//		Daos daos = new Daos();
//		Commande commande=daos.getCommandeDao().findByPk(this.numCommande);
//		commande.setMontantTotal(45.0);
//		LigneMedicament lm=commande.getMedicaments().iterator().next();
//		commande.getMedicaments().remove(lm);
//		
//		daos.getCommandeDao().update(commande);
//		Assert.assertTrue(commande.getMedicaments().size()==2);
//	}
//	
	@Test
	public void testDelete() {
		Daos daos = new Daos();
		Commande commande=daos.getCommandeDao().findByPk(this.numCommande);
		
		daos.getCommandeDao().delete(commande);
		commande=daos.getCommandeDao().findByPk(this.numCommande);
		Assert.assertNull(commande);
	}
	
	public LigneMedicament toLigne(Medicament med, Integer nombre) {
		LigneMedicament lm=new LigneMedicament();
		lm.setMedicament(med);
		lm.setNombre(nombre);
		
		return lm;
	}

	/**
	 * @return the numCommande
	 */
	public Integer getNumCommande() {
		return numCommande;
	}

	/**
	 * @param numCommande the numCommande to set
	 */
	public void setNumCommande(Integer numCommande) {
		this.numCommande = numCommande;
	}

}
