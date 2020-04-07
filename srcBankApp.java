import java.util.Scanner;

public class BankingApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount obj1 = new BankAccount("ConstructorCustName", "ConstructorCustID");
		obj1.showMenu();
	}
}

class BankAccount
{
	int balance;
	int previousTransaction;
	String customerName;
	String customerID;

	BankAccount(String cname, String cid)
	{
		customerName = cname;
		customerID = cid;
	}

	void deposit(int amount)
	{
		if(amount !=0)
		{
			balance = balance+amount;
			previousTransaction = amount;
			getPreviousTransaction();
		}
	}
		
	void withdraw(int amount)
	{
		if(amount != 0)
		{
			if(amount > balance)
			{	
				System.out.println("Balance unavailable to withdraw");
			}
			else if (amount <= balance)
			{
				balance = balance-amount;
				previousTransaction = -amount;
				getPreviousTransaction();
			}
	
		}
	}
		
	void getPreviousTransaction()
	{
		if(previousTransaction > 0)
		{
			System.out.println("Deposited: "+previousTransaction);
		}
		else if (previousTransaction < 0)
		{
			System.out.println("Withdrawn: " + Math.abs(previousTransaction));
		}
		else
		{
			System.out.println("No transaction occured");
		}
	}

	void showMenu()
	{
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		String menu = 
				"\nA. Check Balance"+
				"\nB. Deposit"+
				"\nC. Withdraw"+
				"\nD. Previous Valid Transaction"+
				"\nE. Exit";

	System.out.println("Welcome "+customerName+"\nYour ID is "+customerID);
		do
		{
			System.out.println(menu);
			System.out.println("============================================================================================================");
			System.out.println("Enter an Option");
			System.out.println("============================================================================================================");
			option = Character.toUpperCase(scanner.next().charAt(0));
			System.out.println("\n");
			
		switch(option)
		{
			case 'A': 
				System.out.println("-------------------------------------------------");
				System.out.println("Balance = "+balance);
				System.out.println("-------------------------------------------------");
				break;
			
			case 'B':
				System.out.println("-------------------------------------------------");
				System.out.println("Enter an amount to deposit:");
				System.out.println("-------------------------------------------------");
				int amount = scanner.nextInt();
				deposit(amount);
				System.out.println("\n");
				break;
			
			case 'C':
				System.out.println("-------------------------------------------------");
				System.out.println("Enter an amount to withdraw:");
				System.out.println("-------------------------------------------------");
				int amount2 = scanner.nextInt();
				withdraw(amount2);
				System.out.println("\n");
				break;

			case 'D':
				System.out.println("-------------------------------------------------");
				getPreviousTransaction();
				System.out.println("-------------------------------------------------\n");
				break;
			
			case 'E':
				System.out.println("****************************************************");
				break;
				
			default:
				System.out.println("Invalid Option!! Please try again");
				break;
		}	
		}while(option != 'E');
		scanner.close();
		System.out.println("Thank you for using our services!");
	}
}
