import java.util.*;

public class atm {

    String nm;
    long acc;
    String dob;
    long num;
    double balance = 0.0; // New balance field

    public static void main(String[] args) {
        System.out.println("**************************");
        System.out.println("******** Welcome! ********");
        System.out.println("**************************");
        System.out.println("******** JAVA ATM ********");
        System.out.println("**************************");


        atm atm = new atm();
        atm.menu(); 
        //In the whole menu() function; the all data like Add customer
        // view customer details, deposit, withdraw or exit are stored in this function.
    }

    public void menu() {
        Scanner s = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customer Details");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = s.nextInt();

            switch (choice) {
                case 1:
                    addCustomer(s);
                    break;
                case 2:
                    viewCustomer();
                    break;
                case 3:
                    deposit(s);
                    break;
                case 4:
                    Withdraw(s);
                case 5:
                    System.out.println("Thank you for using the Java ATM. Visit Again!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 5);

        s.close();
    }

    public void addCustomer(Scanner s) {
        s.nextLine(); // Consume leftover newline

        System.out.println("Enter your name (NAME/MIDDLE_NAME/SUR_NAME): ");
        nm = s.nextLine();

        System.out.println("Enter your account number: ");
        acc = s.nextLong();

        s.nextLine(); // Consume newline left-over
        System.out.println("Enter your Date of Birth (DD/MM/YYYY): ");
        dob = s.nextLine();

        System.out.println("Enter your mobile number: ");
        num = s.nextLong();

        balance = 0.0; // Initialize balance to 0 for new customer

        System.out.println("\nCustomer added successfully!");
    }

    public void viewCustomer() {
        if (nm == null) {
            System.out.println("No customer data found. Please add a customer first.");
        } else {
            System.out.println("\n--- Customer Details ---");
            System.out.println("Name: " + nm);
            System.out.println("Account Number: " + acc);
            System.out.println("Date of Birth: " + dob);
            System.out.println("Mobile Number: " + num);
            System.out.println("Account Balance: $" + balance);
        }
    }

    public void deposit(Scanner s) {
        if (nm == null) {
            System.out.println("No customer data found. Please add a customer first.");
            return;
        }

        System.out.println("Enter the account number for Verfication: ");
        long inputAcc= s.nextLong();

        

        if (inputAcc != acc) {
            System.out.println("Account number does not match. Deposit Failed");
            return;
        }else{
            System.out.println("The Verfication of account number is done.");
        }

        System.out.print("Enter the amount to deposit: $");
        double amount = s.nextDouble();

        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }
    public void Withdraw(Scanner s){
        if (nm == null) {
            System.out.println("No money in the account. Please add the money in the account first.");
            return;
        }

        System.out.println("Enter the account number for verification: ");
        long inputAcc=s.nextLong();
        

        if (inputAcc != acc) {
            System.out.println("Account number does not match. Withdraw Failed");
        }else{
            System.out.println("The Verfication of account number is done.");
            
            System.out.println("Available balance: $"+balance);

            System.out.println("Enter the amount to withdraw(Multiples of 100): $");
            double amount = s.nextDouble();

            if (amount<=0) {
                System.out.println("Invalid amount. Please enter a positive value.");
            } else if (amount % 100 !=0) {
                System.out.println("Please enter the amount in multiples of 100.");
            }else if (amount>balance) {
                System.out.println("Insufficient balance. Withdrawal failed.");
            }else{
                balance -= amount;
                System.out.println("Withdrawal Successful! Remaining balance: $"+balance);   
            }
        }
    }
}