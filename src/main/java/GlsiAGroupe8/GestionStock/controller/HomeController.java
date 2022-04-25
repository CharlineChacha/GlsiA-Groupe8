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

    @GetMapping ("/")
    public String afficherBonjour()
    {
        return "home";
    }

    @GetMapping ("/category")
    public String Category()
    {
        return "category/formCategory";
    }


    @GetMapping ("/Listcategory")
    public String ListCategory()
    {
        return "category/showCategory";
    }

    @GetMapping("/EditCategory")
    public String EditCategory(){return "category/formEditCategory";}

    @PostMapping("/UpdateCategory")
    public String UpdateCategory(){return "category/showCategory";}

/*Mapping de produit*/

    @GetMapping ("/produit")
    public String createProduit()
    {
        return "produit/formProduit";
    }

    @GetMapping ("/Listproduit")
    public String ListProduit()
    {
        return "produit/showProduit";
    }

    @GetMapping("/EditProduit")
    public String EditProduit(){return "produit/formEditProduit";}

    @PostMapping("/UpdateProduit")
    public String UpdateProduit(){return "produit/showProduit";}


}

