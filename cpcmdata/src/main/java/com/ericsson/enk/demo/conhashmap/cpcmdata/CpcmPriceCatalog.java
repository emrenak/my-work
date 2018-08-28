package com.ericsson.enk.demo.conhashmap.cpcmdata;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.xml.datatype.XMLGregorianCalendar;

public class CpcmPriceCatalog {

	BigDecimal priceValue;
    BigInteger feeType;
    BigInteger paymentType;
    XMLGregorianCalendar intervalStartDate;
    XMLGregorianCalendar intervalEndDate;
    BigInteger upperRangeLimit;
    BigInteger lowerRangeLimit;		

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CpcmPriceCatalog [priceValue=").append(priceValue)
				.append(", feeType=").append(feeType)
				.append(", paymentType=").append(paymentType)
				.append(", intervalStartDate=").append(intervalStartDate)
				.append(", intervalEndDate=").append(intervalEndDate)
				.append(", upperRangeLimit=").append(upperRangeLimit)
				.append(", lowerRangeLimit=").append(lowerRangeLimit)				
				.append("]");
		return builder.toString();
	}
	
	public CpcmPriceCatalog() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getPriceValue() {
		return priceValue;
	}


	public void setPriceValue(BigDecimal bigDecimal) {
		this.priceValue = bigDecimal;
	}


	public BigInteger getFeeType() {
		return feeType;
	}


	public void setFeeType(BigInteger feeType) {
		this.feeType = feeType;
	}


	public BigInteger getPaymentType() {
		return paymentType;
	}


	public void setPaymentType(BigInteger paymentType) {
		this.paymentType = paymentType;
	}


	public XMLGregorianCalendar getIntervalStartDate() {
		return intervalStartDate;
	}


	public void setIntervalStartDate(XMLGregorianCalendar intervalStartDate) {
		this.intervalStartDate = intervalStartDate;
	}


	public XMLGregorianCalendar getIntervalEndDate() {
		return intervalEndDate;
	}


	public void setIntervalEndDate(XMLGregorianCalendar intervalEndDate) {
		this.intervalEndDate = intervalEndDate;
	}


	public BigInteger getUpperRangeLimit() {
		return upperRangeLimit;
	}


	public void setUpperRangeLimit(BigInteger upperRangeLimit) {
		this.upperRangeLimit = upperRangeLimit;
	}


	public BigInteger getLowerRangeLimit() {
		return lowerRangeLimit;
	}


	public void setLowerRangeLimit(BigInteger lowerRangeLimit) {
		this.lowerRangeLimit = lowerRangeLimit;
	}


	
	
}
