import java.io.Serializable;
import java.time.LocalDateTime;

public class Transaction implements Serializable {
    private String type;
    private double amount;
    private LocalDateTime time;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.time = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return time + " | " + type + " | Amount: " + amount;
    }
}
