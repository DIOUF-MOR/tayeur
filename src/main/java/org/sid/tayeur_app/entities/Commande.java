package org.sid.tayeur_app.entities;

import jakarta.persistence.*;
import lombok.*;
import org.sid.tayeur_app.enums.EtatCommande;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Commande{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateCreation;
    private LocalDate delais;
    @Column(name = "etat", length = 50)
    private EtatCommande etat;
    private double prix;
    private double montantVersse;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn( name="tayeur_id" , referencedColumnName = "id")
    private Tayeur tayeur;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn( name="model_id" , referencedColumnName = "id")
    private Model model;
}
