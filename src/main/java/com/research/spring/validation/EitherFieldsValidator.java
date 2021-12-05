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

public class EitherFieldsValidator implements ConstraintValidator<EitherFieldsValidation, Model> {

    private List<String> fieldNames;

    public void initialize(EitherFieldsValidation constraintAnnotation) {
        fieldNames = Arrays.stream(constraintAnnotation.fieldNames())
                .collect(Collectors.toList());
    }

    @Override
    public boolean isValid(
            Model model,
            ConstraintValidatorContext constraintValidatorContext
    ) {
        final int countOfPresentFields = fieldNames.stream()
                .mapToInt(s -> {
                    final Field field = FieldUtils.getField(model.getClass(), s, true);
                    final String field1 = (String) ReflectionUtils.getField(field, model);

                    return StringUtils.isNotEmpty(field1) ? 1 : 0;
                })
                .sum();

        return countOfPresentFields == 1;
    }
}