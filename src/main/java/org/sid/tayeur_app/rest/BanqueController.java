package org.sid.tayeur_app.rest;

import lombok.RequiredArgsConstructor;
import org.sid.tayeur_app.dto.BanqueDto;
import org.sid.tayeur_app.dto.response.BanqueResponse;
import org.sid.tayeur_app.rest.api.BanqueApi;
import org.sid.tayeur_app.services.BanqueService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class BanqueController implements BanqueApi {
    private final BanqueService banqueService;
    @Override
    public BanqueResponse save(BanqueDto banqueDto) {
        return banqueService.save(banqueDto);
    }

    @Override
    public Optional<BanqueResponse> getById(Long id) {
        return banqueService.findById(id);
    }
}
