package io.calculatecost;

public class TaxCalculation
{
	public static double calculateTax(String type, double price)
	{
		if(type.equals("Raw"))
		{
			return getRawTypeTax(price);
		}
		else if(type.equals("Manufactured"))
		{
			return getManufacturedTypeTax(price);
		}
		else if(type.equals("Imported"))
		{
			return getImportedTypeTax(price);
		}
		return 0;
	}
	
	public static double getRawTypeTax(double price)
	{
		double totalTax = 12.5 * (price/100);
		return totalTax;
	}
	
	public static double getManufacturedTypeTax(double price)
	{
		double totalTax = getRawTypeTax(price) + 2 * ((getRawTypeTax(price) + price)/100);
		return totalTax;
	}
	
	public static double getImportedTypeTax(double price)
	{
		double importDuty = 10 * (price/100);
		double totalTax;
		double surcharge = 0;
		if((importDuty + price) <= (double) 100)
		{
			surcharge = 5;
		}
		else if(price > (double) 100 && price <= (double) 200)
		{
			surcharge = 10 ;
		}
		else if(price > 200)
		{
			surcharge = 5 * (price/100);
		}
		
		totalTax = importDuty + surcharge;
		return totalTax;			
	}
}
