package com.onebil.fms.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import com.onebil.fms.entities.AddOnCharge;


@Repository
public class AddOnChargesDAOImpl implements AddOnChargesDAO {
	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public AddOnCharge addAddonCharges(AddOnCharge addon) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(addon);
		manager.getTransaction().commit();
		return addon;
	}

	@Override
	public AddOnCharge updateAddonCharges(AddOnCharge addon) {
		EntityManager manager = factory.createEntityManager();
		AddOnCharge aoc = manager.find(AddOnCharge.class, addon.getAddonChargeId());
		if (aoc != null) {
			manager.getTransaction().begin();
			BeanUtils.copyProperties(addon, aoc);
			manager.getTransaction().commit();
			manager.close();
			return aoc;
		} else {
			return null;
		}
	}

	@Override
	public AddOnCharge getAddonCharges(int addonChargeId) {
		EntityManager manager = factory.createEntityManager();
		AddOnCharge res = manager.find(AddOnCharge.class, addonChargeId);
		return res;
	}

	@Override
	public List<AddOnCharge> getAllAddonCharges() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<AddOnCharge> query = manager.createQuery("FROM AddOnCharge", AddOnCharge.class);
		return query.getResultList();
	}

	@Override
	public AddOnCharge delAddonCharges(int addonChargeId) {
		EntityManager manager = factory.createEntityManager();
		AddOnCharge addon = manager.find(AddOnCharge.class, addonChargeId);
		if (addon != null) {
			manager.getTransaction().begin();
			manager.remove(addon);
			manager.getTransaction().commit();
			manager.close();
			return addon;
		} else {
			return null;
		}
	}

}
