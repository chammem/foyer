package tn.esprit.foyer.restController;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.foyer.entity.Foyer;
import tn.esprit.foyer.entity.Universite;
import tn.esprit.foyer.service.IFoyerService;

import java.nio.file.Path;
import java.util.List;

@RestController
@AllArgsConstructor
//@RequestMapping("/foyer-rest")
public class FoyerRestController {
    IFoyerService foyerService;
    @PostMapping(path = "/foyer")
    Foyer ajouterFoyer(@RequestBody Foyer foyer){
        return foyerService.ajouterFoyer(foyer);
    }

    @PostMapping(path = "/foyerbloc")
    String ajouterFoyerEtBloc(@RequestBody Foyer foyer){
        return foyerService.ajouterFoyerEtBloc(foyer);
    }

    @PutMapping(path = "/modifier")
    Foyer modifierFoyer(@RequestBody Foyer foyer){
        return foyerService.modifierFoyer(foyer);
    }
    @PutMapping(path = "/modifier/{id}")
    Foyer modifierFoyer(@PathVariable int id, @RequestBody Foyer nouvellesDonnees){
        return foyerService.modifierFoyerParId(id, nouvellesDonnees);
    }
    @GetMapping("/foyers")
    public List<Foyer> afficherTout() {
        return foyerService.afficherTout();
    }

    @GetMapping("/chercher/{id}")
    public List<Foyer> chercherFoyerParId(@PathVariable long id) {
        return foyerService.chercherParId(id);
    }
    @DeleteMapping("/delete")
    Boolean supprimerFoyer(@RequestBody Foyer foyer){
        return foyerService.supprimerFoyer(foyer);
    }
    @DeleteMapping("/supprimer/{id}")
    public Boolean supprimerFoyer(@PathVariable long id) {
        return foyerService.supprimerParId(id);
    }
    @PutMapping(path = "/affectation/{id}/{nomUniversite}")
    Universite affecterFoyerAUniversite(@PathVariable("id") long idFoyer, @PathVariable("nomUniversite") String nomUniversite)
    {
       return foyerService.affecterFoyerAUniversite(idFoyer, nomUniversite);
    }

    @PutMapping(path = "/desaffectation/{id}")
    Universite desaffecterFoyerAUniversite(@PathVariable("id") long idUniversite)
    {
        return foyerService.desaffecterFoyerAUniversite(idUniversite);
    }

}
