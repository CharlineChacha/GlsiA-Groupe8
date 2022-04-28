package GlsiAGroupe8.GestionStock.controller;


import GlsiAGroupe8.GestionStock.models.Client;
import GlsiAGroupe8.GestionStock.models.Vente;
import GlsiAGroupe8.GestionStock.service.ClientService;
import GlsiAGroupe8.GestionStock.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/vente")
public class VenteController {

    @Autowired
    private VenteService venteService;
    @Autowired
    private ClientService clientService;

    @GetMapping("/show")
    public String afficherVente(Model model)
    {
        model.addAttribute("listVente", venteService.showAllVente());
        return "vente/showVente";
    }

    @GetMapping("/create")
    public String AfficherFormulaireVente(Model model)
    {


        model.addAttribute("ListClient", clientService.showAllClient());
        return "vente/formVente";
    }

    @PostMapping("/save")
    public String save( Vente vente, Model model)
    {
        vente.setCreatedAt(LocalDateTime.now());
        venteService.saveVente(vente);
        return "redirect:/vente/show";
    }


    @GetMapping("/edit/{id}")
    public String formEditVente(@PathVariable("id") int id,Vente vente, Model model)
    {
        vente.setCreatedAt(LocalDateTime.now());
        model.addAttribute("unProduit", venteService.selectedVente(id));
        model.addAttribute("ListClient", clientService.showAllClient());
        return "vente/formEditVente";
    }

    @PostMapping("/edit/{id}")
    public String editVente(@ModelAttribute("vente") Vente vente){
        venteService.saveVente(vente);
        return "redirect:/vente/show";
    }

    @GetMapping("/delete/{id}")
    public String deleteVente(@PathVariable("id") int id){
        venteService.deleteVente(id);
        return "redirect:/vente/show";
    }
}
