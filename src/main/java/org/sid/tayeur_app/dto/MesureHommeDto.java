package org.sid.tayeur_app.dto;
import lombok.*;
import org.sid.tayeur_app.dto.response.MesureHommeResponse;
import org.sid.tayeur_app.entities.MesureHomme;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MesureHommeDto {
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

    public static MesureHommeDto fromEntity(MesureHomme m){
        if( m==null)return null;
        return MesureHommeDto.builder()
                .id(m.getId())
                .longueur(m.getLongueur())
                .cuisse(m.getCuisse())
                .bras(m.getBras())
                .ceinture(m.getCeinture())
                .epaul(m.getEpaul())
                .poitrine(m.getPoitrine())
                .fesse(m.getFesse())
                .poignet(m.getPoignet())
                .longueurPentallon(m.getLongueurPentallon())
                .biceps(m.getBiceps())
                .coup(m.getCoup())
                .clientDto(ClientDto.fromEntity(m.getClient()))
                //.commandeDtos(CommandeDto.fromEntity(m.getCommandes()))
                .build();
    }
    public static Set<MesureHommeDto> fromEntity(Set<MesureHomme> dtos){
        if(dtos== null ) return Collections.emptySet();

        return dtos.stream().map(MesureHommeDto::fromEntity).collect(Collectors.toSet());

    }
    public static MesureHommeResponse fromEntityResponse(MesureHomme m){
        if(m==null)return null;
        return MesureHommeResponse.builder()
                .id(m.getId())
                .longueur(m.getLongueur())
                .cuisse(m.getBiceps())
                .bras(m.getBras())
                .ceinture(m.getCeinture())
                .epaul(m.getEpaul())
                .poitrine(m.getPoitrine())
                .fesse(m.getFesse())
                .biceps(m.getBiceps())
                .longueurPentallon(m.getLongueurPentallon())
                .poignet(m.getPoignet())
                .coup(m.getCoup())
                .clientDto(ClientDto.fromEntity(m.getClient()))
                .build();
    }
    public static MesureHomme toEntity(MesureHommeDto mdto){
        if(mdto==null)return null;
        MesureHomme m=new MesureHomme();
        m.setBiceps(mdto.getBiceps());
        m.setId(mdto.getId());
        m.setCoup(mdto.getCoup());
        m.setBras(mdto.getBras());
        m.setEpaul(mdto.getEpaul());
        m.setCeinture(mdto.getCeinture());
        m.setFesse(mdto.getFesse());
        m.setLongueurPentallon(mdto.getLongueurPentallon());
        m.setLongueur(mdto.getLongueur());
        m.setPoitrine(mdto.getPoitrine());
        m.setCuisse(mdto.getCuisse());
        m.setPoignet(mdto.getPoignet());
        m.setClient(ClientDto.toEntity(mdto.getClientDto()));
        return m;
    }
    public MesureHommeDto(MesureHomme m){
        this.id= m.getId();
        this.longueur=m.getLongueur();
        this.coup= m.getCoup();
        this.ceinture= m.getCeinture();
        this.epaul= m.getEpaul();
        this.poitrine=m.getPoitrine();
        this.fesse=m.getFesse();
        this.cuisse=m.getCuisse();
        this.bras=m.getBras();
        this.poignet=m.getPoignet();
        this.biceps=m.getBiceps();
        this.longueurPentallon=m.getLongueurPentallon();
        this.clientDto=ClientDto.fromEntity(m.getClient());
    }
}
