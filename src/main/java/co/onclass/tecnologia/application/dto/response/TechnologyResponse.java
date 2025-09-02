package co.onclass.tecnologia.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Payload of response to an action in Technology")
public record TechnologyResponse(
        @Schema(description = "Id of Technology in Database", example = "a1b2-c3d4-e5f6")
        UUID id,
        @Schema(description = "Technology name", example = "Java")
        String name,
        @Schema(description = "Technology description", example = "The best programming language")
        String description
) {
}
