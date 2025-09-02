package co.onclass.tecnologia.infrastructure.output.r2dbc.mapper;

import co.onclass.tecnologia.domain.model.Technology;
import co.onclass.tecnologia.infrastructure.output.r2dbc.entity.TechnologyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TechnologyR2dbcMapper {
    TechnologyEntity toEntity(Technology technology);

    Technology toDomain(TechnologyEntity technologyEntity);
}
