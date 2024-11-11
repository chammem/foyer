package tn.esprit.foyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.foyer.entity.Etudiant;

@Repository
public interface IEtudiantRepo extends JpaRepository<Etudiant, Long> {
}
