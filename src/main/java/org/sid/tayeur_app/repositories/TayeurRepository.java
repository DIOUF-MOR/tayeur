package org.sid.tayeur_app.repositories;

import org.sid.tayeur_app.entities.Tayeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TayeurRepository extends JpaRepository<Tayeur,Long> {
}
