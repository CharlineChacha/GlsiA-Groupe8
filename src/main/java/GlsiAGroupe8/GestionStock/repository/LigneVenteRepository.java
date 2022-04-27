package GlsiAGroupe8.GestionStock.repository;

import GlsiAGroupe8.GestionStock.models.LigneVente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneVenteRepository extends JpaRepository<LigneVente, Integer> {

}
