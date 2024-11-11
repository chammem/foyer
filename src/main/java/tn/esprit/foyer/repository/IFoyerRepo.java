package tn.esprit.foyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.foyer.entity.Foyer;

import java.util.List;

@Repository
public interface IFoyerRepo extends JpaRepository<Foyer,Long> {

    List<Foyer> findByIdFoyer(long idUniversite);
}
