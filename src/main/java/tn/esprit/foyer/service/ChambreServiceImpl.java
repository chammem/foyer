package tn.esprit.foyer.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.foyer.entity.Bloc;
import tn.esprit.foyer.entity.Chambre;
import tn.esprit.foyer.entity.Reservation;
import tn.esprit.foyer.repository.IChambreRepo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ChambreServiceImpl implements IChambreService{
    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        return null;
    }

    @Autowired
    private IChambreRepo chambreRepository;

    public long getChambresNonReservees(String nomFoyer) {
        List<Chambre> chambres = chambreRepository.findByBloc_Foyer_NomFoyer(nomFoyer);

        long nb = 0;
        for (Chambre chambre : chambres) {
            // Vérifier si la chambre appartient au foyer spécifié
            if (chambre.getBloc().getFoyer().getNomFoyer().equals(nomFoyer)) {
                // Vérifier les réservations pour cette chambre
                for (Reservation reservation : chambre.getReservations()) {
                    // Vérifier si la réservation n'est pas valide
                    if (!reservation.isEstValide()) {
                        nb++;
                        break;
                    }
                }
            }
        }

        return nb;

    }
    /*public long getChambresNonReservees(String nomFoyer) {
        List<Chambre> chambres = chambreRepository.findByBloc_Foyer_NomFoyer(nomFoyer);

        // Compter les chambres qui ont des réservations non valides (validité = false)
        return chambres.stream()
                .filter(chambre -> chambre.getReservations().stream()
                        .anyMatch(reservation -> !reservation.isEstValide()))  // Si une réservation est invalide
                .count();
    }*/

    }
