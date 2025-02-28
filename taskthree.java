import java.util.Scanner;
    class BankAccount {
        private double balance;

        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            balance += amount;
            System.out.println("Deposit successful. Current balance: $" + balance);
        }

        public boolean withdraw(double amount) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawal successful. Current balance: $" + balance);
                return true;
            } else {
                System.out.println("Insufficient balance. Current balance: $" + balance);
                return false;
            }
        }
    }

    class ATM {
        private BankAccount account;
        private Scanner scanner;

        public ATM(BankAccount account) {
            this.account = account;
            this.scanner = new Scanner(System.in);
        }

        public void displayMenu() {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
        }

        public void run() {
            int choice;
            do {
                displayMenu();
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            checkBalance();
                            break;
                        case 2:
                            deposit();
                            break;
                        case 3:
                            withdraw();
                            break;
                        case 4:
                            System.out.println("Exiting ATM. Thank you!");
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // Clear the invalid input
                    choice = 0; // to loop again
                }

            } while (choice != 4);
            scanner.close();
        }

        private void checkBalance() {
            System.out.println("Current balance: $" + account.getBalance());
        }

        private void deposit() {
            System.out.print("Enter amount to deposit: $");
            if (scanner.hasNextDouble()) {
                double amount = scanner.nextDouble();
                if (amount > 0) { // Validate deposit amount
                    account.deposit(amount);
                } else {
                    System.out.println("Invalid deposit amount. Please enter a positive value.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }

        }

        private void withdraw() {
            System.out.print("Enter amount to withdraw: $");
            if (scanner.hasNextDouble()) {
                double amount = scanner.nextDouble();
                if (amount > 0) { // Validate withdrawal amount
                    account.withdraw(amount);
                } else {
                    System.out.println("Invalid withdrawal amount. Please enter a positive value.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
    }

        public class taskthree {
        public static void main(String[] args) {
            BankAccount myAccount = new BankAccount(1000); // Initial balance
            ATM atm = new ATM(myAccount);
            atm.run();
        }
    }
