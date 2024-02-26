package org.sid.tayeur_app.dto.response;

import lombok.*;
import org.sid.tayeur_app.dto.ClientDto;
import org.sid.tayeur_app.dto.CommandeDto;
import org.sid.tayeur_app.dto.MesureFemmeDto;
import org.sid.tayeur_app.dto.MesureHommeDto;
import org.sid.tayeur_app.entities.Model;
import org.sid.tayeur_app.enums.GenreClient;
import org.sid.tayeur_app.enums.TailleModel;

import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ModelResponse {
    private Long id;
    private byte[] image;
    private GenreClient type;
    private String nom;
    private Set<CommandeDto> commandeDtos;

public ModelResponse(Model m){
    this.id=m.getId();
    this.image=m.getImage();
    this.type=m.getType();
    this.nom=m.getNom();
}
}
