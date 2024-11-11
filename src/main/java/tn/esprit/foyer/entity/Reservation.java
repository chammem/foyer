package tn.esprit.foyer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    String idReservation ;
    Date anneeUniversitaire;
    boolean estValide;
    @ManyToMany
    Set<Etudiant> etudiants;

    public boolean isEstValide() {
        return estValide;
    }

    // Setter si nécessaire
    public void setEstValide(boolean estValide) {
        this.estValide = estValide;
    }
}
