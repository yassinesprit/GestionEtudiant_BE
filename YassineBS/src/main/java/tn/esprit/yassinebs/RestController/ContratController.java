package tn.esprit.yassinebs.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.yassinebs.Services.IContratService;
import tn.esprit.yassinebs.entities.Contrat;


import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/contrat")
public class ContratController {
    @Autowired
    IContratService iContratService;
    @GetMapping
    public List<Contrat> retrieveAllContrats() {
        return iContratService.retrieveAllContrats();
    }

    @PostMapping
    public Contrat addStudent(@RequestBody Contrat ce) {
        return iContratService.addContrat(ce);
    }

    @PutMapping
    public Contrat updateContrat(@RequestBody Contrat ce) {
        return iContratService.updateContrat(ce);
    }

    @GetMapping("/{idContrat}")
    public Contrat retrieveContrat(@PathVariable Integer idContrat) {
        return iContratService.retrieveContrat(idContrat);
    }

    @DeleteMapping("/{idContrat}")
    public void removeContrat(@PathVariable Integer idContrat) {
        iContratService.removeContrat(idContrat);
    }

    @GetMapping("/chiffre/{startDate}/{endDate}")
    public float getChiffreAffaireEntreDeuxDate(@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate, @PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate) {
        return iContratService.getChiffreAffaireEntreDeuxDate(startDate,endDate);
    }
    @GetMapping("/nb/{startDate}/{endDate}")
    public Integer nbContratsValides(@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate){
        return iContratService.nbContratsValides(startDate,endDate);
    }
    @PostMapping("/{nomE}/{prenomE}")
    public Contrat affectContratToEtudiant2(@RequestBody Contrat ce,@PathVariable String nomE,@PathVariable String prenomE) {
        return iContratService.affectContratToEtudiant2(ce,nomE,prenomE);
    }
}
