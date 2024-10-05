package tn.esprit.foyer.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idChambre;
    long numeroChambre;
    @Enumerated(EnumType.STRING)
    TypeChambre typeC;
    @ManyToOne
    Bloc bloc;

}
