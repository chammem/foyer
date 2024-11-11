package tn.esprit.foyer.restController;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.foyer.entity.Etudiant;
import tn.esprit.foyer.entity.Foyer;
import tn.esprit.foyer.service.IEtudiantService;
import tn.esprit.foyer.service.IFoyerService;

import java.util.List;

@RestController
@AllArgsConstructor
public class EtudiantRestController {
    IEtudiantService etudiantService;

    @PostMapping(path = "/etudiants")
    public List<Etudiant> addEtudiants(@RequestBody List<Etudiant> etudiants) {
        return etudiantService.addEtudiants(etudiants);

    }
    @PutMapping("/etudiants")
    public ResponseEntity<Etudiant> updateEtudiant(@RequestBody Etudiant etudiant) {
        Etudiant updatedEtudiant = etudiantService.updateEtudiant(etudiant);
        return ResponseEntity.ok(updatedEtudiant);
    }
    @DeleteMapping("/etudiants/{id}")
    public ResponseEntity<Void> removeEtudiant(@PathVariable("id") long idEtudiant) {
        etudiantService.removeEtudiant(idEtudiant);
        return ResponseEntity.noContent().build();
    }
}
