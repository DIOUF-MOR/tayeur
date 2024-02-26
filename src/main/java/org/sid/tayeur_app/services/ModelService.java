package org.sid.tayeur_app.services;

import lombok.SneakyThrows;
import org.sid.tayeur_app.dto.ModelDto;
import org.sid.tayeur_app.dto.response.ModelResponse;
import org.sid.tayeur_app.entities.Model;
import org.sid.tayeur_app.enums.GenreClient;
import org.sid.tayeur_app.repositories.ModelRepository;
import org.sid.tayeur_app.services.interfaces.ModelInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ModelService implements ModelInterface {
    @Autowired
    private ModelRepository modelRepository;
    @Override
    public ModelResponse saveModel(ModelDto modelDto){
        Model model = ModelDto.toEntity(modelDto);
        return ModelDto.fromEntityResponse( modelRepository.save(model));
    }
    @Override
    public Set<ModelResponse> getAll(){
        return modelRepository.findAll().stream().map(ModelDto::fromEntityResponse).collect(Collectors.toSet());
    }
    @Override
    public Optional<ModelResponse> getById(Long id){
        return modelRepository.findById(id).map(ModelDto::fromEntityResponse);
    }
    @SneakyThrows
    @Override
    public void delete(Long id) {
        modelRepository.delete(modelRepository.findById(id).orElseThrow(()-> new NotFoundException("Le model avec l'id :"+ id + "n'a pas été trouvé!")));
    }
}
