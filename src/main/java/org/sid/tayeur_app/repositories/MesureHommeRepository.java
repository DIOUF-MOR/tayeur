package org.sid.tayeur_app.repositories;
import org.sid.tayeur_app.entities.MesureHomme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesureHommeRepository extends JpaRepository<MesureHomme,Long> {
}
