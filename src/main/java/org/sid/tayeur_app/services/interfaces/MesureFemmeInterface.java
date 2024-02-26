package org.sid.tayeur_app.services.interfaces;

import lombok.SneakyThrows;
import org.sid.tayeur_app.dto.MesureFemmeDto;
import org.sid.tayeur_app.dto.MesureHommeDto;
import org.sid.tayeur_app.dto.response.MesureFemmeResponse;
import org.sid.tayeur_app.dto.response.MesureHommeResponse;

import java.util.Optional;
import java.util.Set;

public interface MesureFemmeInterface {


    MesureFemmeResponse saveMesure(MesureFemmeDto mesureFemmeDto);

    Set<MesureFemmeResponse> getAll();

    Optional<MesureFemmeResponse> getById(Long id);

    @SneakyThrows
    void delete(Long id);
}
