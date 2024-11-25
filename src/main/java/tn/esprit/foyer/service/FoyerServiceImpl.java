package tn.esprit.foyer.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.foyer.entity.Bloc;
import tn.esprit.foyer.entity.Foyer;
import tn.esprit.foyer.entity.Universite;
import tn.esprit.foyer.repository.IFoyerRepo;
import tn.esprit.foyer.repository.IUniversiteRepo;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyerService {
    IFoyerRepo foyerRepo;
    IUniversiteRepo universiteRepo;


    @Override
    public Foyer ajouterFoyer(Foyer foyer) {
        return foyerRepo.save(foyer);
    }

    @Override
    public Foyer modifierFoyer(Foyer foyer) {
        return foyerRepo.save(foyer);
    }

    @Override
    public Foyer modifierFoyerParId(long idFoyer, Foyer nouvellesDonnees) {
        Optional<Foyer> foyerExistant = foyerRepo.findById(idFoyer);

        if (foyerExistant.isPresent()) {
            Foyer foyer = foyerExistant.get();
            foyer.setNomFoyer(nouvellesDonnees.getNomFoyer());
            foyer.setCapaciteFoyer(nouvellesDonnees.getCapaciteFoyer());
            foyer.setUniversite(nouvellesDonnees.getUniversite());
            foyer.setBlocs(nouvellesDonnees.getBlocs());
            return foyerRepo.save(foyer);
        } else {
            throw new EntityNotFoundException("Foyer avec ID " + idFoyer + " non trouvé");
        }
    }
    @Override
    public List<Foyer> afficherTout() {
        return foyerRepo.findAll();
    }

    @Override
    public List<Foyer> chercherParId(long idFoyer) {
        return foyerRepo.findByIdFoyer(idFoyer);
    }

    @Override
    public Boolean supprimerFoyer(Foyer foyer) {
        try {foyerRepo.delete(foyer);
        return true;}
        catch (Exception e)
        { return false;}
    }

    @Override
    public Boolean supprimerParId(long idFoyer) {
         foyerRepo.deleteById(idFoyer);
         return true;
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        //1ere etape:la recherche"chercher les lignes dans les tables"
            Foyer foyer = foyerRepo.findById(idFoyer).orElse(null);
            Universite universite=universiteRepo.findUniversiteByNomUniversite(nomUniversite);
        //2eme etape:affectation parent.setFils(fils):
        universite.setFoyer(foyer);
        //3eme etape
         return universiteRepo.save(universite);
    }

    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite=universiteRepo.findById(idUniversite).orElse(null);
        Foyer foyer = universite.getFoyer();
        if (foyer == null) {
            throw new IllegalStateException("L'université n'est associée à aucun foyer");
        }
        universite.setFoyer(null);

        return universiteRepo.save(universite);
    }

    @Override
    public String ajouterFoyerEtBloc(Foyer foyer) {
        //parent.setfils(fils)
        for(Bloc bloc:foyer.getBlocs())
            bloc.setFoyer(foyer);
        return foyerRepo.save(foyer).toString();
    }


}
