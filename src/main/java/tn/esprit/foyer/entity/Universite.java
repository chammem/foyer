package tn.esprit.foyer.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idUniversite;
    String nomUniversite;
    String adresse;
    @OneToOne(mappedBy = "universite")
    Foyer foyer;

}
