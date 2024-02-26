package org.sid.tayeur_app.services.interfaces;

import lombok.SneakyThrows;
import org.sid.tayeur_app.dto.ClientDto;
import org.sid.tayeur_app.dto.response.ClientResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

public interface ClientInterface {
    ClientResponse saveClient(ClientDto clientDto);

    Set<ClientResponse> getAll();

    Optional<ClientResponse> getById(Long id);

    @SneakyThrows
    void delete(Long id);
}
