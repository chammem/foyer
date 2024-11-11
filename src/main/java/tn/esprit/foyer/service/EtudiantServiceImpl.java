package tn.esprit.foyer.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.foyer.entity.Etudiant;
import tn.esprit.foyer.repository.IEtudiantRepo;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService {
     IEtudiantRepo etudiantRepo;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return List.of();
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {
        return etudiantRepo.saveAll(etudiants);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        Optional<Etudiant> etudiantExistant = etudiantRepo.findById(e.getIdEtudiant());

        if (etudiantExistant.isPresent()) {
            Etudiant etudiantToUpdate = etudiantExistant.get();

            etudiantToUpdate.setNomEt(e.getNomEt());
            etudiantToUpdate.setPrenomEt(e.getPrenomEt());
            etudiantToUpdate.setCin(e.getCin());
            etudiantToUpdate.setDateNaissance(e.getDateNaissance());
            etudiantToUpdate.setEcole(e.getEcole());
            etudiantToUpdate.setEcole(e.getEcole());
            etudiantToUpdate.setReservations(e.getReservations());

            return etudiantRepo.save(etudiantToUpdate);
        } else {
            throw new EntityNotFoundException("Étudiant avec ID " + e.getIdEtudiant() + " non trouvé");
        }
    }

    @Override
    public Etudiant retrieveEtudiant(long idEtudiant) {
        return null;
    }

    @Override
    public void removeEtudiant(long idEtudiant) {
        if (etudiantRepo.existsById(idEtudiant)) {
            etudiantRepo.deleteById(idEtudiant);
        } else {
            throw new IllegalStateException("L'étudiant avec l'ID " + idEtudiant + " n'existe pas.");
        }

    }
}
