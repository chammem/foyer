package tn.esprit.foyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.foyer.entity.Chambre;
import tn.esprit.foyer.entity.Universite;

import java.util.Date;
import java.util.List;

public interface IChambreRepo extends JpaRepository<Chambre, Long> {
    List<Chambre> findByNumeroChambre(long num);

    List<Chambre> findByBloc_Foyer_NomFoyer(String nomFoyer);
   // Chambre findByBloc_Foyer_Universite_Nom(String nomUniversite);

}
