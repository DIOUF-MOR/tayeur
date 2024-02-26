package org.sid.tayeur_app.listeners;
import org.sid.tayeur_app.entities.Commande;
import org.springframework.context.ApplicationEvent;
public class CommandeAjoutEvent extends ApplicationEvent {
    private final Commande commande;
    public CommandeAjoutEvent(Object source, Commande commande) {
        super(source);
        this.commande = commande;
    }

    public Commande getCommande() {
        return commande;
    }
}

