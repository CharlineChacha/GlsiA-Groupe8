package GlsiAGroupe8.GestionStock.service;

import GlsiAGroupe8.GestionStock.models.Client;
import GlsiAGroupe8.GestionStock.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    public void saveClient(Client client)
    {
        clientRepository.save(client);
    }


    public List<Client> showAllClient()
    {
        return clientRepository.findAll();
    }

    public Client selectedClient(int id)
    {
        Optional<Client> optional = clientRepository.findById(id);
        Client client = null;
        if(optional.isPresent())
        {
            client= optional.get();
        }else
        {
            throw new RuntimeException("id introuvable");
        }
        return  client;
    }

    public void deleteClient(int id){
        if (selectedClient(id) != null) {
            clientRepository.deleteById(id);
        }
    }
}
