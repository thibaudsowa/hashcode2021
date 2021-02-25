package app.leasa.tools;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Rue {
    
    Intersection intersectionDepart;
    Intersection intersectionArrivee;
    String name;
    int longueur = 1;
    
    
}
