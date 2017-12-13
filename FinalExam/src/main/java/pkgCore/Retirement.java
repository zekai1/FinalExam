package pkgCore;

public class Retirement {

	private int iYearsToWork;
	private double dAnnualReturnWorking;
	private int iYearsRetired;
	private double dAnnualReturnRetired;
	private double dRequiredIncome;
	private double dMonthlySSI;

	// TODO: Build the contructor, getters and setters for the attributes above.

	/**
	 * @param iYearsToWork
	 * @param dAnnualReturnWorking
	 * @param iYearsRetired
	 * @param dAnnualReturnRetired
	 * @param dRequiredIncome
	 * @param dMonthlySSI
	 */
	public Retirement(int iYearsToWork, double dAnnualReturnWorking, int iYearsRetired, double dAnnualReturnRetired,
			double dRequiredIncome, double dMonthlySSI) {
		super();
		this.iYearsToWork = iYearsToWork;
		this.dAnnualReturnWorking = dAnnualReturnWorking;
		this.iYearsRetired = iYearsRetired;
		this.dAnnualReturnRetired = dAnnualReturnRetired;
		this.dRequiredIncome = dRequiredIncome;
		this.dMonthlySSI = dMonthlySSI;
	}

	public static double presentValue(double f, double p, double r, double n) {
		p = f / Math.pow(1 + r, n);
		return p;
	}

	public double AmountToSave() {
		// TODO: Determine the amount to save each month based on
		// TotalAmountSaved, YearsToWork
		// and Annual return while working
		double future = TotalAmountSaved();
		double annualRate = dAnnualReturnWorking;
		double numberOfYears = iYearsToWork;
		double present = 0.0;
		present = presentValue(future, present, annualRate, numberOfYears);
		return present;
	}

	public double TotalAmountSaved() {
		// TODO: Determine amount to be saved based on Monthly SSI, Required
		// Income, Annual return during retirement
		// and number of years retired.
		//

		
		double rate = dAnnualReturnRetired;
		double term = iYearsRetired;
		double amount = (dRequiredIncome-dMonthlySSI) * iYearsRetired;
		
		return PMT(rate, term, amount);
	}
	
	private double PMT(double rate,double term,double financeAmount)
	{
	    double v = (1+(rate/12)); 
	    double t = (-(term/12)*12); 
	    double result=(financeAmount*(rate/12))/(1-Math.pow(v,t));
	    return result;
	}
}
