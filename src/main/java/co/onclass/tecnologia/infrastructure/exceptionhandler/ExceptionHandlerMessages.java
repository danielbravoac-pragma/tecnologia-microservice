package co.onclass.tecnologia.infrastructure.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExceptionHandlerMessages {

    UNKNOWN_ERROR("THERE WAS AN ERROR. CONTACT THE ADMINISTRATOR."),
    DATA_ALREADY_EXISTS("YOU'RE TRYING TO REGISTER A DATA THAT ALREADY EXISTS."),
    DATA_NOT_FOUND("DATA NOT FOUND"),
    PARAMETER_IS_INVALID("SENT PARAMETER IS INVALID"),
    INVALID_FIELDS("SOME INVALID FIELDS: ");

    private final String message;
}
