package com.microservice.client.Controller;


import com.microservice.client.Entities.Client;
import com.microservice.client.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepo;

    // Get one client by name
    @GetMapping("/{name}")
    public Client getClient(@PathVariable String name) {
        return clientRepo.findByName(name);
    }

    // Get all clients
    @GetMapping()
    public List<Client> getAllClients() {
        return clientRepo.findAll();
    }

    // Create new client
    @PostMapping()
    public Client createClient(@RequestBody Client newClient) {
        return clientRepo.save(newClient);
    }

    // Update a client
    @PutMapping("/{name}")
    public Client updateClient(@PathVariable String name, @RequestBody Client clientDetails) {
        Client client = clientRepo.findByName(name);

        client.setName(clientDetails.getName());
        client.setEmail(clientDetails.getEmail());
        client.setPhone(clientDetails.getPhone());

        clientRepo.save(client);
        return client;
    }

    // Delete a client
    @DeleteMapping("/{name}")
    public Client deleteClient(@PathVariable String name) {
        Client client = clientRepo.findByName(name);
        clientRepo.delete(client);
        return client;
    }

}
