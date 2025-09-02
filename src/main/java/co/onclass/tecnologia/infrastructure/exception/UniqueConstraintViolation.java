package co.onclass.tecnologia.infrastructure.exception;

public class UniqueConstraintViolation extends RuntimeException {
    public UniqueConstraintViolation(String message) {
        super(message);
    }
}
