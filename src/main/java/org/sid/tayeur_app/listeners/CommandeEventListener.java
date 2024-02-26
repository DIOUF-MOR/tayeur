package org.sid.tayeur_app.listeners;

import org.sid.tayeur_app.entities.Commande;
import org.sid.tayeur_app.services.BanqueService;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CommandeEventListener  extends ApplicationEvent {

    private final BanqueService banqueService;

    public CommandeEventListener(BanqueService banqueService) {
        super(banqueService);
        this.banqueService = banqueService;
    }

    @EventListener
    public void handleCommandeAjoutEvent(CommandeAjoutEvent event) {
        // Récupérer la valeur du prix de la commande
        Commande prixCommande = event.getCommande();

        // Mettre à jour la valeur du montant dans la table "banque"
        banqueService.incrementerMontant(prixCommande);
    }
}
