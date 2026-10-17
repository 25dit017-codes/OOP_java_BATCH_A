import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FolderReport {
    public static void main(String[] args) throws IOException {
        Path folder = Path.of("logs");
        Files.createDirectories(folder);
        Path report = Path.of("folder-report.txt");
        StringBuilder result = new StringBuilder("Folder Report\n");
        try (var paths = Files.walk(folder)) {
            for (Path p : paths.filter(Files::isRegularFile).toList()) {
                BasicFileAttributes a = Files.readAttributes(p, BasicFileAttributes.class);
                result.append(p.getFileName()).append(" | ").append(a.size()).append(" bytes | ")
                      .append(a.lastModifiedTime()).append("\n");
            }
        }
        Files.writeString(report, result.toString());
        System.out.println(result);
        System.out.println("Report saved to " + report);
    }
}
