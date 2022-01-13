package com.company.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputObject {
	
	private Integer primaryKey;
	private Integer sessionId;
	private Integer transactionId;
	private String ruleSet;
	private Map<String, Object> input = new HashMap<>();
	private List<ValidationResult> validationResults = new ArrayList<>();
	
	public Integer getPrimaryKey() {
		return primaryKey;
	}
	
	public void setPrimaryKey(Integer primaryKey) {
		this.primaryKey = primaryKey;
	}
	
	public Integer getSessionId() {
		return sessionId;
	}
	
	public void setSessionId(Integer sessionId) {
		this.sessionId = sessionId;
	}
	
	public Integer getTransactionId() {
		return transactionId;
	}
	
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	
	public String getRuleSet() {
		return ruleSet;
	}
	
	public void setRuleSet(String ruleSet) {
		this.ruleSet = ruleSet;
	}
	
	public Map<String, Object> getInput() {
		return input;
	}
	
	public void setInput(Map<String, Object> input) {
		this.input = input;
	}
	
	public void addInput(String key, Object value) {
		input.put(key, value);
	}
	
	public List<ValidationResult> getValidationResults() {
		return validationResults;
	}
	
	public void setValidationResults(List<ValidationResult> validationResults) {
		this.validationResults = validationResults;
	}
	
	public void addValidationResult(ValidationResult result) {
		validationResults.add(result);
	}
}
