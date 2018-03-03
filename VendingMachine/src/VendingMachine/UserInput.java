package VendingMachine;

public class UserInput 
{
	private double inputBalance;
	private int inputNickels;
	private int inputDimes;
	private int inputQuarters;
	
	public UserInput()
	{
		inputBalance = 0.00;
		inputNickels = 0;
		inputDimes = 0;
		inputQuarters = 0;
	}

	public double getInputBalance() 
	{
		return inputBalance;
	}
	
	public void resetInputBalance()
	{
		inputBalance = 0.00;
	}

	public void setInputBalance(double inputBalance) 
	{
		this.inputBalance += inputBalance;
	}

	public int getInputNickels() 
	{
		return inputNickels;
	}

	public void setInputNickels() 
	{
		this.inputBalance += 0.05;
		inputNickels++;
	}

	public int getInputDimes() 
	{
		return inputDimes;
	}

	public void setInputDimes() 
	{
		this.inputBalance += 0.10;
		inputDimes++;
	}

	public int getInputQuarters() 
	{
		return inputQuarters;
	}

	public void setInputQuarters() 
	{
		this.inputBalance += 0.25;
		inputQuarters++;
	}
}
