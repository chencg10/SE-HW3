package BarberShop;
// For using strings in Java
import java.lang.String;
import java.util.Scanner;


public class Customer
{
	private String _name;
	private String _phoneNumber;
	private CreditCard _customerCreditCard;
	private int _gender;

	private Service _currService;

	// FEMALE =0 MALE =1 לשאול לגבי זה
	//what about full name?
	public static final int FEMALE = 0;
	public static final int MALE = 1;

	//this function is used to check if the name of the customer contain only letters
	private boolean isValidName(String name)
	{
		//return true only if the name contains only letters
		return name.matches("[a-zA-Z]+");
	}

	//this function is used to check if the phone number of the customer contain only letters
	private boolean isValidPhoneNumber(String phoneNumber)
	{
		return phoneNumber.matches("\\d+") && phoneNumber.length()==10;
	}


	//gets
	public String getName()
	{
		return this._name;
	}

	public String getPhoneNumber()
	{
		return this._phoneNumber;
	}

	public CreditCard getCreditCard()
	{
		return this._customerCreditCard;
	}

	public int getGender(){return this._gender;}


	//sets
	public void setName(String name)
	{
		//if the name is legal update the variable of the name
		if(isValidName(name))
		{
			this._name=name;
		}

		// if the name is illegal print an error and ask for the use to enter new name
		else
		{
			 System.out.println("Invalid name. Please try again.");
			 Scanner scanner = new Scanner(System.in);
			while(true)
			{
				 System.out.print("Enter the name of customer: ");
				 String input = scanner.nextLine();
				 if (isValidName(input))
				 {
						this._name = input;
						break;
				 }
				 else
				 {
					 System.out.println("Invalid name. Please try again.");
				 }
			}
		}
	}

	public void setPhone(String phoneNumber)
	{
		//if the phone number is legal update the variable of the name
			if(isValidPhoneNumber(phoneNumber))
			{
				this._phoneNumber=phoneNumber;
			}

			// if the phone number is illegal print an error and ask for the use to enter new name
			else
			{
				 System.out.println("Invalid phone number. Please try again.");
				 Scanner scanner = new Scanner(System.in);
				while(true)
				{
					 System.out.print("Enter the phone number of customer: ");
					 String input = scanner.nextLine();
					 if (isValidName(input))
					 {
							this._phoneNumber = input;
							break;
					 }
					 else
					 {
						 System.out.println("Invalid phone number. Please try again.");
					 }
				}
			}
	}

	//constructor
	public Customer(String name, String phoneNumber, CreditCard customerCreditCard, int gender)
	{
		this._customerCreditCard=new CreditCard(customerCreditCard);

		//if the phone number is legal update the variable of the name
		if(isValidPhoneNumber(phoneNumber))
		{
			this._phoneNumber=phoneNumber;
		}

		// if the phone number is illegal print an error and ask for the use to enter new name
		else
		{
			 System.out.println("Invalid phone number. Please try again.");
			 Scanner scanner = new Scanner(System.in);
			while(true)
			{
				 System.out.print("Enter the phone number of customer: ");
				 String input = scanner.nextLine();
				 if (isValidName(input))
				 {
						this._phoneNumber = input;
						break;
				 }
				 else
				 {
					 System.out.println("Invalid phone number. Please try again.");
				 }
			}
		}
		//set gender
		//check if gender is valid:
		if(gender != MALE && gender != FEMALE)
		{

			Scanner scanner = new Scanner(System.in);
			while (true)
			{
				System.out.println("Wrong gender, please try again");
				gender = scanner.nextInt();
				if (gender == MALE || gender == FEMALE)
				{
					break;
				}
			}
		}
		this._gender = gender;
	}

	//copy constructor
	public Customer(Customer other)
	{
		this._name = other._name;
		this._phoneNumber = other._phoneNumber;
		this._customerCreditCard = new CreditCard(other._customerCreditCard);
		this._gender = other._gender;
	}


}
