package org.sid.tayeur_app.rest;

import lombok.RequiredArgsConstructor;
import org.sid.tayeur_app.dto.MesureHommeDto;
import org.sid.tayeur_app.dto.response.MesureHommeResponse;
import org.sid.tayeur_app.rest.api.MesureFemmeApi;
import org.sid.tayeur_app.rest.api.MesureHommeApi;
import org.sid.tayeur_app.services.MesureHommeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class MesureHommeController implements MesureHommeApi {
    private final MesureHommeService mesureHommeService;

    @Override
    public MesureHommeResponse save(MesureHommeDto mesureHommeDto) {
        return mesureHommeService.saveMesure(mesureHommeDto);
    }

    @Override
    public Set<MesureHommeResponse> getAll() {
        return mesureHommeService.getAll();
    }

    @Override
    public Optional<MesureHommeResponse> getById(Long id) {
        return mesureHommeService.getById(id);
    }
}
