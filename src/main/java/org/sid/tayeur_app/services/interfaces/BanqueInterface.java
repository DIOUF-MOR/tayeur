package org.sid.tayeur_app.services.interfaces;

import org.sid.tayeur_app.dto.BanqueDto;
import org.sid.tayeur_app.dto.response.BanqueResponse;

import java.util.Optional;

public interface BanqueInterface {
    BanqueResponse save(BanqueDto bDto);
    Optional<BanqueResponse> findById(Long id);
}
