package tn.esprit.foyer.restController;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.foyer.entity.Chambre;
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
}
