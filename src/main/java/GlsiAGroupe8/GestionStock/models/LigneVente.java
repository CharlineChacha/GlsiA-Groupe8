package GlsiAGroupe8.GestionStock.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name="LigneVente")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class LigneVente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int qteligne;
    private double prixUnitaire;

    @ManyToOne()
    @JoinColumn(name = "ProduitId", insertable = false ,updatable = false)
    private Produit produit;
    private int ProduitId;

    @ManyToOne()
    @JoinColumn(name = "VenteId", insertable = false ,updatable = false)
    private  Vente Vente;
    private int VenteId;



}
