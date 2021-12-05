package com.research.spring.validation;

import org.hibernate.validator.cfg.ConstraintDef;

public class EitherFieldsConstraintDefinition extends ConstraintDef<EitherFieldsConstraintDefinition, EitherFieldsConstraint> {

    public EitherFieldsConstraintDefinition() {
        super(EitherFieldsConstraint.class);
    }

    @Override
    public EitherFieldsConstraintDefinition message(String message) {
        return super.message(message);
    }

    @Override
    protected EitherFieldsConstraintDefinition addParameter(String key, Object value) {
        return super.addParameter(key, value);
    }

}