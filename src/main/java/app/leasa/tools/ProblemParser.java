package app.leasa.tools;

import java.util.List;

public class ProblemParser {
    
    private final Integer duration;
    private final Integer nbStreet;
    private final Integer bonusPoint;
    private final Integer nbCar;
    private final Integer nbIntersection;
    
    public ProblemParser(List<Integer> premiereLigne) {
        this.duration = premiereLigne.get(0);
        this.nbIntersection = premiereLigne.get(1);
        this.nbStreet = premiereLigne.get(2);
        this.nbCar = premiereLigne.get(3);
        this.bonusPoint = premiereLigne.get(4);
    }
    
    /**
     * resoud le probleme et c'est fini
     * @return
     */
    public List<String> leCerveau() {
        return null;
    }
    
}
