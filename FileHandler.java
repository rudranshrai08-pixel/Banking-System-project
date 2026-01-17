import java.io.*;
import java.util.HashMap;

public class FileHandler {
    private static final String FILE_NAME = "bank_data.dat";

    public static void saveData(HashMap<Long, BankAccount> accounts) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(accounts);
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    @SuppressWarnings("unchecked")
    public static HashMap<Long, BankAccount> loadData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (HashMap<Long, BankAccount>) in.readObject();
        } catch (Exception e) {
            return new HashMap<>();
        }
    }
}
