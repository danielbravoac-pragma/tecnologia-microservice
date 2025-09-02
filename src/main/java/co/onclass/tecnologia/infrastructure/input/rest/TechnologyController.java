package co.onclass.tecnologia.infrastructure.input.rest;

import co.onclass.tecnologia.application.dto.request.CreateTechnologyRequest;
import co.onclass.tecnologia.application.dto.response.TechnologyResponse;
import co.onclass.tecnologia.application.handler.ITechnologyHandler;
import co.onclass.tecnologia.infrastructure.exceptionhandler.ErrorMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/technologies", produces = "application/json")
@Tag(name = "Technology", description = "Technology management.")
public class TechnologyController {

    private final ITechnologyHandler technologyHandler;

    @GetMapping("/{id}")
    @Operation(
            summary = "Get a Technology ",
            description = "Get a Technology by Id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Technology found.",
                            content = @Content(schema = @Schema(implementation = TechnologyResponse.class))),
                    @ApiResponse(responseCode = "404", description = "Technology not found.",
                            content = @Content(schema = @Schema(implementation = ErrorMessage.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid parameters.",
                            content = @Content(schema = @Schema(implementation = ErrorMessage.class)))
            }
    )
    public Mono<ResponseEntity<TechnologyResponse>> findById(@PathVariable(name = "id") String id) {
        return technologyHandler.findById(id)
                .map(t -> ResponseEntity
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(t)
                );
    }

    @PostMapping
    @Operation(
            summary = "Create a Technology",
            description = "Create a Technology with Request",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Technology created.",
                            content = @Content(schema = @Schema(implementation = TechnologyResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Request body has errors.",
                            content = @Content(schema = @Schema(implementation = ErrorMessage.class)))
            }
    )
    public Mono<ResponseEntity<TechnologyResponse>> create(@Valid @RequestBody CreateTechnologyRequest createTechnologyRequest,
                                                           final ServerHttpRequest request) {
        return technologyHandler.create(createTechnologyRequest)
                .map(t -> ResponseEntity
                        .created(URI.create(request.getURI() + "/" + t.id()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(t));
    }
}
