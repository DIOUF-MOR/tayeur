package org.sid.tayeur_app.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.sid.tayeur_app.dto.BanqueDto;
import org.sid.tayeur_app.dto.response.BanqueResponse;
import org.sid.tayeur_app.entities.Banque;
import org.sid.tayeur_app.entities.Commande;
import org.sid.tayeur_app.repositories.BanqueRepository;
import org.sid.tayeur_app.services.interfaces.BanqueInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BanqueService implements BanqueInterface {
    private final BanqueRepository banqueRepository;
    @Override
    public BanqueResponse save(BanqueDto bDto){
        Banque banque=BanqueDto.toEntity(bDto);
        return BanqueDto.fronEntityResponse(banqueRepository.save(banque));
    }

    @Override
    public Optional<BanqueResponse> findById(Long id){
        return banqueRepository.findById(id).map(BanqueDto::fronEntityResponse);
    }

    @Transactional
    public void incrementerMontant(Commande commande) {
        // Récupérer l'entité "banque" depuis la base de données
        Banque banque = banqueRepository.findById(1L).orElseThrow(() -> new RuntimeException("Banque non trouvée"));
        banque.setTotal(banque.getTotal()+commande.getPrix());
        banque.setEnCaisse(banque.getEnCaisse()+commande.getMontantVersse());
        // Mettre à jour le montant

        // Sauvegarder la mise à jour dans la base de données
        BanqueDto.fronEntityResponse(banqueRepository.save(banque));
    }
}
