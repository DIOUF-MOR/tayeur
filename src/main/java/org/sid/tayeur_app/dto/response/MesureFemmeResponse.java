package org.sid.tayeur_app.dto.response;

import lombok.*;
import org.sid.tayeur_app.dto.ClientDto;
import org.sid.tayeur_app.dto.MesureFemmeDto;
import org.sid.tayeur_app.dto.ModelDto;
import org.sid.tayeur_app.entities.MesureFemme;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MesureFemmeResponse {
    private Long id;
    private Integer ceinture;
    private Integer epaul;
    private Integer poitrine;
    private Integer fesse;
    private Integer anche;
    private Integer taille;
    private Integer longueurTailleBasse;
    private Integer longueurTaille;
    private Integer longueurMarignere;
    private Integer longueurRobe;
    private Integer longueurJup;
    private Integer longueurRobeTroisQuart;
    private ClientDto clientDto;
    public MesureFemmeResponse(MesureFemme mesureFemme){
        this.id=mesureFemme.getId();
        this.ceinture=mesureFemme.getCeinture();
        this.epaul=mesureFemme.getEpaul();
        this.poitrine=mesureFemme.getPoitrine();
        this.fesse= mesureFemme.getFesse();
        this.anche=mesureFemme.getAnche();
        this.taille=mesureFemme.getTaille();
        this.longueurTaille=mesureFemme.getLongueurTaille();
        this.longueurTailleBasse=mesureFemme.getLongueurTailleBasse();
        this.longueurMarignere=mesureFemme.getLongueurMarignere();
        this.longueurRobe=mesureFemme.getLongueurRobe();
        this.longueurJup=mesureFemme.getLongueurJup();
        this.longueurRobeTroisQuart=mesureFemme.getLongueurRobeTroisQuart();
    }
}
