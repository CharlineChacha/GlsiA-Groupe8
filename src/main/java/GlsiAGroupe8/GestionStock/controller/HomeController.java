package GlsiAGroupe8.GestionStock.controller;

import GlsiAGroupe8.GestionStock.models.Category;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan({"GlsiAGroupe8.GestionStock.controller"})
@Controller
public class HomeController {

    @GetMapping("/")
    public String afficherBonjour() {
        return "home";
    }

}