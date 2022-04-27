package GlsiAGroupe8.GestionStock.repository;

import GlsiAGroupe8.GestionStock.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
