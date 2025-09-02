package co.onclass.tecnologia.infrastructure.exceptionhandler;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Payload response of an error")
public record ErrorMessage(
        @Schema(description = "Error code")
        Integer code,
        @Schema(description = "Error message")
        String message,
        @Schema(description = "Error path")
        String path
) {
}
