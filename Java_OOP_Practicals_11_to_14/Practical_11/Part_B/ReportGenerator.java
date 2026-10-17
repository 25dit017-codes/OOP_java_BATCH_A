import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class ReportGenerator {
    public static String generate(Path logFolder, Path reportFile) throws IOException {
        long deposits = 0, withdrawals = 0;
        StringBuilder details = new StringBuilder("End of Day Report\n");
        if (Files.exists(logFolder)) {
            try (DirectoryStream<Path> files = Files.newDirectoryStream(logFolder, "*.log")) {
                for (Path file : files) {
                    if (!Files.isRegularFile(file) || Files.size(file) == 0) continue;
                    try (BufferedReader reader = Files.newBufferedReader(file)) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            String[] parts = line.trim().split("\\s+");
                            if (parts.length >= 3) {
                                try {
                                    long amount = Long.parseLong(parts[2]);
                                    if (parts[0].equalsIgnoreCase("DEPOSIT")) deposits += amount;
                                    if (parts[0].equalsIgnoreCase("WITHDRAW")) withdrawals += amount;
                                } catch (NumberFormatException ignored) { }
                            }
                        }
                    }
                    BasicFileAttributes a = Files.readAttributes(file, BasicFileAttributes.class);
                    details.append(file.getFileName()).append(" | size=").append(a.size())
                           .append(" | modified=").append(a.lastModifiedTime()).append("\n");
                }
            }
        }
        details.append("Total deposits: ").append(deposits).append("\n");
        details.append("Total withdrawals: ").append(withdrawals).append("\n");
        details.append("Net change: ").append(deposits - withdrawals).append("\n");
        if (reportFile.getParent() != null) Files.createDirectories(reportFile.getParent());
        Files.writeString(reportFile, details.toString());
        return details.toString();
    }
}
