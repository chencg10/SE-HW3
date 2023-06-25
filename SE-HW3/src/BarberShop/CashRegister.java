package BarberShop;

public class CashRegister {

    private int _totalBalance = 0;
    private int _totalExpenses = 0;


    // Constructor
    public CashRegister() {


    }

    // Getters
    // get the current total balance of the cash register
    public int getTotalBalance() {
        return _totalBalance;
    }
    //get the current total expenses of the barber shop
    public int getTotalExpenses() {
        return _totalExpenses;
    }

    public void addPayment(Customer customer) {
        //find the payment amount from the customer
//        Service currentService = customer.getCurrentService();
//        int paymentAmount = currentService.getServicePrice();
//        // get also the expenses of the barber shop for the service
//        int expenses = currentService.getServiceExpenses();

        // update the total balance of the cash register
//        _totalBalance += paymentAmount;
//        // update the total expenses of the cash register
//        _totalExpenses += expenses;
//
//        // notify the user of the cash register that a payment has been made successfully
//        System.out.println("Payment of " + paymentAmount + " has been made successfully by " + customer.getName());
//        // thank the customer for the payment
//        System.out.println("Thank you for your payment " + customer.getName() + "and see you again soon!");
    }

    public void subPayment(Customer customer) {
        //find the payment amount from the customer
//        Service currentService = customer.getCurrentService();
//        int paymentAmount = currentService.getServicePrice();
//        // get also the expenses of the barber shop for the service
//        int expenses = currentService.getServiceExpenses();

//        // update the total balance of the cash register
//        _totalBalance -= paymentAmount;
//        // update the total expenses of the cash register,
//        // we add the expenses to the total expenses because we are refounding the customer
//        _totalExpenses += expenses;
//
//        // notify the user of the cash register that a payment has been made successfully
//        System.out.println("Refound of " + paymentAmount + " has been made successfully for " + customer.getName());
//        // thank the customer for the payment
//        System.out.println("Thanks " + customer.getName() + "and see you again soon!");
    }

    @Override
    public String toString() {
        // get the current date and time
        java.util.Date date = new java.util.Date();
        // return the current date and time, the total balance and the total expenses of the cash register till now
        return "Date :" +  date.toString() + "\nTotal Balance: " + _totalBalance + "\nTotal Expenses: " + _totalExpenses;
    }
}
