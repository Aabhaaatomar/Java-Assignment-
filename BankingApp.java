import java.util.Scanner;

class Account {
    int accountNumber;
    String accountHolderName, email, phoneNumber;
    double balance;

    Account(int accountNumber, String name, double balance, String email, String phone) {
        this.accountNumber = accountNumber;
        this.accountHolderName = name;
        this.balance = balance;
        this.email = email;
        this.phoneNumber = phone;
    }

    void deposit(double amount) {
        if (amount > 0) balance += amount;
        else System.out.println("Invalid amount!");
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) balance -= amount;
        else System.out.println("Insufficient balance or invalid amount!");
    }

    void displayAccountDetails() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phoneNumber);
    }

    void updateContact(String email, String phone) {
        this.email = email;
        this.phoneNumber = phone;
    }
}

public class BankingApp {
    static Scanner sc = new Scanner(System.in);
    static Account[] accounts = new Account[50];
    static int count = 0;

    static Account find(int accNo) {
        for (int i = 0; i < count; i++) 
            if (accounts[i].accountNumber == accNo) return accounts[i];
        return null;
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n1.Create Account\n2.Deposit\n3.Withdraw\n4.View Details\n5.Update Contact\n6.Exit");
            choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Initial Balance: "); double bal = sc.nextDouble(); sc.nextLine();
                    System.out.print("Email: "); String email = sc.nextLine();
                    System.out.print("Phone: "); String phone = sc.nextLine();
                    accounts[count] = new Account(1000+count+1, name, bal, email, phone);
                    System.out.println("Account Created. No: " + accounts[count].accountNumber);
                    count++; break;

                case 2:
                    System.out.print("Acc No: "); int dAcc = sc.nextInt();
                    System.out.print("Amount: "); double damt = sc.nextDouble();
                    Account d = find(dAcc); if (d != null) d.deposit(damt); else System.out.println("Not Found!");
                    break;

                case 3:
                    System.out.print("Acc No: "); int wAcc = sc.nextInt();
                    System.out.print("Amount: "); double wamt = sc.nextDouble();
                    Account w = find(wAcc); if (w != null) w.withdraw(wamt); else System.out.println("Not Found!");
                    break;

                case 4:
                    System.out.print("Acc No: "); int sAcc = sc.nextInt();
                    Account s = find(sAcc); if (s != null) s.displayAccountDetails(); else System.out.println("Not Found!");
                    break;

                case 5:
                    System.out.print("Acc No: "); int uAcc = sc.nextInt(); sc.nextLine();
                    Account u = find(uAcc);
                    if (u != null) {
                        System.out.print("New Email: "); String newEmail = sc.nextLine();
                        System.out.print("New Phone: "); String newPhone = sc.nextLine();
                        u.updateContact(newEmail, newPhone);
                        System.out.println("Updated!");
                    } else System.out.println("Not Found!");
                    break;

                case 6: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid Choice!");
            }
        } while (choice != 6);
    }
}