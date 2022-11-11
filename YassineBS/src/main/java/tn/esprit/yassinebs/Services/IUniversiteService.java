package tn.esprit.yassinebs.Services;


import tn.esprit.yassinebs.entities.Universite;

import java.util.List;

public interface IUniversiteService {

    public List<Universite> retrieveAllUniversites();
    public Universite addUniversite (Universite u);
    public Universite updateUniversite (Universite u);
    public Universite retrieveUniversite (Integer idUniversite);
    public void removeUniversite (Integer idUniversite);
    public void assignUniversiteToDepartement(Integer idUniversite, Integer
            idDepartement);
}
