package com.research.spring.validation;

import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.HibernateValidatorConfiguration;
import org.hibernate.validator.cfg.ConstraintMapping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;

@Configuration
public class ValidationConfiguration {

    @Bean
    Validator modelValidator() {
        final HibernateValidatorConfiguration validatorConfiguration = Validation
                .byProvider(HibernateValidator.class)
                .configure();

        final EitherFieldsValidationDefinition validModelDefinition = new EitherFieldsValidationDefinition()
                .message("Only one field should be present")
                .addParameter("fieldNames", new String[]{"field1", "field2"});

        final ConstraintMapping constraintMapping = validatorConfiguration.createConstraintMapping();

        constraintMapping
                .type(Model.class)
                .constraint(validModelDefinition);

        return validatorConfiguration
                .addMapping(constraintMapping)
                .buildValidatorFactory()
                .getValidator();
    }

}
