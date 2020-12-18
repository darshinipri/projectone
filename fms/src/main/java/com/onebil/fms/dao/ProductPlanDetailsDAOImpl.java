package com.onebil.fms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import com.onebil.fms.entities.ProductPlanDetails;

@Repository
public class ProductPlanDetailsDAOImpl implements ProductPlanDetailsDAO {
	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public ProductPlanDetails addPlanDetails(ProductPlanDetails plandetails) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(plandetails);
		manager.getTransaction().commit();
		return plandetails;
	}

	@Override
	public ProductPlanDetails UpdatePlanDetails(ProductPlanDetails plandetails) {
		EntityManager manager = factory.createEntityManager();
		ProductPlanDetails ppd = manager.find(ProductPlanDetails.class, plandetails.getPlandetailId());
		if (ppd != null) {
			manager.getTransaction().begin();
			BeanUtils.copyProperties(plandetails, ppd);
			manager.getTransaction().commit();
			manager.close();
			return ppd;
		} else {
			return null;
		}

	}

	@Override
	public List<ProductPlanDetails> getAllplanDeatails() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<ProductPlanDetails> query = manager.createQuery("FROM ProductPlanDetails", ProductPlanDetails.class);
		return query.getResultList();
	}

	@Override
	public ProductPlanDetails deletePlanDetails(int planDetailId) {
		EntityManager manager = factory.createEntityManager();
		ProductPlanDetails ppd = manager.find(ProductPlanDetails.class, planDetailId);
		if (ppd != null) {
			manager.getTransaction().begin();
			manager.remove(ppd);
			manager.getTransaction().commit();
			manager.close();
			return ppd;
		} else {
			return null;
		}

	}

	@Override
	public ProductPlanDetails getPlanDetails(int planDetailId) {
		EntityManager manager = factory.createEntityManager();
		ProductPlanDetails res = manager.find(ProductPlanDetails.class, planDetailId);
		return res;
	}

}
