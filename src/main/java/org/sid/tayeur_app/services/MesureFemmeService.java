package org.sid.tayeur_app.services;

import lombok.SneakyThrows;
import org.sid.tayeur_app.dto.MesureFemmeDto;
import org.sid.tayeur_app.dto.response.MesureFemmeResponse;
import org.sid.tayeur_app.entities.MesureFemme;
import org.sid.tayeur_app.repositories.MesureFemmeRepository;
import org.sid.tayeur_app.services.interfaces.MesureFemmeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MesureFemmeService implements MesureFemmeInterface {
    @Autowired
    private MesureFemmeRepository mesureFemmeRepository;
    @Override
    public MesureFemmeResponse saveMesure(MesureFemmeDto mesureFemmeDto){
        MesureFemme mesure = MesureFemmeDto.toEntity(mesureFemmeDto);

        return MesureFemmeDto.fromEntityResponse( mesureFemmeRepository.save(mesure));
    }
    @Override
    public Set<MesureFemmeResponse> getAll(){
        return mesureFemmeRepository.findAll().stream().map(MesureFemmeDto::fromEntityResponse).collect(Collectors.toSet());
    }
    @Override
    public Optional<MesureFemmeResponse> getById(Long id){
        return mesureFemmeRepository.findById(id).map(MesureFemmeDto::fromEntityResponse);
    }
    @SneakyThrows
    @Override
    public void delete(Long id) {
        mesureFemmeRepository.delete(mesureFemmeRepository.findById(id).orElseThrow(()-> new NotFoundException("Les mesures avec l'id :"+ id + "n'a pas été trouvé!")));
    }
}
