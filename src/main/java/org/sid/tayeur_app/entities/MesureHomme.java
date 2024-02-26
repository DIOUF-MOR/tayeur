package org.sid.tayeur_app.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MesureHomme{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @OneToOne(mappedBy = "mesureHomme")
    private Client client;

}
