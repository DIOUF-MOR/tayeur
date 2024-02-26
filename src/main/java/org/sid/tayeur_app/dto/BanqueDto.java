package org.sid.tayeur_app.dto;

import lombok.*;
import org.sid.tayeur_app.dto.response.BanqueResponse;
import org.sid.tayeur_app.entities.Banque;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BanqueDto {
    private Long id;
    private double enCaisse;
    private double dette;
    private double total;

    public static BanqueDto fromEntity(Banque b){
        if (b==null)return null;
        return BanqueDto.builder()
                .id(b.getId())
                .total(b.getTotal())
                .enCaisse(b.getEnCaisse())
                .build();
    }
    public static BanqueResponse fronEntityResponse(Banque b){
        if (b==null)return null;
        return BanqueResponse.builder()
                .id(b.getId())
                .total(b.getTotal())
                .enCaisse(b.getEnCaisse())
                .build();
    }
    public static Banque toEntity(BanqueDto bDto){
        if (bDto==null)return null;
        Banque b=new Banque();
        b.setId(bDto.getId());
        b.setTotal(bDto.getTotal());
        b.setEnCaisse(bDto.getEnCaisse());
        return  b;
    }

    public BanqueDto(Banque b){
        this.id=b.getId();
        this.total=b.getTotal();
        this.enCaisse=b.getEnCaisse();
    }
}
