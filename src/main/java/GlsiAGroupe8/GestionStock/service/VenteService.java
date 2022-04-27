package GlsiAGroupe8.GestionStock.service;

import GlsiAGroupe8.GestionStock.models.Produit;
import GlsiAGroupe8.GestionStock.models.Vente;
import GlsiAGroupe8.GestionStock.repository.ProduitRepository;
import GlsiAGroupe8.GestionStock.repository.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VenteService {

    @Autowired
    private VenteRepository venteRepository;


    public void saveVente(Vente vente)
    {
        venteRepository.save(vente);
    }


    public List<Vente> showAllVente()
    {
        return venteRepository.findAll();
    }

    public Vente selectedVente(int id)
    {
        Optional<Vente> optional = venteRepository.findById(id);
        Vente vente = null;
        if(optional.isPresent())
        {
            vente= optional.get();
        }else
        {
            throw new RuntimeException("id introuvable");
        }
        return  vente;
    }

    public void deleteVente(int id){
        if (selectedVente(id) != null) {
            venteRepository.deleteById(id);
        }
    }
}
