package com.barclays.trade.confirmationlayer.controller;

import com.barclays.trade.confirmationlayer.entity.ClientDetails;
import com.barclays.trade.confirmationlayer.service.ClientService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller class to interact with {@link com.barclays.trade.confirmationlayer.entity.ClientDetails}
 */
@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/getAll")
    public List<ClientDetails> getAllClients(){
        return clientService.getAllClients();
    }

    @PostMapping("/add")
    public ClientDetails addClient(ClientDetails clientDetails){
        return clientService.addClient(clientDetails);
    }
}
