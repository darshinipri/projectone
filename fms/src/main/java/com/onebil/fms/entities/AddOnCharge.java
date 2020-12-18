package com.onebil.fms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="addon_charges")
public class AddOnCharge {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "addon_charge_id")
	private int addonChargeId;

	@Column(name = "charge_type")
	private String chargeType;

	@Column(name = "charge_frequency")
	private String chargeFrequency;

	@Column(name = "charges_for")
	private String chargesFor;

	@Column(name = "charges")
	private double charges;

	@ManyToOne
	@JoinColumn(name = "plan_id")
	private ProductPlan plan;

}
