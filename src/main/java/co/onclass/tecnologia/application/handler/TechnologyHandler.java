package co.onclass.tecnologia.application.handler;

import co.onclass.tecnologia.application.dto.request.CreateTechnologyRequest;
import co.onclass.tecnologia.application.dto.response.TechnologyResponse;
import co.onclass.tecnologia.application.mapper.TechnologyMapper;
import co.onclass.tecnologia.domain.api.TechnologyServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TechnologyHandler implements ITechnologyHandler {
    private final TechnologyServicePort servicePort;
    private final TechnologyMapper technologyMapper;

    @Override
    public Mono<TechnologyResponse> create(CreateTechnologyRequest createTechnologyRequest) {
        return servicePort.create(technologyMapper.toDomainCreateRequest(createTechnologyRequest))
                .map(technologyMapper::toResponseDto);
    }

    @Override
    public Mono<TechnologyResponse> findById(String id) {
        return servicePort.findById(id)
                .map(technologyMapper::toResponseDto);
    }
}
