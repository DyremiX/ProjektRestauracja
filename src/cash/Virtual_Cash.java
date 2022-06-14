package cash;

public class Virtual_Cash implements cash_i {
	double worth;
	public Virtual_Cash(double input) {
		worth = input;
	}
	public double worth() {
		return worth;
	}
	public Boolean withdraw(double amount) {
		if(worth >= amount) {
			worth -= amount;
			return true;
			}
		return false;
	}
	public void deposit(double amount) {
		worth += amount;
	}
}
