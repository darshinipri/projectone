package com.onebil.fms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import com.onebil.fms.entities.ProductPlan;

@Repository
public class ProductPlanDAOImpl implements ProductPlanDAO {
	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public ProductPlan addProductPlan(ProductPlan productplan) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(productplan);
		manager.getTransaction().commit();
		return productplan;

	}

	@Override
	public ProductPlan updateProductPlan(ProductPlan productplan) {
		EntityManager manager = factory.createEntityManager();
		ProductPlan pp = manager.find(ProductPlan.class, productplan.getPlanId());
		if (pp != null) {
			manager.getTransaction().begin();
			BeanUtils.copyProperties(productplan, pp);
			manager.getTransaction().commit();
			manager.close();
			return pp;
		} else {
			return null;
		}

	}

	@Override
	public ProductPlan deleteProductPlan(int planId) {
		EntityManager manager = factory.createEntityManager();
		ProductPlan pp = manager.find(ProductPlan.class, planId);
		if (pp != null) {
			manager.getTransaction().begin();
			manager.remove(pp);
			manager.getTransaction().commit();
			manager.close();
			return pp;
		} else {
			return null;
		}

	}

	@Override
	public List<ProductPlan> getAllProductPlan() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<ProductPlan> query = manager.createQuery("FROM ProductPlan", ProductPlan.class);
		return query.getResultList();
	}

	@Override
	public ProductPlan getProductPlan(int planId) {
		EntityManager manager = factory.createEntityManager();
		ProductPlan res = manager.find(ProductPlan.class, planId);
		return res;
	}

}
