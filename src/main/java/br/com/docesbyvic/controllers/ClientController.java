package br.com.docesbyvic.controllers;

import br.com.docesbyvic.models.Client;
import br.com.docesbyvic.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Tells Spring this class handles HTTP requests
@RequestMapping("/clients") // Base route: http://localhost:8080/clients
public class ClientController {

    @Autowired
    private ClientService clientService; // Injecting the service (business logic layer)

    // GET -> List all clients
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    // GET -> Get client by id
    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    // POST -> Create new client
    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    // PUT -> Update client
    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client client) {
        return clientService.updateClient(id, client);
    }

    // DELETE -> Delete client
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}
