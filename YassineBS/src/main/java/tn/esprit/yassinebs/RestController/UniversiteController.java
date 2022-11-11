package tn.esprit.yassinebs.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.yassinebs.Services.IUniversiteService;
import tn.esprit.yassinebs.entities.Universite;

import java.util.List;

@RestController
@RequestMapping("/universite")
public class UniversiteController {

    @Autowired
    IUniversiteService iUniversiteService;

    @GetMapping
    public List<Universite> retrieveAllUniversites() {
        return iUniversiteService.retrieveAllUniversites();
    }

    @PostMapping
    public Universite addUniversite(@RequestBody Universite u) {
        return iUniversiteService.addUniversite(u);
    }

    @PutMapping
    public Universite updateUniversite(@RequestBody Universite u) {
        return iUniversiteService.updateUniversite(u);
    }

    @GetMapping("/{idUniversite}")
    public Universite retrieveUniversite(@PathVariable Integer idUniversite) {
        return iUniversiteService.retrieveUniversite(idUniversite);
    }

    @DeleteMapping("/{idUniversite}")
    public void removeUniversite(@PathVariable Integer idUniversite) {
        iUniversiteService.removeUniversite(idUniversite);
    }

    @PutMapping("/{idUniversite}/{idDepartement}")
    public void assignUniversiteToDepartement(@PathVariable Integer idUniversite,@PathVariable Integer idDepartement) {
        iUniversiteService.assignUniversiteToDepartement(idUniversite,idDepartement);
    }
}
