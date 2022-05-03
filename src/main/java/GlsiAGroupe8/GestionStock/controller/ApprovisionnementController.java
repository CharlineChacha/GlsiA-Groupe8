package GlsiAGroupe8.GestionStock.controller;

import GlsiAGroupe8.GestionStock.models.Approvisionnement;
import GlsiAGroupe8.GestionStock.models.Produit;
import GlsiAGroupe8.GestionStock.service.ApprovisionnementService;
import GlsiAGroupe8.GestionStock.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/approvisionnement")
public class ApprovisionnementController {

        @Autowired
        private ApprovisionnementService approvisionnementService;
        @Autowired
        private ProduitService produitService;

        @GetMapping("/show")
        public String afficherApprovisionnement(Model model)
        {
            model.addAttribute("listApprovisionnement", approvisionnementService.showAllApprovisionnement());
            return "approvisionnement/showApprovisionnement";
        }

        @GetMapping("/create/{id}")
        public String AfficherFormulaireApp(@PathVariable("id") int id,Model model)
        {

            model.addAttribute("listProduit", produitService.select(id));
            return "approvisionnement/formApprovisionnement";
        }

        @PostMapping("/save")
        public String saveApprovisionnement(Approvisionnement approvisionnement , RedirectAttributes attributes,
                                            @RequestParam("produit") int id)
        {
            approvisionnement.setCreatedAt(LocalDateTime.now());
            Produit produit = produitService.get(id);
            produit.setQteStock(produit.getQteStock() + approvisionnement.getQuantite());
            produitService.saveProduit(produit);
            approvisionnement.setProduit(produit);
            approvisionnementService.saveApprovisionnement(approvisionnement);
            attributes.addAttribute("id", produit.getId());

            approvisionnementService.saveApprovisionnement(approvisionnement);

            return "redirect:/approvisionnement/show";

        }


        @GetMapping("/edit/{id}")
        public String formEditApprovisionnement(@PathVariable("id") int id, Model model)
        {
            model.addAttribute("unApprovisionnement", approvisionnementService.get(id));
            model.addAttribute("listProduit", produitService.showAllProduit());
            return "approvisionnement/formEditApprovisionnement";
        }

        @PostMapping("/edit")
        public String editApprovisionnement(@ModelAttribute("approvisionnement") Approvisionnement approvisionnement){
            approvisionnementService.saveApprovisionnement(approvisionnement);
            return "redirect:/approvisionnement/show";
        }

        @GetMapping("/delete/{id}")
        public String deleteApprovisionnement(@PathVariable("id") int id){
            approvisionnementService.deleteApprovisionnement(id);
            return "redirect:/approvisionnement/show";
        }

    }


