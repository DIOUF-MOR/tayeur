package org.sid.tayeur_app.entities;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.sid.tayeur_app.enums.GenreClient;
import org.sid.tayeur_app.enums.TailleModel;

import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private byte[] image;
    private GenreClient type;
    private String nom;
    @OneToMany(mappedBy = "model",cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private Set<Commande> commandes;
}
