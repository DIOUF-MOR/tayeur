package org.sid.tayeur_app.rest;

import lombok.RequiredArgsConstructor;
import org.sid.tayeur_app.dto.CommandeDto;
import org.sid.tayeur_app.dto.response.CommandeResponse;
import org.sid.tayeur_app.rest.api.CommandeApi;
import org.sid.tayeur_app.services.CommandeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class CommandeController implements CommandeApi {
    private final CommandeService commandeService;
    @Override
    public CommandeResponse save(CommandeDto commandeDto) {
        return commandeService.saveCommande(commandeDto);
    }

    @Override
    public Set<CommandeResponse> getAll() {
        return commandeService.getAll();
    }

    @Override
    public Optional<CommandeResponse> getById(Long id) {
        return commandeService.getById(id);
    }

    @Override
    public void deleteCommande(Long id) {
        commandeService.delete(id);
    }
}
