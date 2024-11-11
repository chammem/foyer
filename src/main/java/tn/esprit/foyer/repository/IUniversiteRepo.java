package tn.esprit.foyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.foyer.entity.Universite;

@Repository
public interface IUniversiteRepo extends JpaRepository<Universite, Long> {
    @Query(value = "select * from Universite universite where universite.nomUniversite:=nom1",nativeQuery = true)
    Universite chercherParNomUniversite(@Param("nom1") String nom);

    @Query(value = "select universite from Universite universite where universite.nomUniversite =:nom1")
    Universite chercherParNomUniversiteJPQL(@Param("nom1") String nomUniversite);

    Universite findUniversiteByNomUniversite(String nomUniversite);

}
