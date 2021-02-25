package app.leasa.tools;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Intersection {

    String id;

    List<Rue> ruesDeDepart = new ArrayList();
    List<Rue> ruesArrivee = new ArrayList();
    List<Result> result = new ArrayList<>();
    Integer nbVoiture = 0;

    public Intersection(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        if(result.size()==0){
            return "";
        }
        String s1 = "\n" + id + "\n" + result.size() + "\n" + result.stream().map(Object::toString).reduce((s, s2) -> s + "\n" + s2).orElse("");
        return s1;
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
