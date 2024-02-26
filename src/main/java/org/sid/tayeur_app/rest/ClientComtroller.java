package org.sid.tayeur_app.rest;

import lombok.RequiredArgsConstructor;
import org.sid.tayeur_app.dto.ClientDto;
import org.sid.tayeur_app.dto.response.ClientResponse;
import org.sid.tayeur_app.rest.api.ClientApi;
import org.sid.tayeur_app.services.ClientService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class ClientComtroller implements ClientApi {
    private final ClientService clientService;

    @Override
    public ClientResponse save(ClientDto clientDto) {
        return clientService.saveClient(clientDto);
    }

    @Override
    public Set<ClientResponse> getAll() {
        return clientService.getAll();
    }

    @Override
    public Optional<ClientResponse> getById(Long id) {
        return clientService.getById(id);
    }

}
