package cash;

interface cash_i{
	public double worth();
}

public class Cash implements cash_i {
	double [][] cash_denomination;
	public Cash(int ... x) {
		cash_denomination = new double [][]{{0.01,0.02,0.05,0.1,0.2,0.5,1.0,2.0,5.0,10.0,20.0,50.0,100.0,200.0,500.0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
			for(int i = 0; i<15 ; i++) {
				cash_denomination[1][i] = x[i];
				}
	}
	
	public double worth(){
		double worth = 0;
		for(int i = 0 ; i<15 ; i++) {
			worth += cash_denomination[0][i] * cash_denomination[1][i];
		}
		return worth;
	}
}
