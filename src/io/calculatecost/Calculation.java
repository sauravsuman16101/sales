package io.calculatecost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Calculation
{
	private static List<ItemSpecification> itemList = new ArrayList<>();
	private static Logger LOGGER = Logger.getLogger("Calculation");

	public static void main(String[] args) throws IOException
	{
        LOGGER.info("Enter item details");
        getItemDetails();
        for(ItemSpecification i: itemList)
	    {
	        	double salesTax = TaxCalculation.calculateTax(i.getType(), i.getPrice());
	        	double finalPrice = i.getQuantity() * ( i.getPrice() + salesTax );
	        	LOGGER.info("name: " + i.getName());
			    LOGGER.info("price: " + Double.toString(i.getPrice()));
				LOGGER.info("sales tax liability per item: " + Double.toString(salesTax));
				LOGGER.info("finalPrice: " +	Double.toString(finalPrice));
				LOGGER.info("-----------------------------------------------------------------------");
	    }
	}
	
	public static void getItemDetails() throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		 LOGGER.info("-name: " );
		 String name = reader.readLine();
		 LOGGER.info("-price: ");
		 String price = reader.readLine();
		 LOGGER.info("-quantity: ");
		 String quantity = reader.readLine();
		 LOGGER.info("-type(Raw, Manufactured, Imported): " );
		 String type = reader.readLine();
		 ItemSpecification item = new ItemSpecification(name,Double.valueOf(price), Integer.valueOf(quantity), type);
		 itemList.add(item);
		 LOGGER.info("Do you want to add details of any other item(y/n):");
		 String nextItem = reader.readLine();
		 if(nextItem.equalsIgnoreCase("y"))
		 { 
			 getItemDetails();
			 
		 }
		
		 
	}
}
