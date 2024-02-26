package org.sid.tayeur_app.dto.response;

import lombok.*;
import org.sid.tayeur_app.entities.Banque;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BanqueResponse {
    private Long id;
    private double enCaisse;
    private double total;
    public BanqueResponse(Banque b){
        this.id=b.getId();
        this.total=b.getTotal();
        this.enCaisse=b.getEnCaisse();
    }
}
