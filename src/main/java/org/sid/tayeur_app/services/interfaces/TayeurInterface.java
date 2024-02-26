package org.sid.tayeur_app.services.interfaces;

import lombok.SneakyThrows;
import org.sid.tayeur_app.dto.TayeurDto;
import org.sid.tayeur_app.dto.response.TayeurResponse;

import java.util.Optional;
import java.util.Set;

public interface TayeurInterface {
    TayeurResponse save(TayeurDto t);

    Set<TayeurResponse> getAll();

    Optional<TayeurResponse> getById(Long id);

    TayeurResponse update(Long id, TayeurDto t);

    @SneakyThrows
    void delete(Long id);
}
