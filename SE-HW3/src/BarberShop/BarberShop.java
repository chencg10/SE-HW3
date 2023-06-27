package BarberShop;
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
	void addCustomer(Customer customer) {
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
	
	//Setters and Getters:
	public Calander getCalendar() {return this._calendar;}
	
	public CashRegister getCashRegister() {return this._cashRegister;}
	
	public ArrayList<Customer> getCustomersList() {return this._customersList;}

	public ArrayList<Service> getServiceList() {return this._servicesList;}

	public void setCalendar (Calander calendar) {this._calendar = calendar;}
	
	public void setCashRegister (CashRegister cashRegister) {this._cashRegister = cashRegister;}

	public void setCustomersList ( ArrayList <Customer> customersList) {this._customersList = customersList;}
	
	public void setServicesList ( ArrayList <Service> servicesList) {this._servicesList = servicesList;}
	
	
//    @Override
//	public String toString() {
//		String s = new String();
//		s= "Calendar:" +Calendar.toString() +"CashRegister" +CashRegister.toString();
//		for( int i=0; i<= this._customersList.size(); i++) {
//			this._customersList<Customer>[i] =
//
//
//		}
//	}
//
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// check our code
		CreditCard cc = new CreditCard("1234567891011121", "123");
		Service s = new Service("Haircut", 50, 10);
		Customer c = new Customer("Chen", "0502003245", cc, 1, s);
		// create barber shop
		BarberShop bs = new BarberShop();
		// add customer to barber shop
		bs.addCustomer(c);
		Date date = new Date("2023/06/27");
		// add event to calendar
		bs.getCalendar().addEvent(new ManEvent(date, 15, c, true));

		// add service to barber shop
		bs.addService(s);
		// add another service to barber shop
		bs.addService(new Service("Beard Trim", 20, 5));
		// add another service to barber shop
		bs.addService(new Service("Haircut and Beard Trim", 60, 15));


		System.out.println(bs.getCustomersList().get(0).toString());
		System.out.println(bs.getCustomersList().get(0).getCreditCard().toString());


		for (int i = 0; i < bs.getServiceList().size(); i++) {
			System.out.println(bs.getServiceList().get(i).toString());
		}

		bs.getCalendar().printAllEvents();
		System.out.println(bs.getCashRegister().toString());
	}
}
