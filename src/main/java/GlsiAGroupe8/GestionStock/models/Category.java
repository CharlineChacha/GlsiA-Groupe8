package GlsiAGroupe8.GestionStock.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="Category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String designation;





}
