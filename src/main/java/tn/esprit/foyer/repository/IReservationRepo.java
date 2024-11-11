package tn.esprit.foyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.foyer.entity.Reservation;

@Repository
public interface IReservationRepo extends JpaRepository<Reservation, Long> {
    boolean existsByEstValideIsFalse();
}
