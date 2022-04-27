package GlsiAGroupe8.GestionStock.controller;


import GlsiAGroupe8.GestionStock.models.Category;
import GlsiAGroupe8.GestionStock.models.Produit;
import GlsiAGroupe8.GestionStock.service.CategoryService;
import GlsiAGroupe8.GestionStock.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/produit")
public class ProduitController {
    @Autowired
    private ProduitService produitService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/show")
    public String afficherProduit(Model model)
    {
        model.addAttribute("listProduit", produitService.showAllProduit());
        return "produit/showProduit";
    }

    @GetMapping("/create")
    public String AfficherFormulaire(Model model)
    {

        model.addAttribute("ListCategory", categoryService.showAllCategory());
        return "produit/formProduit";
    }

    @PostMapping("/save")
    public String save(Produit produit, Model model, @ModelAttribute("designation") Category category)
    {
        produit.setCategory(category);
        produit.setQteStok(0);
        produit.setDateCreation(LocalDate.now());

        produitService.saveProduit(produit);
        return "redirect:/produit/show";
    }


    @GetMapping("/{id}/edit")
    public String formEditProduit(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("unProduit", produitService.selectedProduit(id));
        model.addAttribute("ListCategory", categoryService.showAllCategory());
        return "produit/formEditProduit";
    }

    @PostMapping("/edit")
    public String editProduit(@ModelAttribute("produit") Produit produit){
        produitService.saveProduit(produit);
        return "redirect:/produit/show";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduit(@PathVariable("id") int id){
        produitService.deleteProduit(id);
        return "redirect:/produit/show";
    }

}
