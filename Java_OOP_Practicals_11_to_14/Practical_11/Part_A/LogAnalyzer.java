import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class LogAnalyzer {
    public static void main(String[] args) throws IOException {
        Path folder = Path.of("logs");
        Files.createDirectories(folder);
        Files.writeString(folder.resolve("app1.txt"), "INFO started\nERROR failed\nINFO closed\n");
        Files.writeString(folder.resolve("app2.txt"), "INFO loaded\nERROR timeout\n");
        String keyword = "ERROR";
        int totalLines = 0, matches = 0;
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(folder, "*.txt")) {
            for (Path file : stream) {
                List<String> lines = Files.readAllLines(file);
                totalLines += lines.size();
                for (String line : lines) if (line.contains(keyword)) matches++;
                BasicFileAttributes a = Files.readAttributes(file, BasicFileAttributes.class);
                System.out.println(file.getFileName() + " size: " + a.size() + " bytes");
            }
        }
        System.out.println("Total lines: " + totalLines);
        System.out.println("Lines containing " + keyword + ": " + matches);
    }
}
