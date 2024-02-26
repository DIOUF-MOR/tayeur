package org.sid.tayeur_app.rest.api;

import org.sid.tayeur_app.dto.MesureHommeDto;
import org.sid.tayeur_app.dto.response.MesureHommeResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RequestMapping("/mesurehommes")
public interface MesureHommeApi {
    @PostMapping("/add")
    MesureHommeResponse save(@RequestBody MesureHommeDto mesureHommeDto);

    @GetMapping("/list")
    Set<MesureHommeResponse> getAll();
    @GetMapping("/{id}")
    Optional<MesureHommeResponse> getById(@PathVariable Long id);
}
