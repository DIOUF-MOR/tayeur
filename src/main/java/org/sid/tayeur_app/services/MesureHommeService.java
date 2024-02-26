package org.sid.tayeur_app.services;

import lombok.SneakyThrows;
import org.sid.tayeur_app.dto.MesureHommeDto;
import org.sid.tayeur_app.dto.response.MesureHommeResponse;
import org.sid.tayeur_app.entities.MesureHomme;
import org.sid.tayeur_app.repositories.MesureHommeRepository;
import org.sid.tayeur_app.services.interfaces.MesureHommeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MesureHommeService implements MesureHommeInterface {
    @Autowired
    private MesureHommeRepository mesureHommeRepository;
    @Override
    public MesureHommeResponse saveMesure(MesureHommeDto mesureHommeDto){
        MesureHomme mesure = MesureHommeDto.toEntity(mesureHommeDto);

        return MesureHommeDto.fromEntityResponse( mesureHommeRepository.save(mesure));
    }
    @Override
    public Set<MesureHommeResponse> getAll(){
        return mesureHommeRepository.findAll().stream().map(MesureHommeDto::fromEntityResponse).collect(Collectors.toSet());
    }
    @Override
    public Optional<MesureHommeResponse> getById(Long id){
        return mesureHommeRepository.findById(id).map(MesureHommeDto::fromEntityResponse);
    }
    @SneakyThrows
    @Override
    public void delete(Long id) {
        mesureHommeRepository.delete(mesureHommeRepository.findById(id).orElseThrow(()-> new NotFoundException("Les mesures avec l'id :"+ id + "n'a pas été trouvé!")));
    }
}
