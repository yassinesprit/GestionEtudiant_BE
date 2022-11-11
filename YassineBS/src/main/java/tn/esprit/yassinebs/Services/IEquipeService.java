package tn.esprit.yassinebs.Services;


import tn.esprit.yassinebs.entities.Equipe;

import java.util.List;

public interface IEquipeService {

    public List<Equipe> retrieveAllEquipes();

    public Equipe addEquipe(Equipe e);

    public Equipe updateEquipe (Equipe e);

    public Equipe retrieveEquipe (Integer idEquipe);

    public void removeEquipe (Integer idEquipe);
}
