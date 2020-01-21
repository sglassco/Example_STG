
public class testEmployee {

	public static void main(String[] args) {
		
		Employee bob = new Employee("Bob Emmert");
		System.out.println(bob.toString());
		System.out.println(Employee.numEmployees);
		
		Employee rick = new Employee("Rick Ross");
		System.out.println(rick.toString());
		System.out.println(Employee.numEmployees);
		
		double pay = rick.calcPay(65000);
		System.out.println(pay);
		System.out.println(rick.getYtdPay());
		pay = rick.calcPay(65000);
		System.out.println(rick.getYtdPay());
		
		pay = bob.calcPay(37.5, 12.60);
		pay = bob.calcPay(37.5, 12.60);
		System.out.println(pay);
		System.out.println(bob.getYtdPay());
		
	}//end main
}//end class
