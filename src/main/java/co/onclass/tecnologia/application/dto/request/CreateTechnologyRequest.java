package co.onclass.tecnologia.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Schema(description = "Payload for request to create a Technology")
public record CreateTechnologyRequest(
        @Schema(description = "Technology name", example = "Java", requiredMode = Schema.RequiredMode.REQUIRED)
        @Size(min = 1, max = 50)
        @NotBlank
        String name,
        @Schema(description = "Technology description", example = "The best programming language", requiredMode = Schema.RequiredMode.REQUIRED)
        @Size(min = 1, max = 90)
        @NotBlank
        String description
) {
}
