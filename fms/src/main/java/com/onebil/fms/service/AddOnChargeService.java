package com.onebil.fms.service;

import java.util.List;

import com.onebil.fms.entities.AddOnCharge;

public interface AddOnChargeService {

	public AddOnCharge addAddonCharges(AddOnCharge addon);

	public AddOnCharge updateAddonCharges(AddOnCharge addon);
	
	public AddOnCharge delAddonCharges(int addonChargeId);

	public AddOnCharge getAddonCharges(int addonChargeId);

	public List<AddOnCharge> getAllAddonCharges();

}
