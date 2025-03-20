package com.University.uch_University.validation;// Путь соответствует пакету кастомной аннотации

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class YearNotInFutureValidator implements ConstraintValidator<YearNotInFuture, Integer> {
    @Override
    public void initialize(YearNotInFuture constraintAnnotation) {

    }
    @Override
    public boolean isValid(Integer birthYear, ConstraintValidatorContext context) {
        if (birthYear == null) {
            return true;
        }
        int currentYear = LocalDate.now().getYear();  // Получаем текущий год
        return birthYear <= currentYear;  // Проверяем, что год не в будущем
    }
}
