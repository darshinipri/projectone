package com.onebil.fms.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class ProductPlanDTO {
	
	@Getter
	private boolean error;

	private Object response;

}
