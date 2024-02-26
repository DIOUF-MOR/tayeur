package org.sid.tayeur_app.rest;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.sid.tayeur_app.dto.ModelDto;
import org.sid.tayeur_app.dto.response.ModelResponse;
import org.sid.tayeur_app.entities.Model;
import org.sid.tayeur_app.enums.GenreClient;
import org.sid.tayeur_app.repositories.ModelRepository;
import org.sid.tayeur_app.rest.api.ModelAPi;
import org.sid.tayeur_app.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.Set;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class ModelController implements ModelAPi {
    private final ModelService modelService;
    @Autowired
    private ModelRepository modelRepository;
    @Override
    public ResponseEntity<String> save(@RequestParam("file") MultipartFile file,
                                       @RequestParam("type") GenreClient type,
                                       @RequestParam("nom") String nom) {
        try {
            Model model = new Model();
            model.setImage(file.getBytes());  // Store the bytes directly
            model.setType(type);
            model.setNom(nom);
            System.out.println(model.getImage());
            modelRepository.save(model);

            return ResponseEntity.ok("Model uploaded successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to upload model: " + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<String> update(Long id, MultipartFile file, GenreClient type, String nom) throws IOException {

            Optional<Model> model = modelRepository.findById(id);
            if (model.isPresent()){
                Model model1=model.get();
                model1.setImage(file.getBytes());  // Store the bytes directly
                model1.setType(type);
                model1.setNom(nom);
                modelRepository.save(model1);
                return ResponseEntity.ok("Model uploaded successfully!");
            } else {
                throw new EntityNotFoundException("L'entité avec l'ID " + id + " n'a pas été trouvée.");
            }

    }

    @Override
    public Set<ModelResponse> getAll() {
        return modelService.getAll();
    }

    @Override
    public Optional<ModelResponse> getById(Long id) {
        return modelService.getById(id);
    }
}
