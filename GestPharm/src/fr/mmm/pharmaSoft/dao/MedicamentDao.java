package fr.mmm.pharmaSoft.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

import fr.mmm.pharmaSoft.commun.HibernateUtil;
import fr.mmm.pharmaSoft.dto.MedicamentDTO;
import fr.mmm.pharmaSoft.entity.Medicament;

public class MedicamentDao {
	
	public Medicament create (Medicament medicament){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		s.save(medicament);
		tx.commit();
		s.close();
		return medicament;
		
	}
	
	public Medicament delete (Medicament medicament){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		s.delete(medicament);
		tx.commit();
		s.close();
		return medicament;
		
	}
	
	public Medicament update (Medicament medicament){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		s.update(medicament);
		tx.commit();
		s.close();
		return medicament;
		
	}
	
	public Medicament findByPk (Integer id){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		
		Medicament medicament=(Medicament) s.get(Medicament.class, id);
		tx.commit();
		s.close();
		
		return medicament;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<MedicamentDTO> findAll (){
		List<MedicamentDTO> results=null;
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		Criteria criteria = s.createCriteria(Medicament.class, "medicament");
		ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("medicament.noMedicament"), "noMedicament")
                .add(Projections.property("medicament.dci"), "dci")
                .add(Projections.property("medicament.reference"), "reference")
                .add(Projections.property("medicament.dosage"), "dosage")
                .add(Projections.property("medicament.forme"), "forme")
                .add(Projections.property("medicament.prix"), "prix");
		criteria.setProjection(projectionList);
		criteria.setResultTransformer(Transformers.aliasToBean(MedicamentDTO.class));
		results=criteria.list();
		tx.commit();
		s.close();
		
		return results;
		
	}

}
