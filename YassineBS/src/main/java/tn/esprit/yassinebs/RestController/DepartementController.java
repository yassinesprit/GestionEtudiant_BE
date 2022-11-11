package tn.esprit.yassinebs.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.yassinebs.Services.IDepartementService;
import tn.esprit.yassinebs.entities.Departement;

import java.util.List;

@RestController
@RequestMapping("/departement")
public class DepartementController {
    @Autowired
    IDepartementService iDepartementService;

    @GetMapping
    public List<Departement> retrieveAllDepartements() {
        return iDepartementService.retrieveAllDepartements();
    }

    @PostMapping
    public Departement addDepartement(@RequestBody Departement d) {
        return iDepartementService.addDepartement(d);
    }

    @PutMapping
    public Departement updateDepartement(@RequestBody Departement d) {
        return iDepartementService.updateDepartement(d);
    }

    @GetMapping("/{idDepart}")
    public Departement retrieveDepartement(@PathVariable Integer idDepart) {
        return iDepartementService.retrieveDepartement(idDepart);
    }

    @GetMapping("/univ/{idUniversite}")
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite){
        return iDepartementService.retrieveDepartementsByUniversite(idUniversite);
    }


}
