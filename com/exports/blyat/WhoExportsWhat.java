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
    
    void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2)
    {
    	for(CSVRecord record : parser)
        {
            //System.out.println(record.get("Country"));
            if(record.get("Exports").contains(exportItem1) && record.get("Exports").contains(exportItem2))
                System.out.println(record.get("Country"));
                //return new String(record.get("Country") + ": " + record.get("Exports") + ": " + record.get("Value (dollars)"));
        }
    }
    
    void testWhoExports()
    {
        FileResource fr = new FileResource();
        
        CSVParser parser = fr.getCSVParser();
        //whoExports("coffee", parser);
        System.out.println(countryInfo("Germany", parser));
        
        parser = fr.getCSVParser();
        listExporterswoProducts(parser, "gold", "diamonds");
        
    }

}
