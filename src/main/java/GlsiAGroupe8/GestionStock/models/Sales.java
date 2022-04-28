package GlsiAGroupe8.GestionStock.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="sales")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @ManyToOne()
    @JoinColumn(name="categoryId", insertable = false, updatable = false)
    private Category category;
    private int categoryId;


    @ManyToOne()
    @JoinColumn(name="produitId", insertable = false, updatable = false)
    private Produit produit;
    private int produitId;

}
