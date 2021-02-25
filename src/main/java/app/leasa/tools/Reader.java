package app.leasa.tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reader {
    
    public static Object read(String filename) {
        
        final List<String> lines;
        
        try {
            lines = Files.readAllLines(Paths.get("input/" + filename));
        } catch (IOException e) {
            throw new RuntimeException("oups l'input " + filename, e);
        }
        
        lines.stream().findFirst().ifPresent(line -> {
            
            //TODO header
            System.out.println(line);
            
        });
        
        lines.stream().skip(1).forEach(line -> {
            
            //TODO corps
            System.out.println(line);
            
        });
        
        return lines;
    }
    
    public static Map<String, Object> readAll() {
        return Stream.of(
                "a_example",
                "b_little_bit_of_everything.in",
                "c_many_ingredients.in",
                "d_many_pizzas.in",
                "e_many_teams.in"
        ).collect(Collectors.toMap(fileName -> fileName, Reader::read));
    }
    
}
