package org.sid.tayeur_app.repositories;
import org.sid.tayeur_app.entities.MesureFemme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesureFemmeRepository extends JpaRepository<MesureFemme,Long> {
}
