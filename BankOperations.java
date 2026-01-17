import java.util.HashMap;

public class BankOperations {
    HashMap<Long, BankAccount> accounts;

    public BankOperations() {
        accounts = FileHandler.loadData();
    }

    public void createAccount(long accNo, String name, int pin, double balance) {
        if (accounts.containsKey(accNo)) {
            System.out.println("Account already exists!");
            return;
        }
        accounts.put(accNo, new BankAccount(accNo, name, pin, balance));
        FileHandler.saveData(accounts);
        System.out.println("Account created successfully!");
    }

    public BankAccount getAccount(long accNo) {
        return accounts.get(accNo);
    }

    public void save() {
        FileHandler.saveData(accounts);
    }
}
