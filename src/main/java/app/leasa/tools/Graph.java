package app.leasa.tools;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Graph {
    
    public void show(Map<Integer, Intersection> graph) {
        graph.forEach((i, intersection) -> {
            log.info("Intersection " + i);
            log.info("Departs");
            intersection.ruesDeDepart.forEach(rue -> log.info(rue.name));
            log.info("Arrivees");
            intersection.ruesArrivee.forEach(rue -> log.info(rue.name));
            log.info("");
        });
    }
    
}
