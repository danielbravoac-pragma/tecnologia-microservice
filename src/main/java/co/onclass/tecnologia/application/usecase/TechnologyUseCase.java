package co.onclass.tecnologia.application.usecase;

import co.onclass.tecnologia.application.exception.DataNotFoundException;
import co.onclass.tecnologia.application.exception.DuplicateDataException;
import co.onclass.tecnologia.application.exception.ExceptionAppMessages;
import co.onclass.tecnologia.domain.api.TechnologyServicePort;
import co.onclass.tecnologia.domain.model.Technology;
import co.onclass.tecnologia.domain.spi.TechnologyPersistencePort;
import co.onclass.tecnologia.infrastructure.exception.UniqueConstraintViolation;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class TechnologyUseCase implements TechnologyServicePort {

    private final TechnologyPersistencePort persistencePort;

    @Override
    public Mono<Technology> create(Technology technology) {
        technology.setName(normalize(technology.getName()));
        return persistencePort.findByName(technology.getName())
                .hasElement()
                .flatMap(e -> {
                    if (e.equals(Boolean.TRUE)) {
                        return Mono.error(new DuplicateDataException(ExceptionAppMessages.TECHNOLOGY_ALMOST_EXISTS.getMessage()));
                    } else {
                        return persistencePort.create(technology);
                    }
                })
                .onErrorMap(UniqueConstraintViolation.class, e -> new DuplicateDataException(ExceptionAppMessages.TECHNOLOGY_ALMOST_EXISTS.getMessage()));
    }

    @Override
    public Mono<Technology> findById(String id) {
        return persistencePort.findById(id)
                .switchIfEmpty(Mono.error(new DataNotFoundException(ExceptionAppMessages.TECHNOLOGY_NOT_FOUND.getMessage())));
    }

    private String normalize(String s) {
        return s == null ? null : s.trim();
    }
}
