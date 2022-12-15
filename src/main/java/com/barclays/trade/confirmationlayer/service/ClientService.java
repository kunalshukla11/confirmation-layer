package com.barclays.trade.confirmationlayer.service;

import com.barclays.trade.confirmationlayer.dao.ClientDetailsDao;
import com.barclays.trade.confirmationlayer.entity.ClientDetails;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service to interact with client details
 */
@Service
public class ClientService {

    private final ClientDetailsDao clientDetailsDao;

    public ClientService(ClientDetailsDao clientDetailsDao) {
        this.clientDetailsDao = clientDetailsDao;
    }

    public List<ClientDetails> getAllClients(){
        return clientDetailsDao.findAll();
    }

    public ClientDetails addClient(ClientDetails clientDetails){
        return clientDetailsDao.save(clientDetails);
    }
}
