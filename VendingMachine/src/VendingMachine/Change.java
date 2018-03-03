package VendingMachine;

import java.text.DecimalFormat;

public class Change 
{
	private double change;
	private int remainingAmount;
	private int numOfNickels;
	private int numOfDimes;
	private int numOfQuarters;
	
	public Change(double n)
	{
		change = n;
		
		numOfNickels = 0;
		numOfDimes = 0;
		numOfQuarters = 0;
	}
	
	public void calculateChange(VendingMachine v)
	{
		remainingAmount = (int)(change * 100);
		
		numOfQuarters = remainingAmount / 25;
		remainingAmount %= 25;
		
		numOfDimes = remainingAmount / 10;
		remainingAmount %= 10;
		
		numOfNickels = remainingAmount / 5;
		remainingAmount %= 5;
		
		/**
		 * Vending Machine is passed to this method.
		 * If a coin is to be returned as change,
		 * subtract the amount of coins from the vending machine
		 */
		if(numOfQuarters != 0)
			v.setQuarters(-numOfQuarters);
		
		if(numOfDimes != 0)
			v.setDimes(-numOfDimes);
		
		if(numOfNickels != 0)
			v.setNickels(-numOfNickels);
		
		printChange();
	}
	
	public void printChange()
	{
		DecimalFormat f = new DecimalFormat("0.00");
		System.out.println("Your change is $" + f.format(change) + ":");

		if(numOfQuarters != 0)
			System.out.println(numOfQuarters + " Quarters");
		
		if(numOfDimes != 0)
			System.out.println(numOfDimes + " Dimes");
		
		if(numOfNickels != 0)
			System.out.println(numOfNickels + " Nickels");
	}

}
