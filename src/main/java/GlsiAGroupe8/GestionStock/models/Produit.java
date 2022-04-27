package GlsiAGroupe8.GestionStock.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "produits")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String libelle;
    private int qteStok;
    private int qteSeuil;
    private double prix;
    private LocalDate dateCreation;

    @ManyToOne()
    @JoinColumn(name = "categoryId", insertable = false ,updatable = false)
    private Category Category;
    private int categoryId;

}

