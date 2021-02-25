package app.leasa.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Writer {
    
    public static void write(String outputDir, String fileName, Map<Integer, Intersection> graph) {

        //TODO créer le fichier
        List<String> lines = new ArrayList<>();
        lines.add("" + (int) graph.values().stream().filter(intersection -> !intersection.result.isEmpty()).count());
        graph.values().stream().forEach(inter -> {
            lines.add(inter.toString());
        });

        String fileString = lines.stream().reduce("", (a, b) -> a + b);


        Path path = Paths.get(outputDir + "/" + fileName);
        byte[] strToBytes = fileString.getBytes();
        
        try {
            Files.write(path, strToBytes);
        } catch (IOException e) {
            throw new RuntimeException("oups l'output " + fileName, e);
        }
    }
    
    public static String writeAll(Map<String, Map<Integer, Intersection>> objects)
            throws IOException {
        
        final String directory = "output/" + DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss").format(LocalDateTime.now());
        
        Files.createDirectories(Paths.get(directory));
        
        objects.forEach((fileName, object) -> Writer.write(directory, fileName, object));
        
        return directory;
    }
    
    public static void zipProject(String outputDirectory) {
        
        try {
            String sourceFile = ".";
            FileOutputStream fos = null;
            fos = new FileOutputStream(outputDirectory + "/project.zip");
            ZipOutputStream zipOut = new ZipOutputStream(fos);
            File fileToZip = new File(sourceFile);
    
            zipFile(fileToZip, "hashcode2021", zipOut);
            zipOut.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException("oups le zip " + outputDirectory, e);
        }
        
    }
    
    private static void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) throws IOException {
        if (fileName.equals("hashcode2021/build") || fileName.equals("hashcode2021/output") || fileName.equals("hashcode2021/.gradle")) {
            return;
        }
        if (fileToZip.isDirectory()) {
            if (fileName.endsWith("/")) {
                zipOut.putNextEntry(new ZipEntry(fileName));
                zipOut.closeEntry();
            } else {
                zipOut.putNextEntry(new ZipEntry(fileName + "/"));
                zipOut.closeEntry();
            }
            File[] children = fileToZip.listFiles();
            for (File childFile : children) {
                zipFile(childFile, fileName + "/" + childFile.getName(), zipOut);
            }
            return;
        }
        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileName);
        zipOut.putNextEntry(zipEntry);
        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }
        fis.close();
    }
    
}
