package com.onebil.fms.dto;

import java.io.Serializable;

import com.onebil.fms.entities.ProductPlan;

import lombok.Data;


@Data
public class AddOnChargeDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int addonChargeId;

	private String chargeType;

	private String chargeFrequency;

	private String chargesFor;

	private double charges;

	private ProductPlan plan;

}
