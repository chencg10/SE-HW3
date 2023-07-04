package BarberShop;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Iterator;



//------------------------ Team 8 ------------------------
//Members:
//1. 208955732 - Chen Cohen Gershon
//2. 208010785 - Shoham Galili
//3. 213486764 - Hadas Yosef-Zada
//4. 207812421 - Avidan Menashe
//---------------------------------------------------------

public class BarberShop {

	private
		Calander _calendar;
		CashRegister _cashRegister;
		ArrayList <Customer> _customersList;
		ArrayList <Service> _servicesList;
		
		
	//Default constructor:
	public BarberShop() {
		this._calendar = new Calander();
		this._cashRegister = new CashRegister();
		this._customersList = new ArrayList <Customer>();
		this._servicesList = new ArrayList <Service>();
		// load services from file
		this.loadServices();
	}

	private void loadServices() {
		// Load services from file separated by ',' and add them to the services list
		try {
			// Read the file
			File file = new File("src/BarberShop/servicsDateBase.txt");

			Scanner scanner = new Scanner(file);
			// iterate over the lines in the file
			while (scanner.hasNextLine()) {
				String row = scanner.nextLine();

				String[] values = row.split(",");
				//add service to the list
				this._servicesList.add(
						new Service(values[0], Integer.parseInt(values[1]), Integer.parseInt(values[2]))
				);
			}
			scanner.close();
		}
		// Catch exception if file not found
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	//Copy Constructor:
	public BarberShop(BarberShop other) {
		this._calendar = other.getCalendar();
		this._cashRegister = other.getCashRegister();
		this._customersList = other.getCustomersList();
		this._servicesList =other.getServiceList();
	}
	
	//The func add a new service to the Barbershop:
	void addService(Service service) {
		this._servicesList.add(service);
		
	}
	
	//The func remove a service from the Barbershop:
	void removeService(Service service) {
		int servicesSize = this._servicesList.size();
		
		if( servicesSize == 0) {
	        System.out.println("The services list is empty. Cant remove the service");
	        return;
		}
		
	    if (this._servicesList.contains(service)) {
	        this._servicesList.remove(service);
	        System.out.println("Service removed successfully.");
	    }
	    else {
	        System.out.println("Service not found in the services list. Please try again.");
	    }
	
	}
	
	//The func add new customer to the customer List:	
	public void addCustomer(Customer customer) {
		this._customersList.add(customer);
	
	}
	
	//The func remove a customer to the customer List:
	void removeCustomer(Customer customer) {
		int customersSize = this._customersList.size();
		
		if( customersSize == 0) {
	        System.out.println("The customers list is empty. Cant remove the customer");
	        return;
		}
		
		 if (this._customersList.contains(customer)) {
		        this._customersList.remove(customer);
		        System.out.println("Customer removed successfully.");
		    }
		    else {
		        System.out.println("Customer not found in the customers list. Please try again.");
		    }
	}


	// Search for a treatment in the treatments list by name
	public Service getServiceByName(String name) {
		for (int i = 0; i < this._servicesList.size(); i++) {
			if (this._servicesList.get(i).getServiceName().equalsIgnoreCase(name)) {
				return this._servicesList.get(i);
			}
		}
		return null;
	}

	// retrun list of services names:
	public String[] getServicesNames() {
		String[] servicesNames = new String[this._servicesList.size()];
		for (int i = 0; i < this._servicesList.size(); i++) {
			servicesNames[i] = this._servicesList.get(i).getServiceName();
		}
		return servicesNames;
	}
	
	//Setters and Getters:
	public Calander getCalendar() {return this._calendar;}
	
	public CashRegister getCashRegister() {return this._cashRegister;}
	
	public ArrayList<Customer> getCustomersList() {return this._customersList;}

	public ArrayList<Service> getServiceList() {return this._servicesList;}

	public void setCalendar (Calander calendar) {this._calendar = calendar;}
	
	public void setCashRegister (CashRegister cashRegister) {this._cashRegister = cashRegister;}

	public void setCustomersList ( ArrayList <Customer> customersList) {this._customersList = customersList;}
	
	public void setServicesList ( ArrayList <Service> servicesList) {this._servicesList = servicesList;}

	public boolean isCustomerExists(String name) {
		for (int i = 0; i < this._customersList.size(); i++) {
			if (this._customersList.get(i).getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}

	public Customer getCustomerByName(String name) {
		for (int i = 0; i < this._customersList.size(); i++) {
			if (this._customersList.get(i).getName().equalsIgnoreCase(name)) {
				return this._customersList.get(i);
			}
		}
		return null;
	}

	public Customer getCustomerByPhoneNum(String newPhoneNumber) {
		for (int i = 0; i < this._customersList.size(); i++) {
			if (this._customersList.get(i).getPhoneNumber().equals(newPhoneNumber)) {
				return this._customersList.get(i);
			}
		}
		return null;
	}

	public Customer getCustomerByCreditCard(String creditCardNumber) {
		for (int i = 0; i < this._customersList.size(); i++) {
			if (this._customersList.get(i).getCreditCard().getCardNumber().equals(creditCardNumber)) {
				return this._customersList.get(i);
			}
		}
		return null;
	}

	public Customer getCustomerByService(Service service) {
		for (int i = 0; i < this._customersList.size(); i++) {
			if (this._customersList.get(i).getCurrentService().getServiceName().equals(service)) {
				return this._customersList.get(i);
			}
		}
		return null;
	}

	public Customer getCustomerByCVV(String creditCardNumber) {
		for (int i = 0; i < this._customersList.size(); i++) {
			if (this._customersList.get(i).getCreditCard().getCvv().equals(creditCardNumber)) {
				return this._customersList.get(i);
			}
		}
		return null;
	}


	// Sort the linked list by name:
	public int sortByName()
	{
		// We will sort the linked list using bubble sort

		//check if the list is empty:
		if ( this._customersList.size() == 0)
		{
			// The list is empty -1
			return -1;
		}
		// check if the list has only one element:
		else if (this._customersList.size() == 1) {
			System.out.println("The list has only one element, nothing to sort");
			return 0;
		}
		else
		{
			//sort using lambda expression
			this._customersList.sort((Customer c1, Customer c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
			return 0;
		}
	}

//	@Override
//	public String toString() {
//		String s = "";
//		s = "Calendar: " + this._calendar.toString() + " Cash Register: " + this._cashRegister.toString() +"\n"
//				+"The customers of the BarberShop:";
//
//		for( int i=0; i<= this._customersList.size(); i++) {
//			Customer customer = this._customersList.get(i); // Accessing the customer at index i
//
//			// Example: Appending customer information to the string
//			s += " Customer " + i + ": " + customer.toString();
//		}
//
//		s+= "\n The services of the BarberShop:";
//
//		for( int i=0; i<= this._servicesList.size(); i++) {
//			Service service = this._servicesList.get(i); // Accessing the customer at index i
//
//			// Example: Appending customer information to the string
//			s += " Service " + i + ": " + service.toString();
//		}
//	}
}
