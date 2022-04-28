package GlsiAGroupe8.GestionStock.controller;

import GlsiAGroupe8.GestionStock.models.Approvisionnement;
import GlsiAGroupe8.GestionStock.service.ApprovisionnementService;
import GlsiAGroupe8.GestionStock.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        @GetMapping("/create")
        public String AfficherFormulaireApp(Model model)
        {

            model.addAttribute("ListProduit", approvisionnementService.showAllApprovisionnement());
            return "approvisionnement/formApprovisionnement";
        }

        @PostMapping("/save")
        public String save(Approvisionnement approvisionnement)
        {
            approvisionnement.setCreatedAt(LocalDateTime.now());

            approvisionnementService.saveApprovisionnement(approvisionnement);
            return "redirect:/approvisionnement/show";
        }


        @GetMapping("/edit/{id}")
        public String formEditApprovisionnement(@PathVariable("id") int id, Model model)
        {
            model.addAttribute("unApprovisionnement", approvisionnementService.selectedApprovisionnement(id));
            model.addAttribute("ListProduit", produitService.showAllProduit());
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

