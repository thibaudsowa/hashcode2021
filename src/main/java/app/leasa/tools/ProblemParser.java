package app.leasa.tools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProblemParser {
    
    private final Integer duration;
    private final Integer nbStreet;
    private final Integer bonusPoint;
    private final Integer nbCar;
    private final Integer nbIntersection;
    private final List<List<String>> rueLine;
    private final List<List<String>> carLine;
    
    List<Rue> rues;
    Map<Integer, Intersection> intersections = new HashMap();
    
    public ProblemParser(List<Integer> premiereLigne, List<List<String>> otherLine) {
        this.duration = premiereLigne.get(0);
        this.nbIntersection = premiereLigne.get(1);
        this.nbStreet = premiereLigne.get(2);
        this.nbCar = premiereLigne.get(3);
        this.bonusPoint = premiereLigne.get(4);
        this.rueLine = otherLine.subList(0, this.nbIntersection+1);
        this.carLine = otherLine.subList(this.nbIntersection+1, this.nbIntersection + this.nbCar+1);
    }
    
    
    
    /**
     * resoud le probleme et c'est fini
     * @return
     */
    public Map<Integer, Intersection>  leCerveau() {
        parse();
        
        solution();
        return intersections;
    }
    
    private void solution() {
        intersections.forEach((integer, intersection) ->{
            intersection.ruesArrivee.forEach(rue->{
                final Intersection.Result result = new Intersection.Result(rue, 1);
                intersection.result.add(result);
            });
        });
    }
    
    private void parse() {
        for (int i = 0; i < nbIntersection; i++) {
            intersections.put(i, new Intersection(String.valueOf(i)));
        }
        rues = this.rueLine.stream()
                .map(list -> new Rue(intersections.get(Integer.valueOf(list.get(0))), intersections.get(Integer.valueOf(list.get(1))), list.get(2), Integer.valueOf(list.get(3))))
                .collect(Collectors.toList());
        rues.forEach(rue->{
            final Intersection intersectionArrivee = rue.getIntersectionArrivee();
            intersectionArrivee.getRuesArrivee().add(rue);
            final Intersection intersectionDepart = rue.getIntersectionDepart();
            intersectionDepart.getRuesDeDepart().add(rue);
        });
    
    }
    
}
