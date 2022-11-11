package tn.esprit.yassinebs.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.yassinebs.Repository.EquipeRepository;
import tn.esprit.yassinebs.entities.Equipe;

import java.util.List;

@Service
public class IEquipeServiceImp implements IEquipeService {
    @Autowired
    EquipeRepository equipeRepository;


    @Override
    public List<Equipe> retrieveAllEquipes() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe addEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe retrieveEquipe(Integer idEquipe) {
        return equipeRepository.findById(idEquipe).orElse(null);
    }

    @Override
    public void removeEquipe(Integer idEquipe) {
        equipeRepository.deleteById(idEquipe);
    }
}
