package org.sid.tayeur_app.dto;

import lombok.*;
import org.sid.tayeur_app.dto.response.TayeurResponse;
import org.sid.tayeur_app.entities.Client;
import org.sid.tayeur_app.entities.Tayeur;
import org.sid.tayeur_app.enums.GenreClient;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TayeurDto {
    private Long id;
    private String nom;
    private String preNom;
    private Integer nombreCommandes;
    private String telephone;
    private String email;
    private String password;
    private Set<CommandeDto> commandeDtos;

    public static TayeurDto fromEntity(Tayeur t){
        if (t==null) return null;
        return TayeurDto.builder()
                .id(t.getId())
                .nom(t.getNom())
                .preNom(t.getPreNom())
                .nombreCommandes(t.getNombreCommandes())
                .telephone(t.getTelephone())
                .email(t.getEmail())
                .password(t.getPassword())
                .build();
    }

    public static TayeurResponse fromEntityResponse(Tayeur t){
        if(t==null)return null;
        return TayeurResponse.builder()
                .id(t.getId())
                .nom(t.getNom())
                .preNom(t.getPreNom())
                .nombreCommandes(t.getNombreCommandes())
                .telephone(t.getTelephone())
                .email(t.getEmail())
                .password(t.getPassword())
                .commandeDtos(CommandeDto.fromEntity(t.getCommandes()))
                .build();
    }

    public static Tayeur toEntity(TayeurDto t){
        if(t==null)return null;
         Tayeur ty=new Tayeur();
         ty.setId(t.getId());
         ty.setNom(t.getNom());
         ty.setPreNom(t.getPreNom());
         ty.setNombreCommandes(t.getNombreCommandes());
         ty.setTelephone(t.getTelephone());
         ty.setEmail(t.getEmail());
         ty.setPassword(t.getPassword());
         if(t.commandeDtos!=null){
             ty.setCommandes(t.commandeDtos.stream().map(CommandeDto::toEntity).collect(Collectors.toSet()));
         }
         return ty;
    }
    public TayeurDto(Tayeur t){
        this.id=t.getId();
        this.nom=t.getNom();
        this.preNom=t.getPreNom();
        this.nombreCommandes=t.getNombreCommandes();
        this.telephone=t.getTelephone();
        this.email=t.getEmail();
        this.password=t.getPassword();
        this.commandeDtos=t.getCommandes().stream().map(CommandeDto::fromEntity).collect(Collectors.toSet());
    }
}
