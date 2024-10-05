package tn.esprit.foyer.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idBloc;
    String nomBloc;
    long capaciteBloc;
    @ManyToOne
    Foyer foyer;
    @OneToMany(mappedBy = "bloc")
    Set<Chambre> chambres;
}
