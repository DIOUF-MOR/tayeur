package org.sid.tayeur_app.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tayeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String preNom;
    private Integer nombreCommandes;
    private String telephone;
    private String email;
    private String password;
    @OneToMany(mappedBy = "tayeur",cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private Set<Commande> commandes;
}
