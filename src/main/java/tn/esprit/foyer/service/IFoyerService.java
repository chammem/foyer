package tn.esprit.foyer.service;

import tn.esprit.foyer.entity.Foyer;
import tn.esprit.foyer.entity.Universite;

import java.util.List;

public interface IFoyerService {
    Foyer ajouterFoyer(Foyer foyer);
    Foyer modifierFoyer(Foyer foyer);
    Foyer modifierFoyerParId(long idFoyer, Foyer nouvellesDonnees);
    List<Foyer> afficherTout();
    List<Foyer> chercherParId(long idFoyer);
    Boolean supprimerFoyer(Foyer foyer);
    Boolean supprimerParId(long idFoyer);
    Universite affecterFoyerAUniversite (long idFoyer, String
            nomUniversite) ;
    Universite desaffecterFoyerAUniversite (long idUniversite) ;

}
