package GlsiAGroupe8.GestionStock.controller;


import GlsiAGroupe8.GestionStock.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/commande")
public class CommandeController {

    @Autowired
    private SalesService salesService;


    @GetMapping("/show")
    public String afficherSales(Model model)
    {
        model.addAttribute("sales", salesService.showAll());
        return "commande";
    }

    @GetMapping("/showProduct")
    public String afficherProduct(Model model)
    {
        model.addAttribute("sales", salesService.showAll());
        return "sales/template/product-listing";
    }
}
