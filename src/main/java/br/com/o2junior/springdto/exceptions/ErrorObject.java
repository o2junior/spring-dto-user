package br.com.o2junior.springdto.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ErrorObject {
    private final String message;
    private final String field;
    private final Object parameter;
}
