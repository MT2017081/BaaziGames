interface OnlineAccount {
	final int basePrice = 100;
	final int regularPrice = 200;
	final int exclusivePrice = 250;	
}


public class Account implements OnlineAccount, Comparable<Account> {

	String ownerName;
	int noOfRegularMovies;
	int noOfExclusiveMovies;
	
	public Account() {}
	
	public Account(String ownerName, int noOfRegularMovies, int noOfExclusiveMovies) {
		this.ownerName = ownerName;
		this.noOfRegularMovies = noOfRegularMovies;
		this.noOfExclusiveMovies = noOfExclusiveMovies;
	}
	
	int monthlyCost() {
		return basePrice + noOfRegularMovies*regularPrice + noOfExclusiveMovies*exclusivePrice;
	} 
	
	@Override
	public int compareTo(Account account) {
		// TODO Auto-generated method stub
		
		if (this.monthlyCost() == account.monthlyCost()) {
			return 0;
		}
		else if (this.monthlyCost() > account.monthlyCost()) {
			return 1;
		}
		else {
			return -1;
		}
	}

	@Override
	public String toString() {
		return "Owner is [" + ownerName + "] " + "and monthly cost is [" + monthlyCost() + "]";
	}
	
}
