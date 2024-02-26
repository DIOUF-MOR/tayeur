package org.sid.tayeur_app.rest.api;

import org.sid.tayeur_app.dto.ClientDto;
import org.sid.tayeur_app.dto.response.ClientResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RequestMapping("/clients")
public interface ClientApi {
    @PostMapping("/add")
   ClientResponse save(@RequestBody ClientDto clientDto);
    @GetMapping("/list")
    Set<ClientResponse> getAll();

    @GetMapping("/{id}")
    Optional<ClientResponse> getById(@PathVariable Long id);
}
