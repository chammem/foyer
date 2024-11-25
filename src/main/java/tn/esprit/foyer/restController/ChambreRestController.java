package tn.esprit.foyer.restController;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.foyer.entity.Chambre;
import tn.esprit.foyer.entity.Foyer;
import tn.esprit.foyer.service.IChambreService;

import java.util.List;

@RestController
@AllArgsConstructor
public class ChambreRestController {
    @Autowired
    private IChambreService chambreService;

    @GetMapping("/{nomFoyer}")
    public ResponseEntity<Long> getChambresNonReservees(@PathVariable String nomFoyer) {
        long nombreChambresNonReservees = chambreService.getChambresNonReservees(nomFoyer);

        // Retourner le nombre de chambres non réservées
        return ResponseEntity.ok(nombreChambresNonReservees);
    }
    @PostMapping(path = "/chambrebloc")
    String ajouterChambreEtBloc(@RequestBody Chambre chambre){
        return chambreService.ajouterChambreEtBloc(chambre).toString();
}
}
