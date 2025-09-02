package co.onclass.tecnologia.infrastructure.output.r2dbc.adapter;

import co.onclass.tecnologia.domain.model.Technology;
import co.onclass.tecnologia.domain.spi.TechnologyPersistencePort;
import co.onclass.tecnologia.infrastructure.exception.ExceptionInfraMessages;
import co.onclass.tecnologia.infrastructure.exception.UniqueConstraintViolation;
import co.onclass.tecnologia.infrastructure.output.r2dbc.mapper.TechnologyR2dbcMapper;
import co.onclass.tecnologia.infrastructure.output.r2dbc.repository.TechnologyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RequiredArgsConstructor
public class TechnologyPersistenceAdapter implements TechnologyPersistencePort {

    private final TechnologyRepository repository;
    private final TechnologyR2dbcMapper mapper;

    @Override
    public Mono<Technology> create(Technology technology) {
        return repository.save(mapper.toEntity(technology))
                .map(mapper::toDomain);
    }

    @Override
    public Mono<Technology> findByName(String name) {
        return repository.findByNameIgnoreCase(name)
                .map(mapper::toDomain)
                .onErrorMap(DuplicateKeyException.class, e -> new UniqueConstraintViolation(ExceptionInfraMessages.TECHNOLOGY_NAME.getMessage()));
    }

    @Override
    public Mono<Technology> findById(String id) {
        return repository.findById(UUID.fromString(id))
                .map(mapper::toDomain);
    }
}
