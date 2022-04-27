package GlsiAGroupe8.GestionStock.service;

import GlsiAGroupe8.GestionStock.models.Approvisionnement;
import GlsiAGroupe8.GestionStock.repository.ApprovisionnementRepository;
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

    public Approvisionnement selectedApprovisionnement(int id)
    {
        Optional<Approvisionnement> optional = approvisionnementRepository.findById(id);
        Approvisionnement approvisionnement = null;
        if(optional.isPresent())
        {
            approvisionnement= optional.get();
        }else
        {
            throw new RuntimeException("id introuvable");
        }
        return  approvisionnement;
    }

    public void deleteApprovisionnement(int id){
        if (selectedApprovisionnement(id) != null) {
            approvisionnementRepository.deleteById(id);
        }
    }


}
