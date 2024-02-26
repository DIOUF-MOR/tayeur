package org.sid.tayeur_app.dto;
import ch.qos.logback.core.model.Model;
import lombok.*;
import org.sid.tayeur_app.dto.response.ClientResponse;
import org.sid.tayeur_app.entities.Client;
import org.sid.tayeur_app.enums.GenreClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    private Long id;
    private String nomComplet;
    private String telephone;
    private GenreClient type;

    private MesureHommeDto mesureHommeDto;
    private MesureFemmeDto mesureFemmeDto;
    private Set<CommandeDto> commandeDtos;
    public static ClientDto fromEntity(Client client){
        if (client==null)return null;
        return ClientDto.builder()
                .id(client.getId())
                //.commandeDtos(CommandeDto.fromEntity(client.getCommandes()))
                .nomComplet(client.getNomComplet())
                .telephone(client.getTelephone())
                .type(client.getType())
                .mesureFemmeDto(MesureFemmeDto.fromEntity(client.getMesureFemme()))
                .mesureHommeDto(MesureHommeDto.fromEntity(client.getMesureHomme()))
                .build();
    }
    public static ClientResponse fromEntityResponse(Client c){
        if(c==null)return null;
        return ClientResponse.builder()
                .id(c.getId())
                .type(c.getType())
                .telephone(c.getTelephone())
                .nomComplet(c.getNomComplet())
                .mesureHommeDto(MesureHommeDto.fromEntity(c.getMesureHomme()))
                .mesureFemmeDto(MesureFemmeDto.fromEntity(c.getMesureFemme()))
                .commandeDtos(CommandeDto.fromEntity(c.getCommandes()))
                .build();
    }
    public static Client toEntity(ClientDto clientDto){
        if(clientDto==null)return null;
        Client c=new Client();
        c.setId(clientDto.getId());
        c.setType(clientDto.getType());
        c.setTelephone(clientDto.getTelephone());
        c.setNomComplet(clientDto.getNomComplet());
        if (clientDto.getType()==GenreClient.HOMME){
        c.setMesureHomme(MesureHommeDto.toEntity(clientDto.getMesureHommeDto()));
        }
        if (clientDto.getType()==GenreClient.FEMME){
            c.setMesureFemme(MesureFemmeDto.toEntity(clientDto.getMesureFemmeDto()));
        }
        if (clientDto.getCommandeDtos() != null) {
            c.setCommandes(clientDto.getCommandeDtos().stream().map(CommandeDto::toEntity).collect(Collectors.toSet()));
        }
        return c;
    }
    public ClientDto(Client c){
        this.id=c.getId();
        this.type=c.getType();
        this.nomComplet=c.getNomComplet();
        this.telephone=c.getTelephone();
        this.commandeDtos=c.getCommandes().stream().map(CommandeDto::fromEntity).collect(Collectors.toSet());
        this.mesureFemmeDto=MesureFemmeDto.fromEntity(c.getMesureFemme());
        this.mesureHommeDto=MesureHommeDto.fromEntity(c.getMesureHomme());
    }
}
