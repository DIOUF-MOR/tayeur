package org.sid.tayeur_app.dto.response;

import lombok.*;
import org.sid.tayeur_app.dto.ClientDto;
import org.sid.tayeur_app.dto.ModelDto;
import org.sid.tayeur_app.dto.TayeurDto;
import org.sid.tayeur_app.entities.Commande;
import org.sid.tayeur_app.enums.EtatCommande;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommandeResponse {
    private Long id;
    private LocalDate dateCreation;
    private LocalDate delais;
    private EtatCommande etat;
    private double montantVersse;
    private double prix;
    private ClientDto clientDto;
    private TayeurDto tayeurDto;
    private ModelDto modelDto;
    public CommandeResponse(Commande c){
        this.id=c.getId();
        this.dateCreation=c.getDateCreation();
        this.delais=c.getDelais();
        this.etat=c.getEtat();
        this.prix=c.getPrix();

    }
}
