package VendingMachine;

import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * 
 * Brandon Alfred
 * Hw2
 *
 */

public class Main 
{

	public static void main(String[] args) 
	{
		/**
		 * Creating objects for classes
		 */
		VendingMachine v = new VendingMachine();
		UserInput u = new UserInput();
		Scanner s = new Scanner(System.in);
		DecimalFormat f = new DecimalFormat("0.00");
		
		/**
		 * Bool variable to control vending machine program
		 */
		boolean vendingMachineOn = true;
		
		System.out.println("Hello! Welcome to Brandon Alfred's Vending Machine.\n");
		
		while(vendingMachineOn)
		{
			System.out.println("Main Menu\n");
			
			/**
			 * Inventory calls
			 */
			v.getProductInventory();
			v.getCoinInventory();
			
			System.out.println("\nWhat would you like to do? (Press 1, 2, 3, or 9)");
			System.out.println("1. Order Soda ($1.50)");
			System.out.println("2. Order Candy ($1.00)");
			System.out.println("3. Admin Mode");
			System.out.println("9. EXIT VENDING MACHINE");
			
			/**
			 * orderInput = variable to get input of order
			 * coinInput = variable to get input of coins
			 */
			int orderInput = s.nextInt();
			int coinInput;
		
			switch(orderInput)
			{
				case 1 :
					coinInput = 0;
					
					/**
					 * Set temporary coins to 0
					 */
					v.setTempCoins();
					
					/**
					 * Reset the balance of coins that were put in to vending machine
					 */
					u.resetInputBalance();
					
					while(coinInput != 9)
					{
						System.out.println("\nEnter your coins (press 1, 2, 3, or 9)");
						System.out.println("Amount you've entered so far: $" + f.format(u.getInputBalance()));
						System.out.println("Price of a Soda is $1.50");
						
						System.out.println("1. Nickel");
						System.out.println("2. Dime");
						System.out.println("3. Quarter");
						System.out.println("9. DONE");
						
						coinInput = s.nextInt();
						
						if(coinInput == 1)
						{
							/**
							 * Keeping track of user balance as coins are put in
							 */
							u.setInputNickels();
							
							/**
							 * Keeping a temporary count of what type of coins are being put in
							 */
							v.addTempNickels();
						}	
						else if(coinInput == 2)
						{
							u.setInputDimes();
							v.addTempDimes();
						}
						else if(coinInput == 3)
						{
							u.setInputQuarters();
							v.addTempQuarters();
						}
						else if(coinInput == 9)
						{
							if(v.sodaSoldOut())
							{
								/**
								 * If soda is sold out, return coins
								 */
								System.out.println("Sorry, we are currently out of sodas");
								System.out.println("Coins returned\n");
								u.resetInputBalance();
							}
							else if(u.getInputBalance() == v.getSodaPrice())
							{
								System.out.println("Congrats! You got a Soda.");
								
								/**
								 * User put in the exact amount needed.
								 * Officially add the coins that the user put in, into the vending machine.
								 */
								v.setNickels(v.getTempNickels());
								v.setDimes(v.getTempDimes());
								v.setQuarters(v.getTempQuarters());
								
								/**
								 * Subtract 1 from stock
								 */
								v.setSodas(-1);
							}
							else if(u.getInputBalance() > v.getSodaPrice())
							{
								System.out.println("Congrats! You got a Soda (Plus Change).");
								v.setNickels(v.getTempNickels());
								v.setDimes(v.getTempDimes());
								v.setQuarters(v.getTempQuarters());
								
								/**
								 * Calculating change needed
								 * Adjusting final count of coins in vending machine after change given to user
								 * 
								 */
								Change c = new Change(u.getInputBalance() - v.getSodaPrice());
								c.calculateChange(v);
								
								v.setSodas(-1);
							}
							else
							{
								System.out.println("Sorry.....You haven't put in enough for a soda. Coins returned.\n");
								u.resetInputBalance();
							}	
						}
					}
					
					break;
				
				case 2 :
					coinInput = 0;
					v.setTempCoins();
					u.resetInputBalance();
					
					while(coinInput != 9)
					{
						System.out.println("\nEnter your coins (press 1, 2, 3, or 9)");
						System.out.println("Amount you've entered so far: $" + f.format(u.getInputBalance()));
						System.out.println("Price of a piece of Candy is $1.00");
						
						System.out.println("1. Nickel");
						System.out.println("2. Dime");
						System.out.println("3. Quarter");
						System.out.println("9. DONE");
						
						coinInput = s.nextInt();
						
						if(coinInput == 1)
						{
							u.setInputNickels();
							v.addTempNickels();
						}	
						else if(coinInput == 2)
						{
							u.setInputDimes();
							v.addTempDimes();
						}
						else if(coinInput == 3)
						{
							u.setInputQuarters();
							v.addTempQuarters();
						}
						else if(coinInput == 9)
						{
							if(v.candySoldOut())
							{
								System.out.println("Sorry, we are currently out of candy");
								System.out.println("Coins returned\n");
								u.resetInputBalance();
							}
							else if(u.getInputBalance() == v.getCandyPrice())
							{
								System.out.println("Congrats! You got a piece of Candy.");
								v.setNickels(v.getTempNickels());
								v.setDimes(v.getTempDimes());
								v.setQuarters(v.getTempQuarters());
								
								v.setCandy(-1);
							}
							else if(u.getInputBalance() > v.getCandyPrice())
							{
								System.out.println("Congrats! You got a piece of Candy (Plus Change).");
								v.setNickels(v.getTempNickels());
								v.setDimes(v.getTempDimes());
								v.setQuarters(v.getTempQuarters());
								
								Change c = new Change(u.getInputBalance() - v.getCandyPrice());
								c.calculateChange(v);
								
								v.setCandy(-1);
							}
							else
							{
								System.out.println("Sorry.....You haven't put in enough for a piece of Candy. Coins returned.\n");
								u.resetInputBalance();
							}	
						}
					}
					
					break;
					
				case 3:
					int adminModeInput = 0;
					
					while(adminModeInput != 9)
					{
						System.out.println("----Welcome to Admin Mode----\n");
						
						v.getProductInventory();
						v.getCoinInventory();
						
						System.out.println("Menu (Press 1,2, or 9)");
						System.out.println("1. Restock");
						System.out.println("2. Remove Coins");
						System.out.println("9. EXIT ADMIN MODE");
						
						adminModeInput = s.nextInt();
						
						if(adminModeInput == 1)
						{
							v.restock();
							System.out.println("Vending Machine has been restocked");
						}
						else if(adminModeInput == 2)
						{
							v.removeCoins();
							System.out.println("All Coins in the vending machine have been taken");
						}
					}
					
					break;
					
				case 9:
					vendingMachineOn = false;
					break;
			}
		}
	}
}
