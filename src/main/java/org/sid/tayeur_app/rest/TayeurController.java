package org.sid.tayeur_app.rest;

import lombok.RequiredArgsConstructor;
import org.sid.tayeur_app.dto.TayeurDto;
import org.sid.tayeur_app.dto.response.TayeurResponse;
import org.sid.tayeur_app.rest.api.TayeurApi;
import org.sid.tayeur_app.services.TayeurService;
import org.sid.tayeur_app.services.interfaces.TayeurInterface;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class TayeurController implements TayeurApi {
    private final TayeurInterface tayeurInterface;
    @Override
    public TayeurResponse save(TayeurDto tayeurDto) {
        return tayeurInterface.save(tayeurDto);
    }

    @Override
    public Set<TayeurResponse> getAll() {
        return tayeurInterface.getAll();
    }

    @Override
    public Optional<TayeurResponse> getById(Long id) {
        return tayeurInterface.getById(id);
    }
    @PutMapping("/update/{id}")
    public TayeurResponse updateTayeur(Long id, TayeurDto tayeurDto) {
        return tayeurInterface.update(id,tayeurDto);
    }

}
