package org.sid.tayeur_app.dto.response;

import lombok.*;
import org.sid.tayeur_app.dto.ClientDto;
import org.sid.tayeur_app.dto.ModelDto;
import org.sid.tayeur_app.entities.MesureHomme;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MesureHommeResponse {
    private Long id;
    private Integer ceinture;
    private Integer epaul;
    private Integer poitrine;
    private Integer fesse;
    private Integer longueur;
    private Integer coup;
    private Integer cuisse;
    private Integer biceps;
    private Integer poignet;
    private Integer longueurPentallon;
    private Integer bras;
    private ClientDto clientDto;
    public MesureHommeResponse(MesureHomme m){
        this.id= m.getId();
        this.longueur=m.getLongueur();
        this.coup= m.getCoup();
        this.ceinture= m.getCeinture();
        this.epaul= m.getEpaul();
        this.poitrine=m.getPoitrine();
        this.fesse=m.getFesse();
        this.biceps=m.getBiceps();
        this.bras=m.getBras();
        this.poignet=m.getPoignet();
        this.longueurPentallon=m.getLongueurPentallon();
        this.cuisse=m.getCuisse();
    }
}
