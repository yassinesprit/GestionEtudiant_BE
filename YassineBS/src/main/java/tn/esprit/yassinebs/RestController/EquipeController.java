package tn.esprit.yassinebs.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.yassinebs.Services.IEquipeService;
import tn.esprit.yassinebs.entities.Equipe;

import java.util.List;

@RestController
@RequestMapping("/equipe")
public class EquipeController {

    @Autowired
    IEquipeService iEquipeService;

    @GetMapping
    public List<Equipe> retrieveAllEquipes() {
        return iEquipeService.retrieveAllEquipes();
    }

    @PostMapping
    public Equipe addEquipe(@RequestBody Equipe e) {
        return iEquipeService.addEquipe(e);
    }

    @PutMapping
    public Equipe updateEquipe(@RequestBody Equipe e) {
        return iEquipeService.updateEquipe(e);
    }

    @GetMapping("/{idEquipe}")
    public Equipe retrieveEquipe(@PathVariable Integer idEquipe) {
        return iEquipeService.retrieveEquipe(idEquipe);
    }

    @DeleteMapping("/{idEquipe}")
    public void removeEquipe(@PathVariable Integer idEquipe) {
        iEquipeService.removeEquipe(idEquipe);
    }
}
