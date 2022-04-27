package GlsiAGroupe8.GestionStock.service;

import GlsiAGroupe8.GestionStock.models.LigneVente;
import GlsiAGroupe8.GestionStock.repository.LigneVenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LigneVenteService {

    @Autowired
    private LigneVenteRepository ligneVenteRepository;

    //Enregistrer une ligne dans la base
    public void saveLigneVente(LigneVente ligneVente)
    {
     ligneVenteRepository.save(ligneVente);
    }

    //Afficher les Ligne
    public List<LigneVente> showAllLigneVente()
    {
        return ligneVenteRepository.findAll();
    }

    //selectionner un seul ligne
    public LigneVente selectedLigneVente(int id)
    {
        Optional<LigneVente> optional = ligneVenteRepository.findById(id);
        LigneVente ligneVente = null;
        if(optional.isPresent())
        {
            ligneVente = optional.get();
        }else
        {
            throw new RuntimeException("id introuvable");
        }
        return ligneVente;
    }

    //supprimer une ligne
    public void deleteLigneVente(int id){
        if (selectedLigneVente(id) != null) {
            ligneVenteRepository.deleteById(id);
        }
    }
}
