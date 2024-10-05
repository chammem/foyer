package tn.esprit.foyer.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idFoyer;
    String nomFoyer;
    long capaciteFoyer;
    @OneToOne
    Universite universite;
    @OneToMany(mappedBy = "foyer")
    Set<Bloc> blocs;
}
