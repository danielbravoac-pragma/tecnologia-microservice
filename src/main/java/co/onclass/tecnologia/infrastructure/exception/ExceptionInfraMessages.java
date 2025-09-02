package co.onclass.tecnologia.infrastructure.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExceptionInfraMessages {
    TECHNOLOGY_NAME("technology.name");

    private final String message;
}
