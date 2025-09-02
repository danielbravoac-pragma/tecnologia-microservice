package co.onclass.tecnologia.application.handler;

import co.onclass.tecnologia.application.dto.request.CreateTechnologyRequest;
import co.onclass.tecnologia.application.dto.response.TechnologyResponse;
import reactor.core.publisher.Mono;

public interface ITechnologyHandler {
    Mono<TechnologyResponse> create(CreateTechnologyRequest createTechnologyRequest);

    Mono<TechnologyResponse> findById(String id);
}
