
public class Employee {

		private String name;
		private double ytdPay;
		public static int numEmployees;
		
		public Employee() {			
			name = "";
			ytdPay = 0.0;
			numEmployees++;					
		}//end empty-argument constructor

		public Employee(String name) {
			this.name = name;
			ytdPay = 0.0;
			numEmployees++;
		}//preferred constructor
		
		public double calcPay(double annualSalary) {
			double pay = annualSalary / 26;
			ytdPay+=pay;
			return pay;
		}
		public double calcPay(double hoursWorked, double hourlyPay) {
			double pay = hoursWorked * hourlyPay;
			ytdPay+=pay;
			return pay;
		}
		
		
		@Override
		public String toString() {
			return "Employee [name=" + name + ", ytdPay=" + ytdPay + "]";
		}



		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getYtdPay() {
			return ytdPay;
		}		
}
