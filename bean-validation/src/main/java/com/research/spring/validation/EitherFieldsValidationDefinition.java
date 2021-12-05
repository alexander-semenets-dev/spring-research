package com.research.spring.validation;

import org.hibernate.validator.cfg.ConstraintDef;

public class EitherFieldsValidationDefinition extends ConstraintDef<EitherFieldsValidationDefinition, EitherFieldsValidation> {

    public EitherFieldsValidationDefinition() {
        super(EitherFieldsValidation.class);
    }

    @Override
    public EitherFieldsValidationDefinition message(String message) {
        return super.message(message);
    }

    @Override
    protected EitherFieldsValidationDefinition addParameter(String key, Object value) {
        return super.addParameter(key, value);
    }

}