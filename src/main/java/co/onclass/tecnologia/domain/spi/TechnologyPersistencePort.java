package co.onclass.tecnologia.domain.spi;

import co.onclass.tecnologia.domain.model.Technology;
import reactor.core.publisher.Mono;

public interface TechnologyPersistencePort {
    Mono<Technology> create(Technology technology);

    Mono<Technology> findByName(String name);

    Mono<Technology> findById(String id);
}
