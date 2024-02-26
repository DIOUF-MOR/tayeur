package org.sid.tayeur_app.repositories;
import org.sid.tayeur_app.entities.Banque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BanqueRepository extends JpaRepository<Banque,Long> {
}
