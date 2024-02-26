package org.sid.tayeur_app.rest.api;

import org.sid.tayeur_app.dto.CommandeDto;
import org.sid.tayeur_app.dto.response.CommandeResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RequestMapping("/commandes")
public interface CommandeApi {
    @PostMapping("/add")
    CommandeResponse save(@RequestBody CommandeDto commandeDto);
    @GetMapping("/list")
    Set<CommandeResponse> getAll();
    @GetMapping("/{id}")
    Optional<CommandeResponse> getById(@PathVariable Long id);
    @DeleteMapping("/delete/{id}")
    void deleteCommande(@PathVariable Long id);

}
