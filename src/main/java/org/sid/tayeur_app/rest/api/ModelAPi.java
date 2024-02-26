package org.sid.tayeur_app.rest.api;

import org.sid.tayeur_app.dto.ClientDto;
import org.sid.tayeur_app.dto.ModelDto;
import org.sid.tayeur_app.dto.response.ClientResponse;
import org.sid.tayeur_app.dto.response.CommandeResponse;
import org.sid.tayeur_app.dto.response.ModelResponse;
import org.sid.tayeur_app.entities.Model;
import org.sid.tayeur_app.enums.GenreClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.Set;

@RequestMapping("/models")
public interface ModelAPi {
    @PostMapping("/add")
    ResponseEntity<String> save(@RequestParam("file") MultipartFile file,
                                       @RequestParam("type") GenreClient type,
                                       @RequestParam("nom") String nom);
    @PutMapping("/update/{id}")
    ResponseEntity<String> update(@PathVariable Long id,@RequestParam("file") MultipartFile file,
                                @RequestParam("type") GenreClient type,
                                @RequestParam("nom") String nom) throws IOException;
    @GetMapping("/list")
    Set<ModelResponse> getAll();
    @GetMapping("/{id}")
    Optional<ModelResponse> getById(@PathVariable Long id);
}
