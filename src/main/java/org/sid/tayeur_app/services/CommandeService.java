package org.sid.tayeur_app.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.SneakyThrows;
import org.sid.tayeur_app.dto.*;
import org.sid.tayeur_app.dto.response.CommandeResponse;
import org.sid.tayeur_app.entities.Commande;
import org.sid.tayeur_app.enums.EtatCommande;
import org.sid.tayeur_app.listeners.CommandeAjoutEvent;
import org.sid.tayeur_app.repositories.CommandeRepository;
import org.sid.tayeur_app.services.interfaces.CommandeInterface;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CommandeService implements CommandeInterface {
    private final CommandeRepository commandeRepository;
    private final ApplicationEventPublisher eventPublisher;
    public CommandeService(CommandeRepository commandeRepository, ApplicationEventPublisher eventPublisher) {
        this.commandeRepository = commandeRepository;
        this.eventPublisher = eventPublisher;
    }
    @Override
    public CommandeResponse saveCommande(CommandeDto commandeDto){
        Commande commande = CommandeDto.toEntity(commandeDto);

            if (commande.getMontantVersse()==0){
                commande.setEtat(EtatCommande.NON_PRIS_EN_CHARGE);
            }else {
                commande.setEtat(EtatCommande.PRIS_EN_CHARGE);
            }
        if (commande.getMontantVersse()!=0){
        eventPublisher.publishEvent(new CommandeAjoutEvent(this, commande));
        }
        return CommandeDto.fromEntityResponse( commandeRepository.save(commande));
    }

    @Override
    public Set<CommandeResponse> getAll(){
        return commandeRepository.findAll().stream().map(CommandeDto::fromEntityResponse).collect(Collectors.toSet());
    }
    @Override
    public Optional<CommandeResponse> getById(Long id){
        return commandeRepository.findById(id).map(CommandeDto::fromEntityResponse);
    }
    @SneakyThrows
    @Override
    public void delete(Long id) {
        commandeRepository.delete(commandeRepository.findById(id).orElseThrow(()-> new NotFoundException("La commande avec l'id :"+ id + "n'a pas été trouvé!")));
    }
    @Override
    public CommandeResponse updateCommande(Long id,CommandeDto c){
    Optional<Commande> commandeOptional=commandeRepository.findById(id);
        if (commandeOptional.isPresent()){
            Commande commande=commandeOptional.get();
            commande.setEtat(c.getEtat());
            commande.setId(commande.getId());
            commande.setDelais(c.getDelais());
            commande.setDateCreation(c.getDateCreation());
            commande.setMontantVersse(c.getMontantVersse());
            commande.setPrix(c.getPrix());
            commande.setClient(ClientDto.toEntity(c.getClientDto()));
            commande.setTayeur(TayeurDto.toEntity(c.getTayeurDto()));
            return CommandeDto.fromEntityResponse(commande);
        } else {
            throw new EntityNotFoundException("L'entité avec l'ID " + id + " n'a pas été trouvée.");
        }
    }
}
