package org.sid.tayeur_app.rest.api;

import org.sid.tayeur_app.dto.ModelDto;
import org.sid.tayeur_app.dto.TayeurDto;
import org.sid.tayeur_app.dto.response.ModelResponse;
import org.sid.tayeur_app.dto.response.TayeurResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RequestMapping("/tayeurs")
public interface TayeurApi {
    @PostMapping("/add")
    TayeurResponse save(@RequestBody TayeurDto tayeurDto);
    @GetMapping("/list")
    Set<TayeurResponse> getAll();
    @GetMapping("/{id}")
    Optional<TayeurResponse> getById(@PathVariable Long id);
    @PutMapping("/update/{id}")
    TayeurResponse updateTayeur(@PathVariable(name = "id") Long id,@RequestBody TayeurDto tayeurDto);
}
