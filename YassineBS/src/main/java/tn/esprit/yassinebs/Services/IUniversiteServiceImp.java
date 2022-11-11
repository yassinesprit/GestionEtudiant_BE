package tn.esprit.yassinebs.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.yassinebs.Repository.DepartementRepository;
import tn.esprit.yassinebs.Repository.UniversiteRepository;
import tn.esprit.yassinebs.entities.Departement;
import tn.esprit.yassinebs.entities.Universite;


import java.util.List;

@Service
public class IUniversiteServiceImp implements IUniversiteService{

    @Autowired
    UniversiteRepository universiteRepository;
    @Autowired
    DepartementRepository departementRepository;

    @Override
    public List<Universite> retrieveAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public void removeUniversite(Integer idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }

    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
        Universite u = retrieveUniversite(idUniversite);
        Departement d = departementRepository.findById(idDepartement).orElse(null);
        if (u!= null && d!= null ){
        u.getDepartements().add(d);
        departementRepository.save(d);
        }
    }
}
