package tn.esprit.foyer.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
public class Reservation {
    @Id
    String idReservation ;
    Date anneeUniversitaire;
    boolean estValide;
    @OneToMany
    Set<Chambre> chambres;
    @ManyToMany
    Set<Etudiant> etudiants;

}
