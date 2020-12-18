package com.onebil.fms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.onebil.fms.dto.ResponseDTO;
import com.onebil.fms.entities.AddOnCharge;
import com.onebil.fms.service.AddOnChargeService;

@RestController
@RequestMapping("/productaddon")
@CrossOrigin("*")
public class AddOnChargesController {
	
	@Autowired
	public AddOnChargeService addonservice;
	

	@PostMapping
	public ResponseDTO addAddonCharges(@RequestBody AddOnCharge addon) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(addonservice.addAddonCharges(addon));
		return response;
	}
	@GetMapping(value = "/{addonChargeId}")
	public ResponseDTO getAddonCharges(@PathVariable int addonChargeId) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(addonservice.getAddonCharges(addonChargeId));
		return response;

	}
	
	@DeleteMapping(value = "/{addonChargeId}")
	public ResponseDTO delAddonCharges(@PathVariable int addonChargeId) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(addonservice.delAddonCharges(addonChargeId));
		return response;
		
	}

	@PutMapping
	public ResponseDTO updateAddonCharges(@RequestBody AddOnCharge addon) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(addonservice.updateAddonCharges(addon));
		return response;
	}


	@GetMapping(value = "/productaddons")
	public ResponseDTO getAllAddonCharges() {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(addonservice.getAllAddonCharges());
		return response;
	}

	

}
