package co.onclass.tecnologia.application.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExceptionAppMessages {

    TECHNOLOGY_ALMOST_EXISTS("The current technology name almost exists."),
    TECHNOLOGY_NOT_FOUND("The technology was not found.");

    private final String message;
}
