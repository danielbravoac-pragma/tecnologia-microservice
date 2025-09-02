package co.onclass.tecnologia.infrastructure.output.r2dbc.repository;

import co.onclass.tecnologia.infrastructure.output.r2dbc.entity.TechnologyEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface TechnologyRepository extends ReactiveCrudRepository<TechnologyEntity, UUID> {
    Mono<TechnologyEntity> findByNameIgnoreCase(String name);
}
