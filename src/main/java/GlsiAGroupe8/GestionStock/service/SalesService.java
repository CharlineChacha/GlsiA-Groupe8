package GlsiAGroupe8.GestionStock.service;

import GlsiAGroupe8.GestionStock.models.Client;
import GlsiAGroupe8.GestionStock.models.Sales;
import GlsiAGroupe8.GestionStock.repository.ClientRepository;
import GlsiAGroupe8.GestionStock.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {
    @Autowired
    private SalesRepository salesRepository;

    public List<Sales> showAll()
    {
        return salesRepository.findAll();
    }
}
