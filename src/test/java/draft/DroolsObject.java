package draft;

import draft.ValidationResult;

import java.util.LinkedHashMap;

public class DroolsObject extends LinkedHashMap<String, Object> {


    public void addValidationResult(ValidationResult validationResult) {
        if (!this.containsKey("validationResult"))
            this.put("validationResult", "");
        this.put("validationResult", this.get("validationResult") + validationResult.toString());
    }
}
