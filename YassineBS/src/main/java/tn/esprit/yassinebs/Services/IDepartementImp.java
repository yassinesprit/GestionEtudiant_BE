package tn.esprit.yassinebs.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.yassinebs.Repository.DepartementRepository;
import tn.esprit.yassinebs.entities.Departement;
import tn.esprit.yassinebs.entities.Universite;


import java.util.List;

@Service
public class IDepartementImp implements IDepartementService{

    @Autowired
    DepartementRepository departementRepository;
    @Autowired
    IUniversiteService iUniversiteService;

    @Override
    public List<Departement> retrieveAllDepartements() {
        return departementRepository.findAll();
    }

    @Override
    public Departement addDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement updateDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement retrieveDepartement(Integer idDepart) {
        return departementRepository.findById(idDepart).orElse(null);
    }

    @Override
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
        return iUniversiteService.retrieveUniversite(idUniversite).getDepartements();
    }


}
