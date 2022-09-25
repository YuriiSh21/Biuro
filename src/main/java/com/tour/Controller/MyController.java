package com.tour.Controller;

import com.tour.entity.Client;
import com.tour.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/")
    public String show(Model model) {

        List<Client> allClients = clientService.getAllClients();
        model.addAttribute("allCli", allClients);

        return "show";
    }

    @RequestMapping("/addNewClient")
    public String addNewClient(Model model) {

        Client client = new Client();
        model.addAttribute("client", client);

        return "client-details";
    }
    @RequestMapping("/saveClient")
    public String saveClient(@ModelAttribute("client") Client client) {

        clientService.saveClient(client);

        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateClient(@RequestParam("cliId") int id, Model model) {

        Client client = clientService.getClient(id);
        model.addAttribute("client", client);

        return "client-details";
    }

    @RequestMapping("/deleteClient")
    public String deleteClient(@RequestParam("cliId") int id) {

        clientService.deleteClient(id);

        return "redirect:/";
    }
}
