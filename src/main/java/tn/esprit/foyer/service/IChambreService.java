package tn.esprit.foyer.service;

import tn.esprit.foyer.entity.Bloc;
import tn.esprit.foyer.entity.Chambre;

import java.util.List;

public interface IChambreService {
    public Bloc affecterChambresABloc(List<Long> numChambre, long
            idBloc) ;
    public long getChambresNonReservees(String nomFoyer);

}
