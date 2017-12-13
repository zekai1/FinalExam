/**
 * 
 */
package pkgEmpty;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgCore.Retirement;

/**
 * @author author123
 * 2017-12-12
 */
public class RetirementTest {

	@Test
	public void test() {
		int iYearsToWork = 40;
		double dAnnualReturnWorking = 0.07;
		int iYearsRetired = 20;
		double dAnnualReturnRetired = 0.02;
		double dRequiredIncome = 10000;
		double dMonthlySSI = 2642;
		Retirement rt = new Retirement(iYearsToWork, dAnnualReturnWorking, iYearsRetired, dAnnualReturnRetired, dRequiredIncome, dMonthlySSI);
	
		System.out.println(rt.AmountToSave());
		System.out.println(rt.TotalAmountSaved());
	}

}
