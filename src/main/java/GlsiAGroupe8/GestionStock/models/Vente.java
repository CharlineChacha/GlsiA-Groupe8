package GlsiAGroupe8.GestionStock.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name="Vente")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String codeVente;
    private LocalDate dateVente;

    @ManyToOne()
    @JoinColumn(name = "ClientId", insertable = false ,updatable = false)
    private Client client;
    private int ClientId;

}
