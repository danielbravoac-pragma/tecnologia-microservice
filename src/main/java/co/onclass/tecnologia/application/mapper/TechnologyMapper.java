package co.onclass.tecnologia.application.mapper;

import co.onclass.tecnologia.application.dto.request.CreateTechnologyRequest;
import co.onclass.tecnologia.application.dto.response.TechnologyResponse;
import co.onclass.tecnologia.domain.model.Technology;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TechnologyMapper {
    TechnologyResponse toResponseDto(Technology technology);

    Technology toDomainCreateRequest(CreateTechnologyRequest technologyRequest);
}
