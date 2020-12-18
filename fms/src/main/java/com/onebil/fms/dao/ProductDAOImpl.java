package com.onebil.fms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.onebil.fms.entities.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public Product addProduct(Product product) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(product);
		manager.getTransaction().commit();
		return product;

	}

	@Override
	public Product deleteProduct(int productId) {
		EntityManager manager = factory.createEntityManager();
		Product product1 = manager.find(Product.class, productId);
		if (product1 != null) {
			manager.getTransaction().begin();
			manager.remove(product1);
			manager.getTransaction().commit();
			manager.close();
			return product1;
		} else {
			return null;
		}

	}

	@Override
	public Product UpdateProduct(Product product) {
		EntityManager manager = factory.createEntityManager();
		Product product1 = manager.find(Product.class, product.getProductId());
		if (product1 != null) {
			manager.getTransaction().begin();
			BeanUtils.copyProperties(product, product1);
			manager.getTransaction().commit();
			manager.close();
			return product1;
		} else {
			return null;
		}

	}

	@Override
	public List<Product> getAllProduct() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Product> query = manager.createQuery("FROM Product", Product.class);
		return query.getResultList();
	}

	@Override
	public Product getProduct(int productId) {
		EntityManager manager = factory.createEntityManager();
		Product res = manager.find(Product.class, productId);
			return res;
		}

}
