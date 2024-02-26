package org.sid.tayeur_app.rest.api;

import org.sid.tayeur_app.dto.BanqueDto;
import org.sid.tayeur_app.dto.response.BanqueResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/banques")
public interface BanqueApi {
    @PostMapping("/add")
    BanqueResponse save(@RequestBody BanqueDto banqueDto);
    @GetMapping("/{id}")
    Optional<BanqueResponse> getById(@PathVariable Long id);
}
