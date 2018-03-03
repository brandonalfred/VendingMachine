package VendingMachine;

public class VendingMachine 
{
	private int nickels;
	private int dimes;
	private int quarters;
	private int tempNickels;
	private int tempDimes;
	private int tempQuarters;
	private double sodaPrice = 1.50;
	private double candyPrice = 1.00;
	private int sodas;
	private int candy;
	
	public VendingMachine()
	{		
		nickels = 5;
		dimes = 5;
		quarters = 5;
		setSodas(5);
		setCandy(5);
	}
	
	public void setTempCoins()
	{
		tempNickels = 0;
		tempDimes = 0;
		tempQuarters = 0;
	}

	public int getNickels() 
	{
		return nickels;
	}

	public void setNickels(int n) 
	{
		this.nickels += n;
	}
	
	public void addTempNickels()
	{
		tempNickels++;
	}
	
	public int getTempNickels()
	{
		return tempNickels;
	}

	public int getDimes() 
	{
		return dimes;
	}

	public void setDimes(int n) 
	{
		this.dimes += n;
	}
	
	public void addTempDimes()
	{
		tempDimes++;
	}
	
	public int getTempDimes()
	{
		return tempDimes;
	}

	public int getQuarters() 
	{
		return quarters;
	}

	public void setQuarters(int n) 
	{
		this.quarters += n;
	}
	
	public void addTempQuarters()
	{
		tempQuarters++;
	}
	
	public int getTempQuarters()
	{
		return tempQuarters;
	}

	public double getSodaPrice() 
	{
		return sodaPrice;
	}

	public void setSodaPrice(double sodaPrice) 
	{
		this.sodaPrice = sodaPrice;
	}

	public double getCandyPrice() 
	{
		return candyPrice;
	}

	public void setCandyPrice(double candyPrice) 
	{
		this.candyPrice = candyPrice;
	}
	
	public int getTotalCoins()
	{
		return (getNickels() + getDimes() + getQuarters());
	}

	public int getSodas() 
	{
		return sodas;
	}

	public void setSodas(int sodas) 
	{
		this.sodas += sodas;
	}

	public int getCandy() 
	{
		return candy;
	}

	public void setCandy(int candy) 
	{
		this.candy += candy;
	}
	
	public void getProductInventory()
	{
		if(sodaSoldOut() == true)
			System.out.println("Soda is SOLD OUT");
		else
			System.out.println("We currently have " + getSodas() + " Soda(s)");
		
		if(candySoldOut() == true)
			System.out.println("Candy is SOLD OUT");
		else
			System.out.println("We currently have " + getCandy() + " piece(s) of candy");
	}
	
	public void getCoinInventory()
	{
		System.out.println("\nThere are curently " + getTotalCoins() + " coins in the vending machine");
		System.out.println(getNickels() + " Nickels");
		System.out.println(getDimes() + " Dimes");
		System.out.println(getQuarters() + " Quarters");
	}
	
	public void removeCoins()
	{
		nickels = 0;
		dimes = 0;
		quarters = 0;
	}
	
	public void restock()
	{
		sodas = 5;
		candy = 5;
	}
	
	public boolean sodaSoldOut()
	{
		if(getSodas() > 0)
			return false;
		
		return true;
	}
	
	public boolean candySoldOut()
	{
		if(getCandy() > 0)
			return false;
		
		return true;
	}
}
