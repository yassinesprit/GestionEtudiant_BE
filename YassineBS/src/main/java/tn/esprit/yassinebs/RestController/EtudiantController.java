package tn.esprit.yassinebs.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.yassinebs.Services.IEtudiantService;
import tn.esprit.yassinebs.entities.Contrat;
import tn.esprit.yassinebs.entities.Etudiant;


import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/student")
public class EtudiantController {
    @Autowired//injecte moi un bean qui implemente linterface EtudiantService
    IEtudiantService iEtudiantService;

    @GetMapping("/hello/{classname}")
    public String SayHello(@PathVariable String classname) {
        return "hello " + classname;
    }
    //localhost:8080/student/add

    @GetMapping
    public List<Etudiant> retrieveAllEtudiants() {
        return iEtudiantService.getAllStudents();
    }

    @PostMapping
    public Etudiant addStudent(@RequestBody Etudiant e) {
        return iEtudiantService.addStudent(e);
    }

    @PutMapping
    public Etudiant updateEtudiant(@RequestBody Etudiant e) {
        return iEtudiantService.updateStudent(e);
    }

    @GetMapping("/{id}")
    public Etudiant retrieveEtudiant(@PathVariable("id") Integer idEtudiant) {
        return iEtudiantService.getById(idEtudiant);
    }

    @DeleteMapping("/{idEtudiant}")
    public void removeEtudiant(@PathVariable Integer idEtudiant) {
        iEtudiantService.removeStudent(idEtudiant);
    }

    @PostMapping("/{idDepart}")
    public Etudiant addAndAssignEtudiant(@RequestBody Etudiant e, @PathVariable Integer idDepart) {
        return iEtudiantService.addAndAssignEtudiant(e, idDepart);
    }
    @PutMapping("/{etudiantId}/{departementId}")
    public void assignEtudiantToDepartement(@PathVariable Integer etudiantId,@PathVariable Integer departementId){
        iEtudiantService.assignEtudiantToDepartement(etudiantId,departementId);
    }
    @PostMapping("/add")
    public Contrat affectContratToEtudiant(@RequestBody Contrat ce){
        return iEtudiantService.affectContratToEtudiant(ce);
    }

    @PutMapping("assign/{idContrat}/{idEquipe}")
    public Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant e,@PathVariable Integer idContrat,@PathVariable Integer idEquipe){
        return iEtudiantService.addAndAssignEtudiantToEquipeAndContract(e,idContrat,idEquipe);
    }

    @GetMapping("/dep/{idDepartement}")
    public List<Etudiant> getEtudiantsByDepartement(@PathVariable Integer idDepartement) {
        return iEtudiantService.getEtudiantsByDepartement(idDepartement);
    }

}
