package app.leasa.tools;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Rue {

    public int nbVoiture;
    Intersection intersectionDepart;
    Intersection intersectionArrivee;
    String name;
    int longueur = 1;

    public Rue( Intersection intersectionDepart, Intersection intersectionArrivee, String name, int longueur) {
        this.nbVoiture = 0;
        this.intersectionDepart = intersectionDepart;
        this.intersectionArrivee = intersectionArrivee;
        this.name = name;
        this.longueur = longueur;
    }
}
