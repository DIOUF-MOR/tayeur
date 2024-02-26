package org.sid.tayeur_app.dto;

import lombok.*;
import org.sid.tayeur_app.dto.response.MesureFemmeResponse;
import org.sid.tayeur_app.dto.response.MesureHommeResponse;
import org.sid.tayeur_app.entities.MesureFemme;
import org.sid.tayeur_app.entities.MesureHomme;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MesureFemmeDto {
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
    public static MesureFemmeDto fromEntity(MesureFemme m){
        if( m==null)return null;
        return MesureFemmeDto.builder()
                .id(m.getId())
                .taille(m.getTaille())
                .anche(m.getAnche())
                .longueurTailleBasse(m.getLongueurTailleBasse())
                .ceinture(m.getCeinture())
                .epaul(m.getEpaul())
                .poitrine(m.getPoitrine())
                .fesse(m.getFesse())
                .longueurJup(m.getLongueurJup())
                .longueurTaille(m.getLongueurTaille())
                .longueurMarignere(m.getLongueurMarignere())
                .longueurRobe(m.getLongueurRobe())
                .longueurRobeTroisQuart(m.getLongueurRobeTroisQuart())
                .clientDto(ClientDto.fromEntity(m.getClient()))
                //.commandeDtos(CommandeDto.fromEntity(m.getCommandes()))
                .build();
    }
    public static Set<MesureFemmeDto> fromEntity(Set<MesureFemme> dtos){
        if(dtos== null ) return Collections.emptySet();

        return dtos.stream().map(MesureFemmeDto::fromEntity).collect(Collectors.toSet());

    }
    public static MesureFemmeResponse fromEntityResponse(MesureFemme m){
        if(m==null)return null;
        return MesureFemmeResponse.builder()
                .id(m.getId())
                .taille(m.getTaille())
                .longueurTaille(m.getLongueurTaille())
                .longueurJup(m.getLongueurJup())
                .ceinture(m.getCeinture())
                .epaul(m.getEpaul())
                .poitrine(m.getPoitrine())
                .fesse(m.getFesse())
                .longueurMarignere(m.getLongueurMarignere())
                .longueurRobe(m.getLongueurRobe())
                .longueurTailleBasse(m.getLongueurTaille())
                .longueurRobeTroisQuart(m.getLongueurRobeTroisQuart())
                .fesse(m.getFesse())
                .clientDto(ClientDto.fromEntity(m.getClient()))
                .build();
    }
    public static MesureFemme toEntity(MesureFemmeDto mdto){
        if(mdto==null)return null;
        MesureFemme m=new MesureFemme();
        m.setAnche(mdto.getAnche());
        m.setId(mdto.getId());
        m.setLongueurJup(mdto.getLongueurJup());
        m.setTaille(mdto.getTaille());
        m.setEpaul(mdto.getEpaul());
        m.setCeinture(mdto.getCeinture());
        m.setFesse(mdto.getFesse());
        m.setLongueurTaille(mdto.getLongueurTaille());
        m.setLongueurMarignere(mdto.getLongueurMarignere());
        m.setPoitrine(mdto.getPoitrine());
        m.setLongueurTailleBasse(mdto.getLongueurTailleBasse());
        m.setLongueurRobeTroisQuart(mdto.getLongueurRobeTroisQuart());
        m.setFesse(m.getFesse());
        m.setClient(ClientDto.toEntity(mdto.getClientDto()));
        return m;
    }
}
