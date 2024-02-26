package org.sid.tayeur_app.dto.response;

import lombok.*;
import org.sid.tayeur_app.dto.CommandeDto;
import org.sid.tayeur_app.entities.Tayeur;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TayeurResponse {
    private Long id;
    private String nom;
    private String preNom;
    private Integer nombreCommandes;
    private String telephone;
    private String email;
    private String password;
    private Set<CommandeDto> commandeDtos;
    public TayeurResponse(Tayeur t){
        this.id=t.getId();
        this.nom=t.getNom();
        this.preNom=t.getPreNom();
        this.nombreCommandes=t.getNombreCommandes();
        this.telephone=t.getTelephone();
        this.email=t.getEmail();
        this.password=t.getPassword();
    }
}
