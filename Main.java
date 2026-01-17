import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankOperations bank = new BankOperations();

        while (true) {
            System.out.println("\n--- Banking System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Account Number: ");
                long accNo = sc.nextLong();

                sc.nextLine();
                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Set 4-digit PIN: ");
                int pin = sc.nextInt();

                System.out.print("Initial Balance: ");
                double bal = sc.nextDouble();

                bank.createAccount(accNo, name, pin, bal);
            }

            else if (choice == 2) {
                System.out.print("Account Number: ");
                long accNo = sc.nextLong();

                BankAccount acc = bank.getAccount(accNo);
                if (acc == null) {
                    System.out.println("Account not found!");
                    continue;
                }

                System.out.print("Enter PIN: ");
                int pin = sc.nextInt();

                if (!acc.validatePin(pin)) {
                    System.out.println("Wrong PIN!");
                    continue;
                }

                while (true) {
                    System.out.println("\n1.Deposit  2.Withdraw  3.Balance  4.History  5.Logout");
                    int ch = sc.nextInt();

                    if (ch == 1) {
                        System.out.print("Amount: ");
                        acc.deposit(sc.nextDouble());
                        bank.save();
                    }
                    else if (ch == 2) {
                        System.out.print("Amount: ");
                        acc.withdraw(sc.nextDouble());
                        bank.save();
                    }
                    else if (ch == 3) {
                        System.out.println("Balance: " + acc.getBalance());
                    }
                    else if (ch == 4) {
                        acc.showTransactions();
                    }
                    else if (ch == 5) {
                        break;
                    }
                }
            }

            else if (choice == 3) {
                bank.save();
                System.out.println("Thank you!");
                System.exit(0);
            }
        }
    }
}
