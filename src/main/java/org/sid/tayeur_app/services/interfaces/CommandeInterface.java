package org.sid.tayeur_app.services.interfaces;

import lombok.SneakyThrows;
import org.sid.tayeur_app.dto.CommandeDto;
import org.sid.tayeur_app.dto.response.CommandeResponse;

import java.util.Optional;
import java.util.Set;

public interface CommandeInterface {
    CommandeResponse saveCommande(CommandeDto commandeDto);

    Set<CommandeResponse> getAll();

    Optional<CommandeResponse> getById(Long id);

    @SneakyThrows
    void delete(Long id);

    CommandeResponse updateCommande(Long id, CommandeDto c);
}
