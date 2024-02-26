package org.sid.tayeur_app.dto;

import lombok.*;
import org.sid.tayeur_app.dto.response.CommandeResponse;
import org.sid.tayeur_app.entities.Commande;
import org.sid.tayeur_app.entities.Tayeur;
import org.sid.tayeur_app.enums.EtatCommande;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommandeDto {
    private Long id;
    private LocalDate dateCreation;
    private LocalDate delais;
    private EtatCommande etat;
    private double prix;
    private double montantVersse;
    private ClientDto clientDto;
    private TayeurDto tayeurDto;
    private ModelDto modelDto;
    public static CommandeDto fromEntity(Commande c){
        if(c==null)return  null;
       return CommandeDto.builder()
                .id(c.getId())
                .etat(c.getEtat())
                .dateCreation(c.getDateCreation())
                .delais(c.getDelais())
                .montantVersse(c.getMontantVersse())
                .prix(c.getPrix())
                .build();
    }
    public static Set<CommandeDto> fromEntity(Set<Commande> dtos){
        if(dtos== null ) return Collections.emptySet();

        return dtos.stream().map(CommandeDto::fromEntity).collect(Collectors.toSet());

    }
public static CommandeResponse fromEntityResponse(Commande c){
        if(c==null)return null;
        return CommandeResponse.builder()
                .id(c.getId())
                .etat(c.getEtat())
                .dateCreation(c.getDateCreation())
                .delais(c.getDelais())
                .montantVersse(c.getMontantVersse())
                .prix(c.getPrix())
                .clientDto(ClientDto.fromEntity(c.getClient()))
                .tayeurDto(TayeurDto.fromEntity(c.getTayeur()))
                .modelDto(ModelDto.fromEntity(c.getModel()))
                .build();
}
    public static Commande toEntity(CommandeDto c){
        if(c==null)return null;
        Commande commande=new Commande();
        commande.setId(c.getId());
        commande.setEtat(c.getEtat());
        commande.setDelais(c.getDelais());
        commande.setMontantVersse(c.getMontantVersse());
        commande.setPrix(c.getPrix());
        commande.setDateCreation(c.getDateCreation());
        commande.setClient(ClientDto.toEntity(c.getClientDto()));
        commande.setTayeur(TayeurDto.toEntity(c.getTayeurDto()));
        commande.setModel(ModelDto.toEntity(c.getModelDto()));
        return commande;
    }
    public CommandeDto(Commande c){
        this.id=c.getId();
        this.etat=c.getEtat();
        this.delais=c.getDelais();
        this.dateCreation=c.getDateCreation();
        this.montantVersse=c.getMontantVersse();
        this.prix=c.getPrix();

    }

}
