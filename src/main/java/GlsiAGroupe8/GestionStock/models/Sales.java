package GlsiAGroupe8.GestionStock.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Sales")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Sales {
    @Id
    private int id;
}
