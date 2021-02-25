package app.leasa.tools;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Intersection {
    int id;
    List<Rue> ruesDeDepart = new ArrayList();
    List<Rue> ruesArrivee = new ArrayList();
    
    List<Result> result = new ArrayList<>();
    
    @Override
    public String toString() {
        return id + "\n" + result.size() + "\n" + result.stream().map(Object::toString).reduce((s, s2) -> s + "\n" + s2).orElse("");
    }
    
    @Data
    public static class Result {
        Rue rue;
        Integer temps = 1;
        
        public Result(Rue rue, Integer temps) {
            this.rue = rue;
            this.temps = temps;
        }
        
        @Override
        public String toString() {
            return rue.getName() + " " + temps;
            
        }
    }
}
