//package FinalExam_Barbershop;

public class Service {
	private
		String _serviceName;
		int _servicePrice;
		
	
	//Constructors:
	public Service( String serviceName, int servicePrice) {
		this._serviceName = serviceName;
		this._servicePrice = servicePrice;
	}
	
	public Service() {
		this._serviceName = " ";
		this._servicePrice = 0;
	}
	
	//Copy Constructor:
	public Service( Service other) {
		this._serviceName = other.getServiceName();
		this._servicePrice = other.getServicePrice();
	}
	
	//Setters and Getters:
	public String getServiceName () {return this._serviceName;}
	
	public int getServicePrice() {return this._servicePrice;}
	
	public void setName(String serviceName){ this._serviceName = serviceName;}
	
	public void setPrice(int servicePrice) {this._servicePrice = servicePrice;}
	
	public Service getService (){
		Service s = new Service();
		s.setName(this.getServiceName());
		s.setPrice(this.getServicePrice());
		
		return s;
	}
	
	public void setService (Service other) {
		this._serviceName= other.getServiceName();
		this._servicePrice= other.getServicePrice();
	}
	
    @Override
	public String toString() {
		return "The Service is:" +this.getServiceName() +"The Price of the service:" +this.getServicePrice();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
