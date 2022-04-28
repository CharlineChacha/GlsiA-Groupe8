package GlsiAGroupe8.GestionStock.controller;


import GlsiAGroupe8.GestionStock.models.Client;
import GlsiAGroupe8.GestionStock.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/show")
    public String show(Model model)
    {
        model.addAttribute("ListClient", clientService.showAllClient());
        return "client/showClient";
    }

    @GetMapping("/form")
    public String formClient()
    {
        return "client/formClient";
    }

    @PostMapping("/save")
    public  String saveClient(Client client)
    {
        clientService.saveClient(client);
        return "redirect:/client/show";
    }

    @GetMapping("/edit/{id}")
    public String editFormCategory(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("ListClient", clientService.selectedClient(id));
        return  "client/formEditClient";
    }

    @PostMapping("/edit")
    public  String updateClient(@ModelAttribute("client") Client client)
    {
        clientService.saveClient(client);
        return "redirect:/client/show";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") int id){
        clientService.deleteClient(id);
        return "redirect:/client/show";
    }


}
