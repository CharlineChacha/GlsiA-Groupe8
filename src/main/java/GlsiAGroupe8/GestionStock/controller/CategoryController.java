package GlsiAGroupe8.GestionStock.controller;

import GlsiAGroupe8.GestionStock.models.Category;
import GlsiAGroupe8.GestionStock.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {


        @Autowired
        private CategoryService categoryService;

        @GetMapping("/afficher")
        public String showListCategory(Model model)
        {
            model.addAttribute("ListCategory",categoryService.showAllCategory());
            return "category/showCategory";
        }

        @GetMapping("/formCategory")
        public String formCategory()
        {
            return "category/formCategory";
        }

        @PostMapping("/save")
        public String saveCategory( Category category)
        {
            categoryService.save(category);
            return "redirect:/category/afficher";
        }

        @GetMapping("/edit/{id}")
        public String editFormCategory(@PathVariable("id") int id, Model model)
        {
            model.addAttribute("ListCategory", categoryService.selecteOneCategory(id));
            return  "category/formEditCategory";
        }

        @PostMapping("/edit")
        public  String updateCategory(@ModelAttribute("category") Category category)
        {
            categoryService.save(category);
            return "redirect:/category/afficher";
        }

        @GetMapping("/delete/{id}")
        public String deleteCategory(@PathVariable("id") int id){
            categoryService.deleteCategory(id);
            return "redirect:/category/afficher";
        }



}
