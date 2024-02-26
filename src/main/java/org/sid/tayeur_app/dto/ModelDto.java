package org.sid.tayeur_app.dto;
import lombok.*;
import org.sid.tayeur_app.dto.response.ModelResponse;
import org.sid.tayeur_app.entities.MesureFemme;
import org.sid.tayeur_app.entities.Model;
import org.sid.tayeur_app.enums.GenreClient;
import org.sid.tayeur_app.enums.TailleModel;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ModelDto {
    private Long id;
    private byte[] image;
    private GenreClient type;
    private String nom;
    private Set<CommandeDto> commandeDtos;
    public static ModelDto fromEntity(Model model){
        if(model==null)return null;
        return ModelDto.builder()
                .id(model.getId())
                .type(model.getType())
                .nom(model.getNom())
                .image(model.getImage())
                .build();
    }
    public static ModelResponse fromEntityResponse(Model m){
        if(m==null)return null;
        return ModelResponse.builder()
                .id(m.getId())
                .type(m.getType())
                .nom(m.getNom())
                .image(m.getImage())
                .commandeDtos(CommandeDto.fromEntity(m.getCommandes()))
                .build();
    }
    public static Set<ModelDto> fromEntity(Set<Model> dtos){
        if(dtos== null ) return Collections.emptySet();

        return dtos.stream().map(ModelDto::fromEntity).collect(Collectors.toSet());


    }
    public static Model toEntity(ModelDto mdto){
        if (mdto==null)return null;
        Model m=new Model();
        m.setId(mdto.getId());
        m.setType(mdto.getType());
        m.setNom(mdto.getNom());
        m.setImage(mdto.getImage());
        if (mdto.getCommandeDtos()!=null){
            m.setCommandes(mdto.getCommandeDtos().stream().map(CommandeDto::toEntity).collect(Collectors.toSet()));
        }
        return m;
    }
    public ModelDto(Model m){
        this.id= m.getId();
        this.nom=m.getNom();
        this.image=m.getImage();
    }

}
