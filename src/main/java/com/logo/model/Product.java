package com.logo.model;

import lombok.*;

@Data
public class Product extends ProductOrService {
	private String barcode;

	//TODO Not sure how exactly this is calculated.
	private Double reserveExcludedAmount;
}
