package GlsiAGroupe8.GestionStock.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="categorie")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String designation;
        public String getDesignation() {
            return designation;
        }
        public void setDesignation(String designation) {
            this.designation = designation;
        }

        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }


}
