package GlsiAGroupe8.GestionStock.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name="vente")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String codeVente;
    private LocalDateTime createdAt = LocalDateTime.now();

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "ClientId", nullable = false, insertable = false ,updatable = false)
    private Client client;
    private int ClientId;



}
