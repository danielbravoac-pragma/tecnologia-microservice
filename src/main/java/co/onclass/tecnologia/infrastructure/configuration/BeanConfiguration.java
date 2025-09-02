package co.onclass.tecnologia.infrastructure.configuration;

import co.onclass.tecnologia.application.usecase.TechnologyUseCase;
import co.onclass.tecnologia.domain.api.TechnologyServicePort;
import co.onclass.tecnologia.domain.spi.TechnologyPersistencePort;
import co.onclass.tecnologia.infrastructure.output.r2dbc.adapter.TechnologyPersistenceAdapter;
import co.onclass.tecnologia.infrastructure.output.r2dbc.mapper.TechnologyR2dbcMapper;
import co.onclass.tecnologia.infrastructure.output.r2dbc.repository.TechnologyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final TechnologyRepository technologyRepository;
    private final TechnologyR2dbcMapper technologyR2dbcMapperInfrastructure;


    @Bean
    public TechnologyPersistencePort technologyPersistencePort() {
        return new TechnologyPersistenceAdapter(technologyRepository, technologyR2dbcMapperInfrastructure);
    }

    @Bean
    public TechnologyServicePort technologyServicePort() {
        return new TechnologyUseCase(technologyPersistencePort());
    }

}
