import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

public class StatePersister {
    public static void save(ArrayList<Account> accounts, Path file) throws IOException {
        if (file.getParent() != null) Files.createDirectories(file.getParent());
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(file))) {
            out.writeObject(accounts.toArray(new Account[0]));
        }
    }
    public static Account[] load(Path file) throws IOException, ClassNotFoundException {
        if (!Files.exists(file)) return new Account[0];
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(file))) {
            return (Account[]) in.readObject();
        }
    }
}
