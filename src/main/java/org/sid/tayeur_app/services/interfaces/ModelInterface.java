package org.sid.tayeur_app.services.interfaces;

import lombok.SneakyThrows;
import org.sid.tayeur_app.dto.ModelDto;
import org.sid.tayeur_app.dto.response.ModelResponse;

import java.util.Optional;
import java.util.Set;

public interface ModelInterface {
    ModelResponse saveModel(ModelDto modelDto);

    Set<ModelResponse> getAll();

    Optional<ModelResponse> getById(Long id);

    @SneakyThrows
    void delete(Long id);
}
