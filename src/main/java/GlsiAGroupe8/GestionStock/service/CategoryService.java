package GlsiAGroupe8.GestionStock.service;

import GlsiAGroupe8.GestionStock.models.Category;
import GlsiAGroupe8.GestionStock.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    //Enregistrer une Categorie  dans la base
    public void save(Category category)
    {
        categoryRepository.save(category);
    }

    //Afficher les categorie
    public List<Category> showAllCategory()
    {
        return categoryRepository.findAll();
    }

    //selectionner une seul categorie
    public Category selecteOneCategory(int id)
    {
        Optional<Category> optional = categoryRepository.findById(id);
        Category category = null;
        if(optional.isPresent())
        {
            category = optional.get();
        }else
        {
            throw new RuntimeException("id introuvable");
        }
        return  category;
    }

    //supprimer un produit
    public void deleteCategory(int id){
        if (selecteOneCategory(id) != null) {
            categoryRepository.deleteById(id);
        }
    }
}