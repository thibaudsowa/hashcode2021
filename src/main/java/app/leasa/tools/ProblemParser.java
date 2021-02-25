package app.leasa.tools;

import java.util.List;

public class ProblemParser {
    
    private final Integer duration;
    private final Integer nbStreet;
    private final Integer bonusPoint;
    private final Integer nbCar;
    private final Integer nbIntersection;
    private final List<List<String>> otherLine;
    
    public ProblemParser(List<Integer> premiereLigne, List<List<String>> otherLine) {
        this.duration = premiereLigne.get(0);
        this.nbIntersection = premiereLigne.get(1);
        this.nbStreet = premiereLigne.get(2);
        this.nbCar = premiereLigne.get(3);
        this.bonusPoint = premiereLigne.get(4);
        this.otherLine = otherLine;
    }
    
    
    private void separateLigne(){

    }
    
    
    /**
     * resoud le probleme et c'est fini
     * @return
     */
    public List<String> leCerveau() {
        return null;
    }
}
