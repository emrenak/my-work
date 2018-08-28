package com.ericsson.enk.demo.conhashmap.cpcmdata;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Hello world!
 *
 */
public class App 
{
	
	private static SecureRandom random = new SecureRandom();

	  public static String nextSessionId() {
	    return new BigInteger(130, random).toString(32);
	  }
	  
    public static void main( String[] args )
    {
    	GregorianCalendar gcal = new GregorianCalendar();
    	gcal.setTime(new Date());
    	
    	ConcurrentHashMap<String,CpcmOfferPricesCatalog> cpcmOfferPricesMap = new ConcurrentHashMap<String, CpcmOfferPricesCatalog>();
    	
    for (int i = 0; i < 30000; i++) {
    	CpcmOfferPricesCatalog cop = new CpcmOfferPricesCatalog();
    	cop.setCampaignId("2132312.3123.3123");
    	cop.setCpcmOfferId(new BigInteger("25369"));
    	cop.setSdpaOfferId(new BigInteger("312312"));
    	for (int k = 0; k < 2; k++) {
     	   CpcmPriceCatalog c = new CpcmPriceCatalog();
     	   c.setFeeType(new BigInteger("1"));
     	   try {
 			c.setIntervalEndDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal));
 			c.setIntervalStartDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal));
 			c.setLowerRangeLimit(new BigInteger("2"));
 			c.setUpperRangeLimit(new BigInteger("3"));
 			c.setPaymentType(new BigInteger("2"));
 			c.setPriceValue(new BigDecimal("10.0"));
 		} catch (DatatypeConfigurationException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
     	  cop.getPrices().add(c);
       }
     // System.out.println("Put data");
      cpcmOfferPricesMap.put(nextSessionId(), cop);
      
	}
    
    try {
        System.out.println("Map filled");
 		Thread.sleep(100000000);
 	} catch (InterruptedException e) {
 		// TODO Auto-generated catch block
 		e.printStackTrace();
 	}
    }
}
