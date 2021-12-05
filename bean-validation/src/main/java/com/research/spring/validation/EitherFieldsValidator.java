package com.research.spring.validation;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.util.ReflectionUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EitherFieldsValidator implements ConstraintValidator<EitherFieldsConstraint, Model> {

    private List<String> fieldNames;

    public void initialize(EitherFieldsConstraint constraintAnnotation) {
        fieldNames = Arrays.stream(constraintAnnotation.fieldNames())
                .collect(Collectors.toList());
    }

    @Override
    public boolean isValid(
            Model model,
            ConstraintValidatorContext constraintValidatorContext
    ) {
        final int countOfPresentFields = fieldNames.stream()
                .mapToInt(fieldName -> {
                    final Field field = FieldUtils.getField(model.getClass(), fieldName, true);
                    final String fieldValue = (String) ReflectionUtils.getField(field, model);

                    return StringUtils.isNotEmpty(fieldValue) ? 1 : 0;
                })
                .sum();

        return countOfPresentFields == 1;
    }
}