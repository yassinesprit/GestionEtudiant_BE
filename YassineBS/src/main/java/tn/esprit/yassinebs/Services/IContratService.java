package tn.esprit.yassinebs.Services;


import tn.esprit.yassinebs.entities.Contrat;

import java.util.Date;
import java.util.List;

public interface IContratService {

    public List<Contrat> retrieveAllContrats();
    public Contrat addContrat (Contrat ce);
    public Contrat updateContrat (Contrat ce);
    public Contrat retrieveContrat (Integer idContrat);
    public void removeContrat(Integer idContrat);
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);
    public Integer nbContratsValides(Date startDate, Date endDate);
    public Contrat affectContratToEtudiant2 (Contrat ce,String nomE,String prenomE);

}
