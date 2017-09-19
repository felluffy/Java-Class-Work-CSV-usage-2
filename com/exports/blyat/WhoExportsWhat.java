package com.exports.blyat;
import org.apache.commons.csv.*;
import edu.duke.*;

public class WhoExportsWhat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//.System.out.println("BLYAT");
		WhoExportsWhat test = new WhoExportsWhat(); 
		test.testWhoExports();
	}
	
	void whoExports(String item, CSVParser parser)
    {
        for(CSVRecord record : parser)
        {
            if(record.get("Exports").contains(item))
                System.out.println(record.get("Country"));
        }
    }
    
    String countryInfo(String country, CSVParser parser)
    {
        for(CSVRecord record : parser)
        {
            //System.out.println(record.get("Country"));
            if(record.get("Country").contains(country))
                //System.out.println(y);
                return new String(record.get("Country") + ": " + record.get("Exports") + ": " + record.get("Value (dollars)"));
        }
        return "Not Found";
    }
    
    int numberOfExporters(CSVParser parser, String exportItem)
    {
    	int numberOfCountries = 0;
        for(CSVRecord record : parser)
        {
            if(record.get("Exports").contains(exportItem))
            {
                System.out.println(record.get("Country"));
                ++numberOfCountries;
            }
        }
        return numberOfCountries;
    }
    
    void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2)
    {
    	System.out.println("Counries exporting two products are: ");
    	for(CSVRecord record : parser)
        {
            //System.out.println(record.get("Country"));
            if(record.get("Exports").contains(exportItem1) && record.get("Exports").contains(exportItem2))
                System.out.print(record.get("Country") + " ");
                //return new String(record.get("Country") + ": " + record.get("Exports") + ": " + record.get("Value (dollars)"));
        }
    	System.out.println();
    }
    
    void bigExporters(CSVParser parser, String amountInCash)
    {
    	String amountWOCommas = "";
    	//int bigExportersAmount = 0;
    	long originalAmount = 0;
    	long currentCash = 0;
    	if(amountInCash.charAt(0) == '$')
    	{
    		String exportersValue = "";
    		
    		amountWOCommas = amountInCash.replaceAll("," , ""); //delete all instances of commas
    		originalAmount = Long.valueOf(amountWOCommas.substring(1));
    		//amountWOCommas = amountWOCommas.toString(originalAmount);
    		for(CSVRecord record : parser)
    		{
    			exportersValue = record.get("Value (dollars)");
    			exportersValue = exportersValue.replaceAll("," , "");
    			currentCash = Long.valueOf(exportersValue.substring(1));
    			//System.out.println(currentCash);
    			if(currentCash >= originalAmount)
    			{	
    				//bigExportersAmount++;
    				System.out.println(record.get("Country") + " " + record.get("Value (dollars)"));
    			}
            }
    		//amountInCash.replaceAll(, arg1)
    	}
    	//return bigExportersAmount;
    }
    
    
    void testWhoExports()
    {
        FileResource fr = new FileResource();
        
        CSVParser parser = fr.getCSVParser();
        System.out.println(countryInfo("Germany", parser));
        //whoExports("coffee", parser);
        
        //String amountInCash = "$450,514,512";
        //amountInCash = amountInCash.replaceAll(",", "");
        //System.out.println(Integer.valueOf(amountInCash.substring(1)));
        
        parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "gold", "diamonds");
        
        String testItem = "gold";
        parser = fr.getCSVParser();
        int numberOfCountries = numberOfExporters(parser, testItem);
        System.out.println("Number of countries who exports " + testItem + " are: " + numberOfCountries);
        
        parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999");
        
    }

}
