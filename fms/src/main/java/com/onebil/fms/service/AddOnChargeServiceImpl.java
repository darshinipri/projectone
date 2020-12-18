package com.onebil.fms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.onebil.fms.dao.AddOnChargesDAO;
import com.onebil.fms.entities.AddOnCharge;
import com.onebil.fms.exception.PricingException;

@Service
public class AddOnChargeServiceImpl implements AddOnChargeService {
	
	@Autowired
	public AddOnChargesDAO addonchargedao;

	@Override
	public AddOnCharge addAddonCharges(AddOnCharge addon) {
		AddOnCharge addonDto = addonchargedao.addAddonCharges(addon);
		if ( addonDto!= null) {
			return  addonDto;
		} else {
			throw new PricingException("Unable to add addon charges");
		}
	}

	@Override
	public AddOnCharge updateAddonCharges(AddOnCharge addon) {
		AddOnCharge addonDto = addonchargedao.updateAddonCharges(addon);
		if (addonDto != null) {
			return addonDto;
		} else {
			throw new PricingException("Unable to update the addon charges details");
		}
	}

	@Override
	public AddOnCharge getAddonCharges(int addonChargeId) {
		AddOnCharge addonDto = addonchargedao.getAddonCharges(addonChargeId);
		if (addonDto != null) {
			return addonDto;
		} else {
			throw new PricingException("Unable to fetch the addon charges");
		}
	}

	@Override
	public List<AddOnCharge> getAllAddonCharges() {
		List<AddOnCharge> addonlist =addonchargedao.getAllAddonCharges();
				if (!addonlist.isEmpty()) {
					return addonlist;
				} else {
					throw new PricingException("Unable to fetch all add on charges please try after some time");
				}

	}

	@Override
	public AddOnCharge delAddonCharges(int addonChargeId) {
		AddOnCharge addonDto = addonchargedao.delAddonCharges(addonChargeId);
		if (addonDto!= null) {
			return addonDto;
		} else {
			throw new PricingException("Unable to detele the addon charges");
		}
	}

}
