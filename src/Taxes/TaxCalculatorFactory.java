package Taxes;

import Personnel.*;

public class TaxCalculatorFactory {
	public static TaxCalculator create(Employee employee) {
		if(employee instanceof FullTimeEmployee) {
			return new FullTimeTaxCalculator();
		}
		
		if(employee instanceof PartTimeEmployee) {
			return new PartTimeTaxCalculator();
		}
		
		if(employee instanceof Intern) {
			return new InternTaxCalculator();
		}
		
		throw new RuntimeException("InvalidEmployeeType");
	}
}
