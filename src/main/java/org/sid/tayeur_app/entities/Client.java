package org.sid.tayeur_app.entities;
import jakarta.persistence.*;
import lombok.*;
import org.sid.tayeur_app.enums.GenreClient;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomComplet;
    private String telephone;
    @Column(name = "type")
    private GenreClient type;
    @OneToMany(mappedBy = "client",cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private Set<Commande> commandes;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "clent_mesure_homme",
            joinColumns =
                    { @JoinColumn(name = "client_id", referencedColumnName = "id") },
            inverseJoinColumns =
                    { @JoinColumn(name = "mesure_homme_id", referencedColumnName = "id") })
    private MesureHomme mesureHomme;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "clent_mesure_femme",
            joinColumns =
                    { @JoinColumn(name = "client_id", referencedColumnName = "id") },
            inverseJoinColumns =
                    { @JoinColumn(name = "mesure_femme_id", referencedColumnName = "id") })
    private MesureFemme mesureFemme;
}
