import java.util.Scanner;

public class ATM {
	private BankAccount account;

	private ATM(BankAccount account) {
		this.account = account;
	}

	public void displayMenu() {
		Scanner scanner = new Scanner(System.in);
		int choice = 0;

		do {
			System.out.println("\nATM Menu: ");
			System.out.println("1. Check Balance");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				checkBalance();
				break;
			case 2:
				deposit(scanner);
				break;
			case 3:
				withdraw(scanner);
				break;
			case 4:
				System.out.println("Thankyou for using the ATM. Goodbye!");
				break;
			default:
				System.out.println("Invalid choice. Please try again");

			}
		} while (choice != 4);

		scanner.close();

	}

	public void checkBalance() {
		System.out.println("Your current balance is: $" + account.getBalance());
	}

	public void deposit(Scanner scanner) {
		System.out.print("Enter the amount to deposit: $");
		double amount = scanner.nextDouble();
		if (account.deposit(amount)) {
			System.out.println("Successfully deposited $" + amount);

		} else {
			System.out.println("Invalid deposit amount,");
		}
	}

	public void withdraw(Scanner scanner) {
		System.out.print("Enter the amount to withdraw: $");
		double amount = scanner.nextDouble();
		if (account.withdraw(amount)) {
			System.out.println("Successfully withdrew $" + amount);
		} else {
			System.out.println("Insufficient balance or invalid withdrawal amount.");
		}
	}

	public static void main(String[] args) {
		BankAccount account = new BankAccount(500); // Initial balance
		ATM atm = new ATM(account);
		atm.displayMenu();

	}

}
