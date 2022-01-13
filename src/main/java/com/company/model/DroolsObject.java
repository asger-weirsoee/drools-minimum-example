package com.company.model;

import java.util.LinkedHashMap;

public class DroolsObject extends LinkedHashMap<String, Object> {
	private static final long serialVersionUID = 7096244641842195832L;

	public void addValidationResult(ValidationResult validationResult) {
		if (!containsKey("validationResult"))
			put("validationResult", "");
		put("validationResult", get("validationResult") + validationResult.toString());
	}
}
