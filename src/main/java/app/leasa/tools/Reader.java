package app.leasa.tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;

import com.google.common.collect.Lists;

@Slf4j
public class Reader {
    
    public static Object read(String filename) {
        
        final List<String> lines;
        
        try {
            lines = Files.readAllLines(Paths.get("input/" + filename));
        } catch (IOException e) {
            throw new RuntimeException("oups l'input " + filename, e);
        }
    
        final Optional<Object> firstLine = lines.stream().findFirst().map(line -> {
            return Arrays.stream(line.split(" ")).map(Integer::valueOf).collect(Collectors.toList());
        });
    
        lines.stream().skip(1).map(line -> {
            return Lists.newArrayList(line.split(" "));
        });
        new ProblemParser(firstLine.get());
    
        return lines;
    }
    
    public static Map<String, Object> readAll() {
        return Stream.of(
                "a.txt",
                "b.txt",
                "c.txt",
                "d.txt",
                "e.txt",
                "f.txt"
        ).collect(Collectors.toMap(fileName -> fileName, Reader::read));
    }
    
}
