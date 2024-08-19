package com.github.juli220620.core.exception;

import jakarta.validation.ConstraintViolation;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ValidationException extends RuntimeException {

    private final Collection<ConstraintViolation<?>> violations;

    @Override
    public String getMessage() {
        return violations.stream()
                .map(it -> String.format("[%s] - %s", it.getPropertyPath(), it.getMessage()))
                .collect(Collectors.joining(", "));
    }
}
