package org.sid.tayeur_app.services.interfaces;

import lombok.SneakyThrows;
import org.sid.tayeur_app.dto.MesureHommeDto;
import org.sid.tayeur_app.dto.response.MesureHommeResponse;

import java.util.Optional;
import java.util.Set;

public interface MesureHommeInterface {
    MesureHommeResponse saveMesure(MesureHommeDto mesureHommeDto);

    Set<MesureHommeResponse> getAll();

    Optional<MesureHommeResponse> getById(Long id);

    @SneakyThrows
    void delete(Long id);
}
