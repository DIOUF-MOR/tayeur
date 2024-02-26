package org.sid.tayeur_app.dto.response;

import lombok.*;
import org.sid.tayeur_app.dto.CommandeDto;
import org.sid.tayeur_app.dto.MesureFemmeDto;
import org.sid.tayeur_app.dto.MesureHommeDto;
import org.sid.tayeur_app.dto.ModelDto;
import org.sid.tayeur_app.entities.Client;
import org.sid.tayeur_app.enums.GenreClient;

import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientResponse {
    private Long id;
    private String nomComplet;
    private String telephone;
    private GenreClient type;
    private Set<CommandeDto> commandeDtos;
    private MesureHommeDto mesureHommeDto;
    private MesureFemmeDto mesureFemmeDto;
    public ClientResponse(Client c){
        this.id= c.getId();
        this.type=c.getType();
        this.nomComplet=c.getNomComplet();
        this.telephone=c.getTelephone();

    }
}
