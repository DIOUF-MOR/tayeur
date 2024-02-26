package org.sid.tayeur_app.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MesureFemme{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @OneToOne(mappedBy = "mesureFemme")
    private Client client;
}
