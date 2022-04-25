package GlsiAGroupe8.GestionStock.repository;


import GlsiAGroupe8.GestionStock.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Integer > {
}