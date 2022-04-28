package GlsiAGroupe8.GestionStock.controller;

import GlsiAGroupe8.GestionStock.models.LigneVente;
import GlsiAGroupe8.GestionStock.service.LigneVenteService;
import GlsiAGroupe8.GestionStock.service.ProduitService;
import GlsiAGroupe8.GestionStock.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/ligneVente")
public class LigneVenteController {
    @Autowired
    private LigneVenteService ligneVenteService;
    @Autowired
    private ProduitService produitService;
    @Autowired
    private VenteService venteService;

    @GetMapping("/show")
    public String afficherLigneVente(Model model)
    {
        model.addAttribute("listVente", venteService.showAllVente());
        model.addAttribute("listProduit", produitService.showAllProduit());
        return "LigneVente/showLigneVente";
    }

    @GetMapping("/create")
    public String AfficherFormulaireLigne(Model model)
    {

        model.addAttribute("ListLigneVente", ligneVenteService.showAllLigneVente());
        return "ligneVente/formLigneVente";
    }

    @PostMapping("/save")
    public String save(LigneVente ligneVente)
    {

        ligneVenteService.saveLigneVente(ligneVente);
        return "redirect:/ligneVente/show";
    }


    @GetMapping("/edit/{id}")
    public String formEditLigneVente(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("uneLigneVente", ligneVenteService.selectedLigneVente(id));
        model.addAttribute("ListProduit", produitService.showAllProduit());
        model.addAttribute("ListVente", venteService.showAllVente());
        return "ligneVente/formEditLigneVente";
    }

    @PostMapping("/edit")
    public String editLigneVente(@ModelAttribute("ligneVente") LigneVente ligneVente){
        ligneVenteService.saveLigneVente(ligneVente);
        return "redirect:/ligneVente/show";
    }

    @GetMapping("/delete/{id}")
    public String deleteLigneVente(@PathVariable("id") int id){
        ligneVenteService.deleteLigneVente(id);
        return "redirect:/ligneVente/show";
    }

}


