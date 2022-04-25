package GlsiAGroupe8.GestionStock.controller;


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
        return "produit/showProduct";
    }

    @GetMapping("/create")
    public String AfficherFormulaire(Model model)
    {

        model.addAttribute("ListCategorie", categoryService.showAllCategory());
        return "produit/formProduit";
    }

    @PostMapping("/save")
    public String save(Produit produit)
    {
        produit.setQteStok(0);
        produit.setDateCreation(LocalDate.now());

        produitService.saveProduit(produit);
        return "redirect:/produit/show";
    }


    @GetMapping("/edit/{id}")
    public String formEditProduit(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("unProduit", produitService.selectedProduit(id));
        model.addAttribute("ListCategorie", categoryService.showAllCategory());
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
