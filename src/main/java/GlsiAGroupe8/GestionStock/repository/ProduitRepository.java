package GlsiAGroupe8.GestionStock.repository;


import GlsiAGroupe8.GestionStock.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Integer > {
    //@Query(value =  "select count(p) Produit p where p.qteStock > 0")
    //long count();
   // @Transactional
 //   @Modifying
    //@Query(value = "update Produit p set p.qteStok = p.qteStok + :quantite where p.id = :id ")
   // void updateProduitAfterApprovisionnement(@Param("id") Integer id, @Param("quantite")Integer quantite);
}
