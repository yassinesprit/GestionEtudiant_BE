package tn.esprit.yassinebs.Services;

import tn.esprit.yassinebs.entities.Departement;

import java.util.List;

public interface IDepartementService {
    public List<Departement> retrieveAllDepartements();
    public Departement addDepartement (Departement d);
    public Departement updateDepartement (Departement d);
    public Departement retrieveDepartement (Integer idDepart);
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);
}
