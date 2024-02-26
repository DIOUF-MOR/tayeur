package org.sid.tayeur_app.rest.api;

import org.sid.tayeur_app.dto.MesureFemmeDto;
import org.sid.tayeur_app.dto.MesureHommeDto;
import org.sid.tayeur_app.dto.response.MesureFemmeResponse;
import org.sid.tayeur_app.dto.response.MesureHommeResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RequestMapping("/mesurefemmes")
public interface MesureFemmeApi {
    @PostMapping("/add")
    MesureFemmeResponse save(@RequestBody MesureFemmeDto mesureFemmeDto);

    @GetMapping("/list")
    Set<MesureFemmeResponse> getAll();
    @GetMapping("/{id}")
    Optional<MesureFemmeResponse> getById(@PathVariable Long id);
}
