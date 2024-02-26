package org.sid.tayeur_app.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.sid.tayeur_app.dto.CommandeDto;
import org.sid.tayeur_app.dto.TayeurDto;
import org.sid.tayeur_app.dto.response.TayeurResponse;
import org.sid.tayeur_app.entities.Commande;
import org.sid.tayeur_app.entities.Tayeur;
import org.sid.tayeur_app.repositories.CommandeRepository;
import org.sid.tayeur_app.repositories.TayeurRepository;
import org.sid.tayeur_app.services.interfaces.TayeurInterface;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TayeurService implements TayeurInterface {
    private final TayeurRepository tayeurRepository;
    private final CommandeRepository commandeRepository;

    @Override
    public TayeurResponse save(TayeurDto t) {
        Tayeur tayeur = TayeurDto.toEntity(t);
        return TayeurDto.fromEntityResponse(tayeurRepository.save(tayeur));
    }

    @Override
    public Set<TayeurResponse> getAll() {
        return tayeurRepository.findAll().stream().map(TayeurDto::fromEntityResponse).collect(Collectors.toSet());
    }

    @Override
    public Optional<TayeurResponse> getById(Long id) {
        return tayeurRepository.findById(id).map(TayeurDto::fromEntityResponse);
    }
    @Override
    public TayeurResponse update(Long id, TayeurDto t) {
        Optional<Tayeur> tayeurOptional = tayeurRepository.findById(id);
        if (tayeurOptional.isPresent()) {
            Tayeur tayeur = tayeurOptional.get();
            System.out.println(t.getNom());
            tayeur.setId(t.getId());
            tayeur.setNom(t.getNom());
            tayeur.setPreNom(t.getPreNom());
            tayeur.setNombreCommandes(t.getNombreCommandes());
            tayeur.setTelephone(t.getTelephone());
            tayeur.setEmail(t.getEmail());
            tayeur.setPassword(t.getPassword());
            tayeur.setCommandes(tayeur.getCommandes());
            //List<Commande> updateCommande = new ArrayList<>();
            /*
            if (t.getCommandeDtos()!=null) {
                for (CommandeDto commandeDto : t.getCommandeDtos()) {
                    Optional<Commande> existingCommande = commandeRepository.findById(commandeDto.getId());
                    if (existingCommande.isPresent()) {
                        Commande commandeExisting = existingCommande.get();
                        commandeExisting.setId(commandeDto.getId());
                        commandeExisting.setDateCreation(commandeDto.getDateCreation());
                        commandeExisting.setDelais(commandeDto.getDelais());
                        commandeExisting.setPrix(commandeDto.getPrix());
                        commandeExisting.setEtat(commandeDto.getEtat());
                        commandeExisting.setMontantVersse(commandeDto.getMontantVersse());
                        updateCommande.add(commandeExisting);
                    } else {
                        throw new EntityNotFoundException("L'entité avec l'ID " + id + " n'a pas été trouvée.");
                    }
                }

            Set<Commande> commandeSet = new HashSet<>(updateCommande);
            tayeur.setCommandes(commandeSet);
            }

             */
            return TayeurDto.fromEntityResponse(tayeurRepository.save(tayeur));

        } else {
            throw new EntityNotFoundException("L'entité avec l'ID " + id + " n'a pas été trouvée.");
        }

    }

    @SneakyThrows
    @Override
    public void delete(Long id) {
        tayeurRepository.delete(tayeurRepository.findById(id).orElseThrow(()-> new NotFoundException("Le tayeur avec l'id :"+ id + "n'a pas été trouvé!")));
    }
}