package GlsiAGroupe8.GestionStock.repository;

import GlsiAGroupe8.GestionStock.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Locale;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
