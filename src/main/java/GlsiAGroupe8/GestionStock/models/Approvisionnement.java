package GlsiAGroupe8.GestionStock.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="Approvisionnement")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Approvisionnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantite;
    private LocalDate dateStock;
    private Enum type;

    @ManyToOne()
    @JoinColumn(name = "ProduitId", insertable = false ,updatable = false)
    private Produit produit;
    private int ProduitId;



}
