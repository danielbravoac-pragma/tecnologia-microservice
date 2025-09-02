package co.onclass.tecnologia.domain.api;

import co.onclass.tecnologia.domain.model.Technology;
import reactor.core.publisher.Mono;

public interface TechnologyServicePort {
    Mono<Technology> create(Technology technology);

    Mono<Technology> findById(String id);
}
