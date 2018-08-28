package com.ericsson.enk.demo.conhashmap.cpcmdata;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class CpcmOfferPricesCatalog {
	
	BigInteger sdpaOfferId;
    String campaignId;
    BigInteger cpcmOfferId;
    List<CpcmPriceCatalog> prices = new ArrayList<CpcmPriceCatalog>();
    public CpcmOfferPricesCatalog(){
    	
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CpcmOfferPricesCatalog [sdpaOfferId=").append(sdpaOfferId)
				.append(", campaignId=").append(campaignId)
				.append(", cpcmOfferId=").append(cpcmOfferId)
				.append(", prices=");
				for(int i = 0; i < prices.size();i++){
					builder.append(prices.get(i).toString());	
				}		
				builder.append("]");
		return builder.toString();
	}
	
	public static String getKey(CpcmOfferPricesCatalog catalog){
		return getKey(catalog.sdpaOfferId);
	}
	
	public static String getKey(BigInteger  sdpaOfferId){
		return sdpaOfferId+"";
	}
    public BigInteger getSdpaOfferId() {
		return sdpaOfferId;
	}

    public void setSdpaOfferId(BigInteger sdpaOfferId) {
		this.sdpaOfferId = sdpaOfferId;
	}

    public String getCampaignId() {
		return campaignId;
	}

    public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}

    public BigInteger getCpcmOfferId() {
		return cpcmOfferId;
	}

    public void setCpcmOfferId(BigInteger cpcmOfferId) {
		this.cpcmOfferId = cpcmOfferId;
	}

    public List<CpcmPriceCatalog> getPrices() {
		return prices;
	}

    public void setPrices(List<CpcmPriceCatalog> prices) {
		this.prices = prices;
	}		
	
}
