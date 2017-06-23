package com.aeo.microservice.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProductDetailValidator implements Validator {
	 private final InventoryService inventoryService;
	 @Autowired
	 public ProductDetailValidator(InventoryService inventoryService) {
	 this.inventoryService = inventoryService;
	 }

	@Override
	public boolean supports(Class<?> clazz) {
		return ProductDetail.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProductDetail detail = (ProductDetail) target;
		if (!inventoryService.isValidInventory(detail.getInventoryId())) {
			errors.rejectValue("inventoryId", "inventory.id.invalid", "ID de Estoque inv�lido");
		}
	}

}
