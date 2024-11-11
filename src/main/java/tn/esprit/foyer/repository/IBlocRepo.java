package tn.esprit.foyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.foyer.entity.Bloc;

import java.util.List;
@Repository
public interface IBlocRepo extends JpaRepository<Bloc, Long> {
    Bloc findBlocByIdBloc(Long IdBloc);
}
