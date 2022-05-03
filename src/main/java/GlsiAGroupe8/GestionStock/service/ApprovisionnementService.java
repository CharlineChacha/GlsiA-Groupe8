package GlsiAGroupe8.GestionStock.service;

import GlsiAGroupe8.GestionStock.models.Approvisionnement;
import GlsiAGroupe8.GestionStock.repository.ApprovisionnementRepository;
import GlsiAGroupe8.GestionStock.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApprovisionnementService {


    @Autowired
    private ApprovisionnementRepository approvisionnementRepository;


    public void saveApprovisionnement(Approvisionnement approvisionnement)
    {
        approvisionnementRepository.save(approvisionnement);
    }


    public List<Approvisionnement> showAllApprovisionnement()
    {
        return approvisionnementRepository.findAll();
    }

    public Approvisionnement get(int id){
        Optional<Approvisionnement> approvisionnement_optional ;
        approvisionnement_optional = approvisionnementRepository.findById(id);

        if(approvisionnement_optional.isPresent()){
            Approvisionnement approvisionnement;
            approvisionnement = approvisionnement_optional.get();
            return approvisionnement;
        }
        throw new RuntimeException("Id introuvable");
    }

    public Approvisionnement select(int id){
        Optional<Approvisionnement> approvisionnement_optional ;
        approvisionnement_optional = approvisionnementRepository.findById(id);

        if(approvisionnement_optional.isPresent()){
            Approvisionnement approvisionnement;
            approvisionnement = approvisionnement_optional.get();
            return approvisionnement;
        }
        throw new RuntimeException("Id introuvable");
    }


    public void deleteApprovisionnement(int id){
        if (get(id) != null) {
            approvisionnementRepository.deleteById(id);
        }
    }


}
