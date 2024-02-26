package org.sid.tayeur_app.rest;

import lombok.RequiredArgsConstructor;
import org.sid.tayeur_app.dto.MesureFemmeDto;
import org.sid.tayeur_app.dto.MesureHommeDto;
import org.sid.tayeur_app.dto.response.MesureFemmeResponse;
import org.sid.tayeur_app.dto.response.MesureHommeResponse;
import org.sid.tayeur_app.rest.api.MesureFemmeApi;
import org.sid.tayeur_app.services.MesureFemmeService;
import org.sid.tayeur_app.services.MesureHommeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class MesureFemmeController implements MesureFemmeApi {
    private final MesureFemmeService mesureFemmeService;

    @Override
    public MesureFemmeResponse save(MesureFemmeDto mesureFemmeDto) {
        return mesureFemmeService.saveMesure(mesureFemmeDto);
    }

    @Override
    public Set<MesureFemmeResponse> getAll() {
        return mesureFemmeService.getAll();
    }

    @Override
    public Optional<MesureFemmeResponse> getById(Long id) {
        return mesureFemmeService.getById(id);
    }
}
